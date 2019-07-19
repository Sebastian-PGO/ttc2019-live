/**
 */
package docbook;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Para</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link docbook.Para#getContent <em>Content</em>}</li>
 * </ul>
 *
 * @see docbook.DocbookPackage#getPara()
 * @model
 * @generated
 */
public interface Para extends Identifiable {
	/**
	 * Returns the value of the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' attribute.
	 * @see #setContent(String)
	 * @see docbook.DocbookPackage#getPara_Content()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getContent();

	/**
	 * Sets the value of the '{@link docbook.Para#getContent <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' attribute.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(String value);

} // Para
