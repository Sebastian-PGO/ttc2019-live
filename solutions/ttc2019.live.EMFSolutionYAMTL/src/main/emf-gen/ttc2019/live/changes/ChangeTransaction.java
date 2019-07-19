/**
 */
package ttc2019.live.changes;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Change Transaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ttc2019.live.changes.ChangeTransaction#getSourceChange <em>Source Change</em>}</li>
 *   <li>{@link ttc2019.live.changes.ChangeTransaction#getNestedChanges <em>Nested Changes</em>}</li>
 * </ul>
 *
 * @see ttc2019.live.changes.ChangesPackage#getChangeTransaction()
 * @model
 * @generated
 */
public interface ChangeTransaction extends ModelChange {
	/**
	 * Returns the value of the '<em><b>Source Change</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Change</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Change</em>' containment reference.
	 * @see #setSourceChange(ModelChange)
	 * @see ttc2019.live.changes.ChangesPackage#getChangeTransaction_SourceChange()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ModelChange getSourceChange();

	/**
	 * Sets the value of the '{@link ttc2019.live.changes.ChangeTransaction#getSourceChange <em>Source Change</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Change</em>' containment reference.
	 * @see #getSourceChange()
	 * @generated
	 */
	void setSourceChange(ModelChange value);

	/**
	 * Returns the value of the '<em><b>Nested Changes</b></em>' containment reference list.
	 * The list contents are of type {@link ttc2019.live.changes.ModelChange}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested Changes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested Changes</em>' containment reference list.
	 * @see ttc2019.live.changes.ChangesPackage#getChangeTransaction_NestedChanges()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelChange> getNestedChanges();

} // ChangeTransaction
