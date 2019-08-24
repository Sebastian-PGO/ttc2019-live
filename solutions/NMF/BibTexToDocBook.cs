using NMF.Synchronizations;
using NMF.Expressions.Linq;
using System;
using System.Linq;
using System.Collections.Generic;
using System.Text;
using TTC2019.LiveContest.Metamodels.Bibtex;
using TTC2019.LiveContest.Metamodels.Docbook;
using NMF.Collections.ObjectModel;
using NMF.Expressions;
using NMF.Collections.Generic;

namespace TTC2019.LiveContest
{
    class BibTexToDocBookSynchronization : ReflectiveSynchronization
    {
        public class BibTexToDocBook : SynchronizationRule<BibTeXFile, DocBook>
        {
            public override bool ShouldCorrespond(BibTeXFile left, DocBook right, ISynchronizationContext context)
            {
                return true;
            }

            protected override DocBook CreateRightOutput(BibTeXFile input, IEnumerable<DocBook> candidates, ISynchronizationContext context, out bool existing)
            {
                existing = false;
                return new DocBook()
                {
                    Books =
                    {
                        new TTC2019.LiveContest.Metamodels.Docbook.Book()
                        {
                            Id = "book",
                            Articles =
                            {
                                new TTC2019.LiveContest.Metamodels.Docbook.Article()
                                {
                                    Title = "BibTeXML to DocBook",
                                    Sections_1 =
                                    {
                                        new Sect1()
                                        {
                                            Id = "se1",
                                            Title = "References List"
                                        },
                                        new Sect1()
                                        {
                                            Id = "se2",
                                            Title = "Authors list"
                                        },
                                        new Sect1()
                                        {
                                            Id = "se3",
                                            Title = "Titles List"
                                        },
                                        new Sect1()
                                        {
                                            Id = "se4",
                                            Title = "Journals List"
                                        }
                                    }
                                }
                            }
                        }
                    }
                };
            }

            private static IOrderedSetExpression<IPara> GetSection(DocBook docBook, string name)
            {
                var section = docBook.Books.Single().Articles.Single().Sections_1.AsEnumerable().FirstOrDefault(sec => sec.Title == name);
                if (section != null)
                {
                    return section.Paras;
                }
                else
                {
                    return new ObservableOrderedSet<IPara>();
                }
            }

            public override void DeclareSynchronization()
            {
                SynchronizeMany(SyncRule<ReferenceToPara>(),
                    bibTex => bibTex.Entries,
                    docBook => GetSection(docBook, "References List"));

                SynchronizeMany(SyncRule<AuthorToPara>(),
                    bibTex => new PseudoCollection<IAuthor>(bibTex.Entries.OfType<IAuthoredEntry>().SelectMany(entry => entry.Authors).Distinct().OrderBy(a => a.Author_)),
                    docBook => GetSection(docBook, "Authors list"));

                SynchronizeMany(SyncRule<TitledEntryToPara>(),
                    bibTex => new PseudoCollection<ITitledEntry>(bibTex.Entries.OfType<ITitledEntry>().OrderBy(en => en.Title)),
                    docBook => GetSection(docBook, "Titles List"));

                SynchronizeMany(SyncRule<JournalNameToPara>(),
                    bibTex => new PseudoCollection<string>(bibTex.Entries.OfType<TTC2019.LiveContest.Metamodels.Bibtex.IArticle>().Select(article => article.Journal).Distinct().OrderBy(journal => journal)),
                    docBook => GetSection(docBook, "Journals List"));
            }
        }

        public class TitledEntryToPara : SynchronizationRule<ITitledEntry, IPara>
        {
            public override bool ShouldCorrespond(ITitledEntry left, IPara right, ISynchronizationContext context)
            {
                return left.Title == right.Content;
            }
            public override void DeclareSynchronization()
            {
                Synchronize(entry => entry.Title, para => para.Content);
            }
        }

        public class ReferenceToPara : SynchronizationRule<IBibTeXEntry, IPara>
        {
            public override bool ShouldCorrespond(IBibTeXEntry left, IPara right, ISynchronizationContext context)
            {
                return right.Content != null && right.Content.StartsWith($"[{left.Id}]");
            }

            public override void DeclareSynchronization() { }
        }

        public class MiscToPara : SynchronizationRule<Misc, Para>
        {
            public override void DeclareSynchronization()
            {
                MarkInstantiatingFor(SyncRule<ReferenceToPara>());
                SynchronizeLeftToRightOnly(misc => $"[{misc.Id}] Misc", para => para.Content);
            }
        }

        public class UnpublishedToPara : SynchronizationRule<Unpublished, Para>
        {
            public override void DeclareSynchronization()
            {
                MarkInstantiatingFor(SyncRule<ReferenceToPara>());
                SynchronizeLeftToRightOnly(unp => $"[{unp.Id}] Unpublished {unp.Title} {string.Join(' ', unp.Authors.Select(a => a.Author_))}", para => para.Content);
            }
        }

        public class ThesisToPara : SynchronizationRule<IThesisEntry, Para>
        {
            public override void DeclareSynchronization()
            {
                MarkInstantiatingFor(SyncRule<ReferenceToPara>());
                SynchronizeLeftToRightOnly(phd => $"[{phd.Id}] {phd.GetType().Name} {phd.Title}; {string.Join(' ', phd.Authors.Select(a => a.Author_))} {phd.Year} {phd.School}", para => para.Content);
            }
        }

        public class BookToPara : SynchronizationRule<Metamodels.Bibtex.Book, Para>
        {
            public override void DeclareSynchronization()
            {
                MarkInstantiatingFor(SyncRule<ReferenceToPara>());
                SynchronizeLeftToRightOnly(book => $"[{book.Id}] Book {book.Title} {string.Join(' ', book.Authors.Select(a => a.Author_))} {book.Year} {book.Publisher}", para => para.Content);
            }
        }

        public class TechReportToPara : SynchronizationRule<TechReport, Para>
        {
            public override void DeclareSynchronization()
            {
                MarkInstantiatingFor(SyncRule<ReferenceToPara>());
                SynchronizeLeftToRightOnly(report => $"[{report.Id}] TechReport {report.Title} {string.Join(' ', report.Authors.Select(a => a.Author_))} {report.Year}", para => para.Content);
            }
        }

        public class ArticleToPara : SynchronizationRule<Metamodels.Bibtex.Article, Para>
        {
            public override void DeclareSynchronization()
            {
                MarkInstantiatingFor(SyncRule<ReferenceToPara>());
                SynchronizeLeftToRightOnly(article => $"[{article.Id}] Article {article.Title} {string.Join(' ', article.Authors.Select(a => a.Author_))} {article.Year} {article.Journal}", para => para.Content);
            }
        }

        public class ManualToPara : SynchronizationRule<Manual, Para>
        {
            public override void DeclareSynchronization()
            {
                MarkInstantiatingFor(SyncRule<ReferenceToPara>());
                SynchronizeLeftToRightOnly(manual => $"[{manual.Id}] Manual {manual.Title}", para => para.Content);
            }
        }

        public class ProceedingsToPara : SynchronizationRule<Proceedings, Para>
        {
            public override void DeclareSynchronization()
            {
                MarkInstantiatingFor(SyncRule<ReferenceToPara>());
                SynchronizeLeftToRightOnly(proc => $"[{proc.Id}] Proceedings {proc.Title} {proc.Year}", para => para.Content);
            }
        }

        public class BookletToPara : SynchronizationRule<Booklet, Para>
        {
            public override void DeclareSynchronization()
            {
                MarkInstantiatingFor(SyncRule<ReferenceToPara>());
                SynchronizeLeftToRightOnly(booklet => $"[{booklet.Id}] Booklet {booklet.Year}", para => para.Content);
            }
        }

        public class InBookToPara : SynchronizationRule<InBook, Para>
        {
            public override void DeclareSynchronization()
            {
                MarkInstantiatingFor(SyncRule<ReferenceToPara>());
                SynchronizeLeftToRightOnly(book => $"[{book.Id}] Book {book.Title} {string.Join(' ', book.Authors.Select(a => a.Author_))} {book.Year} {book.Publisher} {book.Chapter}", para => para.Content);
            }
        }

        public class InProceedingsToPara : SynchronizationRule<InProceedings, Para>
        {
            public override void DeclareSynchronization()
            {
                MarkInstantiatingFor(SyncRule<ReferenceToPara>());
                SynchronizeLeftToRightOnly(inp => $"[{inp.Id}] InProceedings {inp.Title} {string.Join(' ', inp.Authors.Select(a => a.Author_))} {inp.Year} {inp.Booktitle}", para => para.Content);
            }
        }

        public class InCollectionToPara : SynchronizationRule<InCollection, Para>
        {
            public override void DeclareSynchronization()
            {
                MarkInstantiatingFor(SyncRule<ReferenceToPara>());
                SynchronizeLeftToRightOnly(inc => $"[{inc.Id}] InCollection {inc.Title} {string.Join(' ', inc.Authors.Select(a => a.Author_))} {inc.Year} {inc.Booktitle}", para => para.Content);
            }
        }

        public class JournalNameToPara : SynchronizationRule<string, IPara>
        {
            public override bool ShouldCorrespond(string left, IPara right, ISynchronizationContext context)
            {
                return right.Content == left;
            }
            public override void DeclareSynchronization()
            {
                SynchronizeLeftToRightOnly(name => name, par => par.Content);
            }
        }

        public class AuthorToPara : SynchronizationRule<IAuthor, IPara>
        {
            public override bool ShouldCorrespond(IAuthor left, IPara right, ISynchronizationContext context)
            {
                return left.Author_ == right.Content;
            }
            public override void DeclareSynchronization()
            {
                Synchronize(author => author.Author_, para => para.Content);
            }
        }
    }

    internal class PseudoCollection<T> : CustomCollection<T>
    {
        public PseudoCollection(IEnumerableExpression<T> inner) : base(inner)
        {
        }

        public override void Add(T item)
        {
            throw new NotSupportedException();
        }

        public override void Clear()
        {
            throw new NotSupportedException();
        }

        public override bool Remove(T item)
        {
            throw new NotSupportedException();
        }
    }
}
