/**
 */
package docbook;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link docbook.Book#getArticles <em>Articles</em>}</li>
 * </ul>
 *
 * @see docbook.DocbookPackage#getBook()
 * @model
 * @generated
 */
public interface Book extends Identifiable {
	/**
	 * Returns the value of the '<em><b>Articles</b></em>' containment reference list.
	 * The list contents are of type {@link docbook.Article}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Articles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Articles</em>' containment reference list.
	 * @see docbook.DocbookPackage#getBook_Articles()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Article> getArticles();

} // Book
