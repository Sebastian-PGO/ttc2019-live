/**
 */
package bibtex;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>In Book</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link bibtex.InBook#getChapter <em>Chapter</em>}</li>
 * </ul>
 *
 * @see bibtex.BibtexPackage#getInBook()
 * @model
 * @generated
 */
public interface InBook extends Book {
	/**
	 * Returns the value of the '<em><b>Chapter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chapter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chapter</em>' attribute.
	 * @see #setChapter(int)
	 * @see bibtex.BibtexPackage#getInBook_Chapter()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getChapter();

	/**
	 * Sets the value of the '{@link bibtex.InBook#getChapter <em>Chapter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chapter</em>' attribute.
	 * @see #getChapter()
	 * @generated
	 */
	void setChapter(int value);

} // InBook
