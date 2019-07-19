/**
 */
package ttc2019.live.changes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composition Move To List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ttc2019.live.changes.CompositionMoveToList#getIndex <em>Index</em>}</li>
 *   <li>{@link ttc2019.live.changes.CompositionMoveToList#getMovedElement <em>Moved Element</em>}</li>
 *   <li>{@link ttc2019.live.changes.CompositionMoveToList#getOrigin <em>Origin</em>}</li>
 * </ul>
 *
 * @see ttc2019.live.changes.ChangesPackage#getCompositionMoveToList()
 * @model
 * @generated
 */
public interface CompositionMoveToList extends CompositionChange {
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
	 * @see ttc2019.live.changes.ChangesPackage#getCompositionMoveToList_Index()
	 * @model required="true"
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link ttc2019.live.changes.CompositionMoveToList#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

	/**
	 * Returns the value of the '<em><b>Moved Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moved Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moved Element</em>' reference.
	 * @see #setMovedElement(EObject)
	 * @see ttc2019.live.changes.ChangesPackage#getCompositionMoveToList_MovedElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getMovedElement();

	/**
	 * Sets the value of the '{@link ttc2019.live.changes.CompositionMoveToList#getMovedElement <em>Moved Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Moved Element</em>' reference.
	 * @see #getMovedElement()
	 * @generated
	 */
	void setMovedElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Origin</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origin</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origin</em>' containment reference.
	 * @see #setOrigin(ElementaryChange)
	 * @see ttc2019.live.changes.ChangesPackage#getCompositionMoveToList_Origin()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ElementaryChange getOrigin();

	/**
	 * Sets the value of the '{@link ttc2019.live.changes.CompositionMoveToList#getOrigin <em>Origin</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin</em>' containment reference.
	 * @see #getOrigin()
	 * @generated
	 */
	void setOrigin(ElementaryChange value);

} // CompositionMoveToList
