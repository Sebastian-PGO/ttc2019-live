/**
 */
package ttc2019.live.changes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Property Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ttc2019.live.changes.AttributePropertyChange#getNewValue <em>New Value</em>}</li>
 *   <li>{@link ttc2019.live.changes.AttributePropertyChange#getOldValue <em>Old Value</em>}</li>
 * </ul>
 *
 * @see ttc2019.live.changes.ChangesPackage#getAttributePropertyChange()
 * @model
 * @generated
 */
public interface AttributePropertyChange extends AttributeChange {
	/**
	 * Returns the value of the '<em><b>New Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Value</em>' attribute.
	 * @see #setNewValue(String)
	 * @see ttc2019.live.changes.ChangesPackage#getAttributePropertyChange_NewValue()
	 * @model
	 * @generated
	 */
	String getNewValue();

	/**
	 * Sets the value of the '{@link ttc2019.live.changes.AttributePropertyChange#getNewValue <em>New Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Value</em>' attribute.
	 * @see #getNewValue()
	 * @generated
	 */
	void setNewValue(String value);

	/**
	 * Returns the value of the '<em><b>Old Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Value</em>' attribute.
	 * @see #setOldValue(String)
	 * @see ttc2019.live.changes.ChangesPackage#getAttributePropertyChange_OldValue()
	 * @model
	 * @generated
	 */
	String getOldValue();

	/**
	 * Sets the value of the '{@link ttc2019.live.changes.AttributePropertyChange#getOldValue <em>Old Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Value</em>' attribute.
	 * @see #getOldValue()
	 * @generated
	 */
	void setOldValue(String value);

} // AttributePropertyChange
