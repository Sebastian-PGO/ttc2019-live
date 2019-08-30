package ttc19

import bibtex.Article
import bibtex.Author
import bibtex.AuthoredEntry
import bibtex.BibTeXEntry
import bibtex.BibtexPackage
import bibtex.Book
import bibtex.BookTitledEntry
import bibtex.DatedEntry
import bibtex.InBook
import bibtex.ThesisEntry
import bibtex.TitledEntry
import bibtex.Unpublished
import docbook.DocBook
import docbook.DocbookPackage
import docbook.Para
import docbook.Sect1
import java.util.ArrayList
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.util.EcoreUtil
import yamtl.core.YAMTLModule
import yamtl.dsl.Helper
import yamtl.dsl.Rule

class Bibtex2Docbook extends YAMTLModule {
	val BibTeX = BibtexPackage.eINSTANCE  
	val DocBook = DocbookPackage.eINSTANCE  

	new () {
		header().in('bib', BibTeX).out('doc', DocBook)
		
		helperStore( newArrayList(
			new Helper('AuthorList', [
				new ArrayList(BibTeX.author.allInstances.map[it as Author].groupBy[author].values.map[it.get(0)].sortBy[author])
			]).build,
			new Helper('AuthorSet', [
				BibTeX.author.allInstances.map[it as Author].groupBy[author].values.map[it.get(0)].toSet
			]).build,
			new Helper('ArticleList', [
				new ArrayList(BibTeX.article.allInstances.map[it as Article].groupBy[journal].values.map[it.get(0)].sortBy[journal])
			]).build,
			new Helper('ArticleSet', [
				BibTeX.article.allInstances.map[it as Article].groupBy[journal].values.map[it.get(0)].toSet
			]).build,
			new Helper('TitledEntryList', [
				new ArrayList(BibTeX.titledEntry.allInstances.map[it as TitledEntry].groupBy[title].values.map[it.get(0)].sortBy[title]
				)
			]).build,
			new Helper('TitledEntrySet', [
				BibTeX.titledEntry.allInstances.map[it as TitledEntry].groupBy[title].values.map[it.get(0)].toSet
			]).build
		))
		
		ruleStore( newArrayList(
						
			new Rule('Main') 
				.in('bib', BibTeX.bibTeXFile).build
				.out('doc', DocBook.docBook, [ 
					val doc = 'doc'.fetch as DocBook
					val boo = 'boo'.fetch as docbook.Book
					doc.books += boo
					doc.id = 'doc'
				]).build
				.out('boo', DocBook.book, [
					val boo = 'boo'.fetch as docbook.Book
					val art = 'art'.fetch as docbook.Article
					boo.articles += art
					boo.id = 'book'
				]).build
				.out('art', DocBook.article, [
					val art = 'art'.fetch as docbook.Article
					val se1 = 'se1'.fetch as Sect1
					val se2 = 'se2'.fetch as Sect1
					val se3 = 'se3'.fetch as Sect1
					val se4 = 'se4'.fetch as Sect1
					art.title = 'BibTeXML to DocBook'
					art.sections_1 += #[ se1, se2, se3, se4]
				]).build
				.out('se1', DocBook.sect1, [
					val se1 = 'se1'.fetch as Sect1
					se1.title = 'References List'
					se1.paras += BibTeX.bibTeXEntry.allInstances.sortBy[(it as BibTeXEntry).id].fetch as List<Para>
					se1.id = "se1"
				]).build
				.out('se2', DocBook.sect1, [
					val se2 = 'se2'.fetch as Sect1
					se2.title = 'Authors list'
					val authorList = 'AuthorList'.fetch as List<Author> // fetch helper value
					se2.paras += authorList.fetch as List<Para> // fetch resolved references
					se2.id = "se2"
				]).build
				.out('se3', DocBook.sect1, [
					val se3 = 'se3'.fetch as Sect1
					se3.title = 'Titles List'
					val titleSet = 'TitledEntryList'.fetch as List<TitledEntry> // fetch helper value
					se3.paras += titleSet.fetch('title_para') as List<Para> // fetch resolved references
					se3.id = "se3"
				]).build
				.out('se4', DocBook.sect1, [
					val se4 = 'se4'.fetch as Sect1
					se4.title = 'Journals List'
					val articleList = 'ArticleList'.fetch as List<Article> // fetch helper value
					se4.paras += articleList.fetch('journal_para') as List<Para> // fetch resolved references
					se4.id = "se4"
				]).build
			.build(),
			
			new Rule('Author') // This rule generates a section_2 paragraph for each distinct author.
				.in('a', BibTeX.author).filter[ 
					val a = 'a'.fetch as Author
					val authorSet = 'AuthorSet'.fetch as Set<Author> 
					authorSet.contains(a)
				].build
				.out('author_para', DocBook.para, [ 
					val a = 'a'.fetch as Author 
					val author_para = 'author_para'.fetch as Para
					author_para.content = a.author
					author_para.id = EcoreUtil.generateUUID()
				]).build
			.build(),
			
			new Rule('UntitledEntry') // This rule generates a section_1 paragraph for each untitled entry.
				.in('e', BibTeX.bibTeXEntry).build
				.out('entry_para', DocBook.para, [ 
					val e = 'e'.fetch as BibTeXEntry 
					val entry_para = 'entry_para'.fetch as Para
					
					entry_para.content = e.buildEntryPara
					entry_para.id = EcoreUtil.generateUUID()
				]).build
			.build,
			
			new Rule('TitledEntry_Title_NoArticle')
				.inheritsFrom(#['UntitledEntry'])
				.in('e', BibTeX.titledEntry).filter[ 
					val e = 'e'.fetch as TitledEntry
					val titledEntrySet = 'TitledEntrySet'.fetch as Set<TitledEntry>
					titledEntrySet.contains(e)
				].build
				.out('entry_para', DocBook.para).build
				.out('title_para', DocBook.para, [ 
					val e = 'e'.fetch as TitledEntry 
					val title_para = 'title_para'.fetch as Para
					
					title_para.content = e.title
					title_para.id = EcoreUtil.generateUUID()
				]).build
			.build,
			
			new Rule('Article_NoTitle_Journal') 
				.inheritsFrom(#['UntitledEntry'])
				.in('e', BibTeX.article).filter[ 
					val e = 'e'.fetch as Article
					val articleSet = 'ArticleSet'.fetch as Set<Article>
					articleSet.contains(e)
				].build
				.out('entry_para', DocBook.para).build
				.out('journal_para', DocBook.para, [
					val e = 'e'.fetch as Article 
					val journal_para = 'journal_para'.fetch as Para
					journal_para.content = e.journal
					journal_para.id = EcoreUtil.generateUUID()
				]).build
			.build,
			
			new Rule('Article_Title_Journal') 
				.inheritsFrom(#['TitledEntry_Title_NoArticle', 'Article_NoTitle_Journal'])
				.in('e', BibTeX.article).build
				.out('entry_para', DocBook.para).build
				.out('title_para', DocBook.para).build
				.out('journal_para', DocBook.para).build
			.build
			
		))
	}
	

	def String buildEntryPara(BibTeXEntry entry) {
//		//println (entry.id) 
//		//println (entry.class.simpleName.substring(0,entry.class.simpleName.length-4))
		'''[«entry.id»] «entry.class.simpleName.substring(0,entry.class.simpleName.length-4)»«
		IF entry instanceof TitledEntry» «entry.title»«ENDIF»«
		IF entry instanceof AuthoredEntry» «entry.authors.map[author].join(' ')»«ENDIF»«
		IF entry instanceof DatedEntry» «entry.year»«ENDIF»«
		IF entry instanceof BookTitledEntry» «entry.booktitle»«ENDIF»«
		IF entry instanceof ThesisEntry» «entry.school»«ENDIF»«
		IF entry instanceof Article» «entry.journal»«ENDIF»«
		IF entry instanceof Unpublished» «entry.note»«ENDIF»«
		IF entry instanceof Book» «entry.publisher»«ENDIF»«
		IF entry instanceof InBook» «entry.chapter»«ENDIF»'''
	}	
	
}
