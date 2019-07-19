/**
 */
package ttc2019.live.changes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute List Insertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ttc2019.live.changes.AttributeListInsertion#getAddedValue <em>Added Value</em>}</li>
 *   <li>{@link ttc2019.live.changes.AttributeListInsertion#getIndex <em>Index</em>}</li>
 * </ul>
 *
 * @see ttc2019.live.changes.ChangesPackage#getAttributeListInsertion()
 * @model
 * @generated
 */
public interface AttributeListInsertion extends AttributeChange {
	/**
	 * Returns the value of the '<em><b>Added Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Added Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Added Value</em>' attribute.
	 * @see #setAddedValue(String)
	 * @see ttc2019.live.changes.ChangesPackage#getAttributeListInsertion_AddedValue()
	 * @model required="true"
	 * @generated
	 */
	String getAddedValue();

	/**
	 * Sets the value of the '{@link ttc2019.live.changes.AttributeListInsertion#getAddedValue <em>Added Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Added Value</em>' attribute.
	 * @see #getAddedValue()
	 * @generated
	 */
	void setAddedValue(String value);

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
	 * @see ttc2019.live.changes.ChangesPackage#getAttributeListInsertion_Index()
	 * @model required="true"
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link ttc2019.live.changes.AttributeListInsertion#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

} // AttributeListInsertion
