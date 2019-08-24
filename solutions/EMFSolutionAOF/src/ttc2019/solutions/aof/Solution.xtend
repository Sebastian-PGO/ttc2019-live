package ttc2019.solutions.aof

import java.util.HashMap
import java.util.Map
import java.util.concurrent.atomic.AtomicInteger
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EContentAdapter
import ttc2019.live.bibtex.BibTeXFile
import ttc2019.live.changes.ModelChangeSet
import ttc2019.solutions.aof.helpers.ApplyChanges

class Solution {
	val BibTeXFile source
	val ttc2019.live.docbook.DocBook referenceTarget
	val ModelChangeSet changes
	var ttc2019.live.docbook.DocBook target
	val Map<EObject, EObject> traceabilityLinks = new HashMap

	new(BibTeXFile source, ttc2019.live.docbook.DocBook docbook, ModelChangeSet changes) {
		this.source = source
		this.referenceTarget = docbook
		this.changes = changes
	}

	def int execute() {
		// observing source changes to count propagated inconsistencies
		val nbSourceChanges = new AtomicInteger
		source.eAdapters.add(new EContentAdapter {
			override notifyChanged(Notification n) {
				super.notifyChanged(n)
				nbSourceChanges.incrementAndGet
			}
		})

		// performing changes, which triggers propagation, and getting the number of non-propagable
		// inconsistencies
		val nbNonPropInconsistencies = ApplyChanges.apply(changes, traceabilityLinks)

		nbSourceChanges.get + nbNonPropInconsistencies
	}

	def transform() {
		val transfo = new BibTeX2DocBook

		target = transfo.Main.forwardApply(source)

		// saving the target (for debugging purposes)
//		val rs = new ResourceSetImpl
//		rs.resourceFactoryRegistry.extensionToFactoryMap.put("docbook", new XMIResourceFactoryImpl)
//		val r = rs.createResource(URI.createFileURI('''«source.eResource.URI.path».docbook'''))
//		r.contents.add(target)
//		r.save(Collections.emptyMap)
	}

	def generateTraceabilityLinks() {
		val referenceArticles = referenceTarget.books.get(0).articles.get(0)
		val ourArticles = target.books.get(0).articles.get(0)

		traceabilityLinks.put(referenceTarget, target)
		traceabilityLinks.put(referenceArticles, ourArticles)

		referenceArticles.sections_1.forEach[refSec |
			val ourSec = ourArticles.sections_1.findFirst[id == refSec.id]
			val refParaByContent = new HashMap<String, EObject>

			traceabilityLinks.put(refSec, ourSec)
			refSec.paras.forEach[refParas | refParaByContent.put(refParas.content, refParas)]
			ourSec.paras.forEach[ourPars |
				traceabilityLinks.put(refParaByContent.get(ourPars.content), ourPars)
			]
		]
	}
}