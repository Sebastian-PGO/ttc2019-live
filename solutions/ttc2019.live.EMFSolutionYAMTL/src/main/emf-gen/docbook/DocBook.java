/**
 */
package docbook;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Doc Book</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link docbook.DocBook#getBooks <em>Books</em>}</li>
 * </ul>
 *
 * @see docbook.DocbookPackage#getDocBook()
 * @model
 * @generated
 */
public interface DocBook extends Identifiable {
	/**
	 * Returns the value of the '<em><b>Books</b></em>' containment reference list.
	 * The list contents are of type {@link docbook.Book}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Books</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Books</em>' containment reference list.
	 * @see docbook.DocbookPackage#getDocBook_Books()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Book> getBooks();

} // DocBook
