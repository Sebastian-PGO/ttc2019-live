/**
 */
package ttc2019.live.changes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ttc2019.live.changes.ReferenceArgument#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see ttc2019.live.changes.ChangesPackage#getReferenceArgument()
 * @model
 * @generated
 */
public interface ReferenceArgument extends OperationArgument {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(EObject)
	 * @see ttc2019.live.changes.ChangesPackage#getReferenceArgument_Value()
	 * @model required="true"
	 * @generated
	 */
	EObject getValue();

	/**
	 * Sets the value of the '{@link ttc2019.live.changes.ReferenceArgument#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(EObject value);

} // ReferenceArgument
