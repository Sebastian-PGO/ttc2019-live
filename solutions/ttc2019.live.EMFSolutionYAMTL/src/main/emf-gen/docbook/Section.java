/**
 */
package docbook;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link docbook.Section#getParas <em>Paras</em>}</li>
 * </ul>
 *
 * @see docbook.DocbookPackage#getSection()
 * @model abstract="true"
 * @generated
 */
public interface Section extends TitledElement {
	/**
	 * Returns the value of the '<em><b>Paras</b></em>' containment reference list.
	 * The list contents are of type {@link docbook.Para}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Paras</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Paras</em>' containment reference list.
	 * @see docbook.DocbookPackage#getSection_Paras()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Para> getParas();

} // Section
