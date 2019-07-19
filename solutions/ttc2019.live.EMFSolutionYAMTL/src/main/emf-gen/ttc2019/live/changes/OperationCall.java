/**
 */
package ttc2019.live.changes;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ttc2019.live.changes.OperationCall#getOperation <em>Operation</em>}</li>
 *   <li>{@link ttc2019.live.changes.OperationCall#getTargetElement <em>Target Element</em>}</li>
 *   <li>{@link ttc2019.live.changes.OperationCall#getArguments <em>Arguments</em>}</li>
 * </ul>
 *
 * @see ttc2019.live.changes.ChangesPackage#getOperationCall()
 * @model
 * @generated
 */
public interface OperationCall extends ModelChange {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see #setOperation(EOperation)
	 * @see ttc2019.live.changes.ChangesPackage#getOperationCall_Operation()
	 * @model required="true"
	 * @generated
	 */
	EOperation getOperation();

	/**
	 * Sets the value of the '{@link ttc2019.live.changes.OperationCall#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(EOperation value);

	/**
	 * Returns the value of the '<em><b>Target Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Element</em>' reference.
	 * @see #setTargetElement(EObject)
	 * @see ttc2019.live.changes.ChangesPackage#getOperationCall_TargetElement()
	 * @model
	 * @generated
	 */
	EObject getTargetElement();

	/**
	 * Sets the value of the '{@link ttc2019.live.changes.OperationCall#getTargetElement <em>Target Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Element</em>' reference.
	 * @see #getTargetElement()
	 * @generated
	 */
	void setTargetElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link ttc2019.live.changes.OperationArgument}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see ttc2019.live.changes.ChangesPackage#getOperationCall_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<OperationArgument> getArguments();

} // OperationCall
