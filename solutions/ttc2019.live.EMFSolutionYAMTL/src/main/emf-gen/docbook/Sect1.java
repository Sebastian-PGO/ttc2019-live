/**
 */
package docbook;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sect1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link docbook.Sect1#getSections_2 <em>Sections 2</em>}</li>
 * </ul>
 *
 * @see docbook.DocbookPackage#getSect1()
 * @model
 * @generated
 */
public interface Sect1 extends Section {
	/**
	 * Returns the value of the '<em><b>Sections 2</b></em>' containment reference list.
	 * The list contents are of type {@link docbook.Sect2}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sections 2</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sections 2</em>' containment reference list.
	 * @see docbook.DocbookPackage#getSect1_Sections_2()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Sect2> getSections_2();

} // Sect1
