/**
 */
package docbook.impl;

import docbook.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DocbookFactoryImpl extends EFactoryImpl implements DocbookFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DocbookFactory init() {
		try {
			DocbookFactory theDocbookFactory = (DocbookFactory)EPackage.Registry.INSTANCE.getEFactory(DocbookPackage.eNS_URI);
			if (theDocbookFactory != null) {
				return theDocbookFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DocbookFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocbookFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DocbookPackage.DOC_BOOK: return createDocBook();
			case DocbookPackage.BOOK: return createBook();
			case DocbookPackage.ARTICLE: return createArticle();
			case DocbookPackage.SECT1: return createSect1();
			case DocbookPackage.SECT2: return createSect2();
			case DocbookPackage.PARA: return createPara();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DocBook createDocBook() {
		DocBookImpl docBook = new DocBookImpl();
		return docBook;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Book createBook() {
		BookImpl book = new BookImpl();
		return book;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Article createArticle() {
		ArticleImpl article = new ArticleImpl();
		return article;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Sect1 createSect1() {
		Sect1Impl sect1 = new Sect1Impl();
		return sect1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Sect2 createSect2() {
		Sect2Impl sect2 = new Sect2Impl();
		return sect2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Para createPara() {
		ParaImpl para = new ParaImpl();
		return para;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DocbookPackage getDocbookPackage() {
		return (DocbookPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DocbookPackage getPackage() {
		return DocbookPackage.eINSTANCE;
	}

} //DocbookFactoryImpl
