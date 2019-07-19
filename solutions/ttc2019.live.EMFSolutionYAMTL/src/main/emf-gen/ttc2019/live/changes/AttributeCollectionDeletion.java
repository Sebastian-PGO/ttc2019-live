/**
 */
package ttc2019.live.changes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Collection Deletion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ttc2019.live.changes.AttributeCollectionDeletion#getDeletedValue <em>Deleted Value</em>}</li>
 * </ul>
 *
 * @see ttc2019.live.changes.ChangesPackage#getAttributeCollectionDeletion()
 * @model
 * @generated
 */
public interface AttributeCollectionDeletion extends AttributeChange {
	/**
	 * Returns the value of the '<em><b>Deleted Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deleted Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deleted Value</em>' attribute.
	 * @see #setDeletedValue(String)
	 * @see ttc2019.live.changes.ChangesPackage#getAttributeCollectionDeletion_DeletedValue()
	 * @model required="true"
	 * @generated
	 */
	String getDeletedValue();

	/**
	 * Sets the value of the '{@link ttc2019.live.changes.AttributeCollectionDeletion#getDeletedValue <em>Deleted Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deleted Value</em>' attribute.
	 * @see #getDeletedValue()
	 * @generated
	 */
	void setDeletedValue(String value);

} // AttributeCollectionDeletion
