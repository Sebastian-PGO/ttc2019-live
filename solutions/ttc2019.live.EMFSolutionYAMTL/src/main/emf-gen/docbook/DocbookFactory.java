/**
 */
package docbook;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see docbook.DocbookPackage
 * @generated
 */
public interface DocbookFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DocbookFactory eINSTANCE = docbook.impl.DocbookFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Doc Book</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Doc Book</em>'.
	 * @generated
	 */
	DocBook createDocBook();

	/**
	 * Returns a new object of class '<em>Book</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Book</em>'.
	 * @generated
	 */
	Book createBook();

	/**
	 * Returns a new object of class '<em>Article</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Article</em>'.
	 * @generated
	 */
	Article createArticle();

	/**
	 * Returns a new object of class '<em>Sect1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sect1</em>'.
	 * @generated
	 */
	Sect1 createSect1();

	/**
	 * Returns a new object of class '<em>Sect2</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sect2</em>'.
	 * @generated
	 */
	Sect2 createSect2();

	/**
	 * Returns a new object of class '<em>Para</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Para</em>'.
	 * @generated
	 */
	Para createPara();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DocbookPackage getDocbookPackage();

} //DocbookFactory
