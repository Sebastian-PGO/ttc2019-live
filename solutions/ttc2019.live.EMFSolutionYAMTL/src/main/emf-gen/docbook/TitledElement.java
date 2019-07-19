/**
 */
package docbook;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Titled Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link docbook.TitledElement#getTitle <em>Title</em>}</li>
 * </ul>
 *
 * @see docbook.DocbookPackage#getTitledElement()
 * @model abstract="true"
 * @generated
 */
public interface TitledElement extends Identifiable {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see docbook.DocbookPackage#getTitledElement_Title()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link docbook.TitledElement#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

} // TitledElement
