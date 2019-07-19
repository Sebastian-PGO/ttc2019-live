package ttc2019.solutions.xtend

import java.util.List
import ttc2019.live.changes.AttributePropertyChange
import ttc2019.live.changes.CompositionListDeletion
import ttc2019.live.changes.CompositionListInsertion
import ttc2019.live.changes.CompositionMoveToList
import ttc2019.live.changes.ModelChange
import ttc2019.live.changes.ModelChangeSet
import ttc2019.live.docbook.DocBook
import ttc2019.live.docbook.Para
import ttc2019.live.docbook.Sect1
import ttc2019.live.docbook.Section

class Solution {
	
	 DocBook docBookTarget
	 ModelChangeSet changeSet
	 Boolean followingEVL
	 
	 new (Boolean followingEVL, DocBook docBookTarget, ModelChangeSet changeSet)
	 {
	 	this.docBookTarget = docBookTarget
	 	this.changeSet = changeSet
	 	this.followingEVL = followingEVL
	 }
	 
	 def int execute()
	 {
		val nb = this.changeSet.changes.map[it.executeChange].reduce[p1, p2 | p1 + p2]
		System.err.println("Problems detected = " + nb)
		nb
	 }
	 
	 def int executeChange(ModelChange change)
	 {
	 	var problems = 0
	 	
	 	switch change {
	 		AttributePropertyChange: {
		 		problems = change.ruleAttributePropertyChange
		 	} 
		 	CompositionListDeletion: {
		 		problems = change.ruleCompositionListDeletion
		 	} 
		 	CompositionListInsertion: {
		 		problems = change.ruleCompositionListInsertion
		 	}
		 	CompositionMoveToList: {
		 		problems = change.ruleCompositionMoveToList
		 	} 
		 	default: {
		 		printToFile("Error: change " + change + "not supported")
		 	}
	 	}
	 	
	 	problems
	 }
	 
	 def int ruleCompositionMoveToList(CompositionMoveToList change)
	 {
	 	val movedElement = change.movedElement
	 	var problems = 0
	 	
	 	switch movedElement {
	 		Para: {
		 		// Swapping paragraph breaks consistency (except if in reference list)
		 		if(this.followingEVL) {
			 		if(!(movedElement.eContainer as Sect1).title.startsWith("References List")) {
				 		val originalElement = getParas.findFirst[it.id == movedElement.id]
				 		val oldIndex = (originalElement.eContainer as Section).paras.indexOf(originalElement)
				 		problems = Math.abs(oldIndex - change.index)
			 		}
			 	} else {
			 		problems = 1
			 	}
		 		printToFile("Swapping Para : +" + problems)
		 		return problems
		 	} 
		 	Section: {
		 		// Swapping section does not break consistency
		 		// Nothing to do
		 		printToFile("Swapping Section : 0")
		 	}
			default: {
		 		printToFile("Swapping: 0")
		 	}
	 	}

	 	0
	 }
	 
	 def int ruleCompositionListDeletion(CompositionListDeletion change)
	 {
		val deletedElement = change.deletedElement
		var problems = 0
		
		switch deletedElement {
			Para: {
		 		// Deleting paragraph breaks consistency
		 		printToFile("Deleting Para : +1")
		 		return 1
		 	}
		 	Section: {
		 		// Deleting section breaks consistency
		 		if(this.followingEVL) {
		 			problems = 1 + deletedElement.eContents.filter(Para).length
		 		} else {
		 			problems = 1
		 		}
		 		printToFile("Deleting Section : +" + problems)
		 		return problems
		 	} 
		 	default: {
		 		printToFile("Deleting: 0")
		 	}
		}

	 	0
	 }
	 
	 def int ruleAttributePropertyChange(AttributePropertyChange change)
	 {	
	 	if(change.newValue.startsWith(change.oldValue)) {
	 		// Appending text to a paragraph does not break consistency
	 		// Nothing to do
	 		printToFile("Appending text: 0")
	 	} else {
	 		println("Appending: 0")
	 	}
	 	
	 	0
	 }
	 
	 def int ruleCompositionListInsertion(CompositionListInsertion change)
	 {
	 	val addedElement = change.addedElement
	 	
	 	if(addedElement instanceof Para) {
	 		val p = change.addedElement as Para
	 		if(p.eContainer instanceof Sect1) {
	 			if(p.hasMatchingAuthor || p.hasMatchingTitle || p.hasMatchingJournal) {
	 				// Adding paragraph breaks consistency if it matches one author, journal, or title in its Sect1
	 				printToFile("Adding paragraph: +1")
	 				return 1
	 			} else {
	 				printToFile("Adding: 0")
	 			}
	 		} else {
 				printToFile("Adding: 0")
 			}
	 	} else {
			printToFile("Adding: 0")
		}
	 	
	 	0
	 }

	 static List<Sect1> cached_sect1 = null
	 static List<Para> cached_paras = null
	 static Sect1 cached_sect1_authors = null
	 static Sect1 cached_sect1_titles = null
	 static Sect1 cached_sect1_journals = null
	 static DocBook cached_docbook = null
	 
	 def getParas()
	 {
	 	if(this.docBookTarget != cached_docbook || cached_docbook === null || cached_paras === null) {
	 		cached_paras = this.docBookTarget.eAllContents.filter(Para).toList
	 		cached_docbook = this.docBookTarget
	 	}
	 	cached_paras
	 }
	 
	 def getSect1()
	 {
	 	if(this.docBookTarget != cached_docbook || cached_docbook === null || cached_sect1 === null) {
	 		cached_sect1 = this.docBookTarget.eAllContents.filter(Sect1).toList
	 		cached_docbook = this.docBookTarget
	 	}
	 	cached_sect1
	 }
	 
	 def getAuthors()
	 {
	 	if(this.docBookTarget != cached_docbook || cached_docbook === null || cached_sect1_authors === null) {
	 		cached_sect1_authors = getSect1.findFirst[it.title.startsWith("Authors list")]
	 	}
	 	cached_sect1_authors
	 }
	 
	 def getTitles()
	 {
	 	if(this.docBookTarget != cached_docbook || cached_docbook === null || cached_sect1_titles === null) {
	 		cached_sect1_titles = getSect1.findFirst[it.title.startsWith("Titles list")]
	 	}
	 	cached_sect1_titles
	 }
	 
	 def getJournals()
	 {
	 	if(this.docBookTarget != cached_docbook || cached_docbook === null || cached_sect1_journals === null) {
	 		cached_sect1_journals = getSect1.findFirst[it.title.startsWith("Journals list")]
	 	}
	 	cached_sect1_journals
	 }
	 
	 def hasMatchingAuthor(Para p)
	 {
	 	getAuthors.paras.exists[p.content.contains(it.content)]
	 }
	 
	 def hasMatchingTitle(Para p)
	 {
	 	getTitles.paras.exists[p.content.contains(it.content)]
	 }
	 
	  def hasMatchingJournal(Para p)
	 {
	 	getJournals.paras.exists[p.content.contains(it.content)]
	 }

	 def static printToFile(String s) {
	 	System.err.println("\t" + s)
	 }

}