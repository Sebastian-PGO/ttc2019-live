package ttc2019.solutions.aof.helpers

import java.util.Map
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import ttc2019.live.changes.AttributePropertyChange
import ttc2019.live.changes.CompositionListDeletion
import ttc2019.live.changes.CompositionListInsertion
import ttc2019.live.changes.CompositionMoveToList
import ttc2019.live.changes.ModelChange
import ttc2019.live.changes.ModelChangeSet

class ApplyChanges {

	static def prettyPrint(ModelChange change) {
		val changeS = '''«change.eClass.name»(«change.eResource.getURIFragment(change)»)'''
		switch change {
			CompositionListDeletion: {
				'''«changeS» at «change.affectedElement».«change.feature.name»[«change.index»]'''
			}
			CompositionListInsertion: {
				'''«changeS» at «change.affectedElement».«change.feature.name»[«change.index»] of «change.addedElement»'''
			}
			AttributePropertyChange: {
				'''«changeS» of «change.affectedElement».«change.feature.name» to «change.newValue»]'''
			}
			CompositionMoveToList: {
				'''«changeS» at «change.affectedElement».«change.feature.name»[«change.index»] of «change.movedElement»'''
			}
			default: throw new IllegalArgumentException('''unsupported change type: «change»''')
		}
	}

	// returns false is propagation failed because of a detected inconsistency
	static def apply(ModelChange change, Map<EObject, EObject> tracabilityLinks) {
		try {
			switch change {
				CompositionListDeletion: {
					val target = tracabilityLinks.get(change.affectedElement).eGet(change.feature) as EList<?>
					target.remove(change.index)
				}
				CompositionListInsertion: {
					val target = tracabilityLinks.get(change.affectedElement).eGet(change.feature) as EList<EObject>
					target.add(change.index, change.addedElement)
				}
				AttributePropertyChange: {
					tracabilityLinks.get(change.affectedElement).eSet(change.feature, change.newValue)
				}
				CompositionMoveToList: {
					val target = tracabilityLinks.get(change.affectedElement).eGet(change.feature) as EList<EObject>
					target.move(change.index, tracabilityLinks.get(change.movedElement))
				}
			}
		} catch(Exception e) {
			if(e.message !== null) {
				if(e.message.startsWith("inconsistency: ")) {
					println('''«e.message» for change: «prettyPrint(change)»''')
					if(e.message.startsWith("inconsistency: ignored: ")) {
						return true
					} else {
						return false
					}
				}
			} else {
				throw new RuntimeException('''propagation failure for change: «change.prettyPrint»''', e)
			}
		}
		return true
	}

	// returns the number of detected inconsistencies that made propagation fail
	static def apply(ModelChangeSet changes, Map<EObject, EObject> tracabilityLinks) {
		var ret = 0
		for (change : changes.changes) {
			if(!apply(change, tracabilityLinks)) {
				ret++
			}
		}
		ret
	}
}