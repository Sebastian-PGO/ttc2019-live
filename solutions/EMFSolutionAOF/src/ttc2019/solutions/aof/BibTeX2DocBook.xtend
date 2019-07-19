package ttc2019.solutions.aof

import fr.eseo.aof.exploration.activemap.IActiveMapFactory
import fr.eseo.aof.extensions.AOFExtensions
import java.util.HashMap
import java.util.UUID
import org.eclipse.papyrus.aof.core.AOFFactory
import org.eclipse.papyrus.aof.core.IBox
import org.eclipse.xtend.lib.annotations.Data
import ttc2019.live.bibtex.Article
import ttc2019.live.bibtex.AuthoredEntry
import ttc2019.live.bibtex.BibTeXEntry
import ttc2019.live.bibtex.Book
import ttc2019.live.bibtex.BookTitledEntry
import ttc2019.live.bibtex.DatedEntry
import ttc2019.live.bibtex.InBook
import ttc2019.live.bibtex.ThesisEntry
import ttc2019.live.bibtex.TitledEntry
import ttc2019.live.bibtex.Unpublished

@Data
class BibTeX2DocBook extends DSL implements AOFExtensions {
	extension val BibTeX = new BibTeX
	extension val DocBook = new DocBook
	extension val IActiveMapFactory = IActiveMapFactory.EXPLORATION_INSTANCE

	val randomUUIDCache = new HashMap<Object, String>
	def randomUUID(Object it) {
		randomUUIDCache.computeIfAbsent(it)[
			UUID.randomUUID.toString
		]
	}

	def <C> append(Object e, IBox<String> it, Class<C> c, (C)=>IBox<?> f) {
		if(c.isInstance(e)) {
			zipWith(f.apply(e as C) as IBox<Object>, false, [s, a |
				'''«s» «a»'''
			])[
				throw new UnsupportedOperationException('''inconsistency: unsupported target change: modification of a string concatenation''')
			]
		} else {
			it
		}
	}

	val buildEntryParaCache = new HashMap<BibTeXEntry, IBox<String>>
	def buildEntryPara(BibTeXEntry e) {
		buildEntryParaCache.computeIfAbsent(e)[
			var ret = e._id.collect([id |
				'''[«id»] «e.eClass.name»'''
			])
			[
				throw new UnsupportedOperationException('''inconsistency: unsupported target change: modification of a string concatenation''')
			]

			ret = append(ret, TitledEntry)[_title]
			ret = append(ret, AuthoredEntry)[_authors.author.join(" ")]
			ret = append(ret, DatedEntry)[_year]
			ret = append(ret, BookTitledEntry)[_booktitle]
			ret = append(ret, ThesisEntry)[_school]
			ret = append(ret, Article)[_journal]
			ret = append(ret, Unpublished)[_note]
			ret = append(ret, Book)[_publisher]
			ret = append(ret, InBook)[_chapter]

			ret
		]
	}

	public val Author = new Rule(
		BibTeX.Author,
		DocBook.Para,
		'''inconsistency: ignored: unsupported by transformation: adding a new author'''
	)[a, p1 |
		p1._content <=> a._author
		p1.id = a.randomUUID
	]

	public val Reference = new Rule(
		BibTeX.BibTeXEntry,
		DocBook.Para,
		null
	)[e, p1 |
		p1._content <=> e.buildEntryPara
		p1.id = e.randomUUID
	]

	public val Title = new Rule(
		BibTeX.TitledEntry,
		DocBook.Para,
		'''inconsistency: ignored: unsupported by transformation: adding a new title'''
	)[e, p1 |
		p1._content <=> e._title
		p1.id = e.randomUUID
	]

	public val Journal = new Rule(
		BibTeX.Article,
		DocBook.Para,
		'''inconsistency: ignored: unsupported by transformation: adding a new journal name'''
	)[e, p1 |
		p1._content <=> e._journal
		p1.id = e.randomUUID
	]

	public val Main = new Rule(
		BibTeX.BibTeXFile,
		DocBook.DocBook,
		'''inconsistency: ignored: unsupported by transformation: adding a new root element'''
	)[bib, doc |
		val boo = DocBook.Book.newInstance
		val art = DocBook.Article.newInstance
		val se1 = DocBook.Sect1.newInstance
		val se2 = DocBook.Sect1.newInstance
		val se3 = DocBook.Sect1.newInstance
		val se4 = DocBook.Sect1.newInstance

		doc._books <=> boo.fixed(emptyOrderedSet)
		doc._id <=> "doc".fixed(emptyOne)

		boo._articles <=> art.fixed(emptyOrderedSet)
		boo._id <=> "book".fixed(emptyOne)

		art._title <=> "BibTeXML to DocBook".fixed(emptyOne)
		art._sections_1 <=> AOFFactory.INSTANCE.createOrderedSet(se1, se2, se3, se4)

		se1._title <=> "References List".fixed(emptyOne)
		se1._paras <=>	bib.allContents(BibTeX.BibTeXEntry).sortedBy[
							_id
						].collectTo(Reference)
		se1._id <=> "se1".fixed(emptyOne)

		se2._title <=> "Authors list".fixed(emptyOne)
		se2._paras <=> bib.allContents(BibTeX.Author).uniqueBy[it?._author ?: emptyOne].select[it !== null].sortedBy[_author].collectTo(Author)
		se2._id <=> "se2".fixed(emptyOne)

		se3._title <=> "Titles List".fixed(emptyOne)
		se3._paras <=> bib.allContents(BibTeX.TitledEntry).uniqueBy[it?._title ?: emptyOne].select[it !== null].sortedBy[_title].collectTo(Title)
		se3._id <=> "se3".fixed(emptyOne)

		se4._title <=> "Journals List".fixed(emptyOne)
		se4._paras <=> bib.allContents(BibTeX.Article).uniqueBy[it?._journal ?: emptyOne].select[it !== null].sortedBy[_journal].collectTo(Journal)
		se4._id <=> "se4".fixed(emptyOne)
	]
}
