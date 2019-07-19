/**
 */
package ttc2019.live.changes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute List Deletion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ttc2019.live.changes.AttributeListDeletion#getDeletedValue <em>Deleted Value</em>}</li>
 *   <li>{@link ttc2019.live.changes.AttributeListDeletion#getIndex <em>Index</em>}</li>
 * </ul>
 *
 * @see ttc2019.live.changes.ChangesPackage#getAttributeListDeletion()
 * @model
 * @generated
 */
public interface AttributeListDeletion extends AttributeChange {
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
	 * @see ttc2019.live.changes.ChangesPackage#getAttributeListDeletion_DeletedValue()
	 * @model
	 * @generated
	 */
	String getDeletedValue();

	/**
	 * Sets the value of the '{@link ttc2019.live.changes.AttributeListDeletion#getDeletedValue <em>Deleted Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deleted Value</em>' attribute.
	 * @see #getDeletedValue()
	 * @generated
	 */
	void setDeletedValue(String value);

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
	 * @see ttc2019.live.changes.ChangesPackage#getAttributeListDeletion_Index()
	 * @model required="true"
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link ttc2019.live.changes.AttributeListDeletion#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

} // AttributeListDeletion
