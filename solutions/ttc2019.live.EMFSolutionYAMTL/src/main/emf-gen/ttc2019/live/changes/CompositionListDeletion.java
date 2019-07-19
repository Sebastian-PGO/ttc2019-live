/**
 */
package ttc2019.live.changes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composition List Deletion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ttc2019.live.changes.CompositionListDeletion#getDeletedElement <em>Deleted Element</em>}</li>
 *   <li>{@link ttc2019.live.changes.CompositionListDeletion#getIndex <em>Index</em>}</li>
 * </ul>
 *
 * @see ttc2019.live.changes.ChangesPackage#getCompositionListDeletion()
 * @model
 * @generated
 */
public interface CompositionListDeletion extends CompositionChange {
	/**
	 * Returns the value of the '<em><b>Deleted Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deleted Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deleted Element</em>' reference.
	 * @see #setDeletedElement(EObject)
	 * @see ttc2019.live.changes.ChangesPackage#getCompositionListDeletion_DeletedElement()
	 * @model
	 * @generated
	 */
	EObject getDeletedElement();

	/**
	 * Sets the value of the '{@link ttc2019.live.changes.CompositionListDeletion#getDeletedElement <em>Deleted Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deleted Element</em>' reference.
	 * @see #getDeletedElement()
	 * @generated
	 */
	void setDeletedElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(int)
	 * @see ttc2019.live.changes.ChangesPackage#getCompositionListDeletion_Index()
	 * @model required="true"
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link ttc2019.live.changes.CompositionListDeletion#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

} // CompositionListDeletion
