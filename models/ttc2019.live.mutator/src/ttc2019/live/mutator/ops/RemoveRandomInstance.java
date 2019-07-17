package ttc2019.live.mutator.ops;

import java.util.Optional;
import java.util.Random;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import ttc2019.live.changes.ChangesFactory;
import ttc2019.live.changes.CompositionListDeletion;
import ttc2019.live.changes.ModelChangeSet;
import ttc2019.live.docbook.DocBook;

/**
 * Removes one object from the containment tree. To simplify things, assumes the
 * deleted element is only linked to the rest of the model through the
 * containment reference from its eContainer.
 */
public class RemoveRandomInstance extends AbstractMutationOperator {

	private final EClass targetEClass;

	public RemoveRandomInstance(String name, EClass targetEClass, Random rnd) {
		super(name, rnd);
		this.targetEClass = targetEClass;
	}

	@Override
	public void apply(DocBook source, DocBook toMutate, ModelChangeSet changes) {
		final Optional<EObject> oTarget = pickRandomOf(toMutate, targetEClass);
		if (!oTarget.isPresent()) {
			return;
		}
		final EObject toDelete = oTarget.get();

		final String toDeleteFragment = toDelete.eResource().getURIFragment(toDelete);
		final EObject eContainer = toDelete.eContainer();
		final String containerFragment = eContainer.eResource().getURIFragment(eContainer);
		final EReference feature = (EReference) toDelete.eContainingFeature();

		// Apply the change
		int idxTarget = 0;
		if (feature.isMany()) {
			@SuppressWarnings("unchecked")
			final EList<EObject> eList = (EList<EObject>)eContainer.eGet(feature);

			idxTarget = eList.indexOf(toDelete);
			eList.remove(idxTarget);
		} else {
			eContainer.eUnset(feature);
		}

		CompositionListDeletion change = ChangesFactory.eINSTANCE.createCompositionListDeletion();
		change.setAffectedElement(getOriginalObject(containerFragment, source, changes));
		change.setDeletedElement(getOriginalObject(toDeleteFragment, source, changes));
		change.setFeature(feature);
		change.setIndex(idxTarget);
		changes.getChanges().add(change);
	}

}
