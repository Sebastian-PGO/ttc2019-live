/**
 */
package docbook;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see docbook.DocbookFactory
 * @model kind="package"
 * @generated
 */
public interface DocbookPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "docbook";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://www.transformation-tool-contest.eu/2019/docbook";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "docb";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DocbookPackage eINSTANCE = docbook.impl.DocbookPackageImpl.init();

	/**
	 * The meta object id for the '{@link docbook.impl.IdentifiableImpl <em>Identifiable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see docbook.impl.IdentifiableImpl
	 * @see docbook.impl.DocbookPackageImpl#getIdentifiable()
	 * @generated
	 */
	int IDENTIFIABLE = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE__ID = 0;

	/**
	 * The number of structural features of the '<em>Identifiable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Identifiable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link docbook.impl.DocBookImpl <em>Doc Book</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see docbook.impl.DocBookImpl
	 * @see docbook.impl.DocbookPackageImpl#getDocBook()
	 * @generated
	 */
	int DOC_BOOK = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOC_BOOK__ID = IDENTIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Books</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOC_BOOK__BOOKS = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Doc Book</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOC_BOOK_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Doc Book</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOC_BOOK_OPERATION_COUNT = IDENTIFIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link docbook.impl.BookImpl <em>Book</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see docbook.impl.BookImpl
	 * @see docbook.impl.DocbookPackageImpl#getBook()
	 * @generated
	 */
	int BOOK = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__ID = IDENTIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Articles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__ARTICLES = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Book</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Book</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_OPERATION_COUNT = IDENTIFIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link docbook.impl.TitledElementImpl <em>Titled Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see docbook.impl.TitledElementImpl
	 * @see docbook.impl.DocbookPackageImpl#getTitledElement()
	 * @generated
	 */
	int TITLED_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLED_ELEMENT__ID = IDENTIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLED_ELEMENT__TITLE = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Titled Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLED_ELEMENT_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Titled Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLED_ELEMENT_OPERATION_COUNT = IDENTIFIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link docbook.impl.ArticleImpl <em>Article</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see docbook.impl.ArticleImpl
	 * @see docbook.impl.DocbookPackageImpl#getArticle()
	 * @generated
	 */
	int ARTICLE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__ID = TITLED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__TITLE = TITLED_ELEMENT__TITLE;

	/**
	 * The feature id for the '<em><b>Sections 1</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__SECTIONS_1 = TITLED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Article</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_FEATURE_COUNT = TITLED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Article</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_OPERATION_COUNT = TITLED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link docbook.impl.SectionImpl <em>Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see docbook.impl.SectionImpl
	 * @see docbook.impl.DocbookPackageImpl#getSection()
	 * @generated
	 */
	int SECTION = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__ID = TITLED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__TITLE = TITLED_ELEMENT__TITLE;

	/**
	 * The feature id for the '<em><b>Paras</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__PARAS = TITLED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_FEATURE_COUNT = TITLED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_OPERATION_COUNT = TITLED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link docbook.impl.Sect1Impl <em>Sect1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see docbook.impl.Sect1Impl
	 * @see docbook.impl.DocbookPackageImpl#getSect1()
	 * @generated
	 */
	int SECT1 = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECT1__ID = SECTION__ID;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECT1__TITLE = SECTION__TITLE;

	/**
	 * The feature id for the '<em><b>Paras</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECT1__PARAS = SECTION__PARAS;

	/**
	 * The feature id for the '<em><b>Sections 2</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECT1__SECTIONS_2 = SECTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sect1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECT1_FEATURE_COUNT = SECTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Sect1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECT1_OPERATION_COUNT = SECTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link docbook.impl.Sect2Impl <em>Sect2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see docbook.impl.Sect2Impl
	 * @see docbook.impl.DocbookPackageImpl#getSect2()
	 * @generated
	 */
	int SECT2 = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECT2__ID = SECTION__ID;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECT2__TITLE = SECTION__TITLE;

	/**
	 * The feature id for the '<em><b>Paras</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECT2__PARAS = SECTION__PARAS;

	/**
	 * The number of structural features of the '<em>Sect2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECT2_FEATURE_COUNT = SECTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Sect2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECT2_OPERATION_COUNT = SECTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link docbook.impl.ParaImpl <em>Para</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see docbook.impl.ParaImpl
	 * @see docbook.impl.DocbookPackageImpl#getPara()
	 * @generated
	 */
	int PARA = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARA__ID = IDENTIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARA__CONTENT = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Para</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARA_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Para</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARA_OPERATION_COUNT = IDENTIFIABLE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link docbook.DocBook <em>Doc Book</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Doc Book</em>'.
	 * @see docbook.DocBook
	 * @generated
	 */
	EClass getDocBook();

	/**
	 * Returns the meta object for the containment reference list '{@link docbook.DocBook#getBooks <em>Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Books</em>'.
	 * @see docbook.DocBook#getBooks()
	 * @see #getDocBook()
	 * @generated
	 */
	EReference getDocBook_Books();

	/**
	 * Returns the meta object for class '{@link docbook.Book <em>Book</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Book</em>'.
	 * @see docbook.Book
	 * @generated
	 */
	EClass getBook();

	/**
	 * Returns the meta object for the containment reference list '{@link docbook.Book#getArticles <em>Articles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Articles</em>'.
	 * @see docbook.Book#getArticles()
	 * @see #getBook()
	 * @generated
	 */
	EReference getBook_Articles();

	/**
	 * Returns the meta object for class '{@link docbook.TitledElement <em>Titled Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Titled Element</em>'.
	 * @see docbook.TitledElement
	 * @generated
	 */
	EClass getTitledElement();

	/**
	 * Returns the meta object for the attribute '{@link docbook.TitledElement#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see docbook.TitledElement#getTitle()
	 * @see #getTitledElement()
	 * @generated
	 */
	EAttribute getTitledElement_Title();

	/**
	 * Returns the meta object for class '{@link docbook.Article <em>Article</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Article</em>'.
	 * @see docbook.Article
	 * @generated
	 */
	EClass getArticle();

	/**
	 * Returns the meta object for the containment reference list '{@link docbook.Article#getSections_1 <em>Sections 1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sections 1</em>'.
	 * @see docbook.Article#getSections_1()
	 * @see #getArticle()
	 * @generated
	 */
	EReference getArticle_Sections_1();

	/**
	 * Returns the meta object for class '{@link docbook.Section <em>Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section</em>'.
	 * @see docbook.Section
	 * @generated
	 */
	EClass getSection();

	/**
	 * Returns the meta object for the containment reference list '{@link docbook.Section#getParas <em>Paras</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Paras</em>'.
	 * @see docbook.Section#getParas()
	 * @see #getSection()
	 * @generated
	 */
	EReference getSection_Paras();

	/**
	 * Returns the meta object for class '{@link docbook.Sect1 <em>Sect1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sect1</em>'.
	 * @see docbook.Sect1
	 * @generated
	 */
	EClass getSect1();

	/**
	 * Returns the meta object for the containment reference list '{@link docbook.Sect1#getSections_2 <em>Sections 2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sections 2</em>'.
	 * @see docbook.Sect1#getSections_2()
	 * @see #getSect1()
	 * @generated
	 */
	EReference getSect1_Sections_2();

	/**
	 * Returns the meta object for class '{@link docbook.Sect2 <em>Sect2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sect2</em>'.
	 * @see docbook.Sect2
	 * @generated
	 */
	EClass getSect2();

	/**
	 * Returns the meta object for class '{@link docbook.Para <em>Para</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Para</em>'.
	 * @see docbook.Para
	 * @generated
	 */
	EClass getPara();

	/**
	 * Returns the meta object for the attribute '{@link docbook.Para#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see docbook.Para#getContent()
	 * @see #getPara()
	 * @generated
	 */
	EAttribute getPara_Content();

	/**
	 * Returns the meta object for class '{@link docbook.Identifiable <em>Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifiable</em>'.
	 * @see docbook.Identifiable
	 * @generated
	 */
	EClass getIdentifiable();

	/**
	 * Returns the meta object for the attribute '{@link docbook.Identifiable#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see docbook.Identifiable#getId()
	 * @see #getIdentifiable()
	 * @generated
	 */
	EAttribute getIdentifiable_Id();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DocbookFactory getDocbookFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link docbook.impl.DocBookImpl <em>Doc Book</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see docbook.impl.DocBookImpl
		 * @see docbook.impl.DocbookPackageImpl#getDocBook()
		 * @generated
		 */
		EClass DOC_BOOK = eINSTANCE.getDocBook();

		/**
		 * The meta object literal for the '<em><b>Books</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOC_BOOK__BOOKS = eINSTANCE.getDocBook_Books();

		/**
		 * The meta object literal for the '{@link docbook.impl.BookImpl <em>Book</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see docbook.impl.BookImpl
		 * @see docbook.impl.DocbookPackageImpl#getBook()
		 * @generated
		 */
		EClass BOOK = eINSTANCE.getBook();

		/**
		 * The meta object literal for the '<em><b>Articles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOK__ARTICLES = eINSTANCE.getBook_Articles();

		/**
		 * The meta object literal for the '{@link docbook.impl.TitledElementImpl <em>Titled Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see docbook.impl.TitledElementImpl
		 * @see docbook.impl.DocbookPackageImpl#getTitledElement()
		 * @generated
		 */
		EClass TITLED_ELEMENT = eINSTANCE.getTitledElement();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TITLED_ELEMENT__TITLE = eINSTANCE.getTitledElement_Title();

		/**
		 * The meta object literal for the '{@link docbook.impl.ArticleImpl <em>Article</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see docbook.impl.ArticleImpl
		 * @see docbook.impl.DocbookPackageImpl#getArticle()
		 * @generated
		 */
		EClass ARTICLE = eINSTANCE.getArticle();

		/**
		 * The meta object literal for the '<em><b>Sections 1</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTICLE__SECTIONS_1 = eINSTANCE.getArticle_Sections_1();

		/**
		 * The meta object literal for the '{@link docbook.impl.SectionImpl <em>Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see docbook.impl.SectionImpl
		 * @see docbook.impl.DocbookPackageImpl#getSection()
		 * @generated
		 */
		EClass SECTION = eINSTANCE.getSection();

		/**
		 * The meta object literal for the '<em><b>Paras</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECTION__PARAS = eINSTANCE.getSection_Paras();

		/**
		 * The meta object literal for the '{@link docbook.impl.Sect1Impl <em>Sect1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see docbook.impl.Sect1Impl
		 * @see docbook.impl.DocbookPackageImpl#getSect1()
		 * @generated
		 */
		EClass SECT1 = eINSTANCE.getSect1();

		/**
		 * The meta object literal for the '<em><b>Sections 2</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECT1__SECTIONS_2 = eINSTANCE.getSect1_Sections_2();

		/**
		 * The meta object literal for the '{@link docbook.impl.Sect2Impl <em>Sect2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see docbook.impl.Sect2Impl
		 * @see docbook.impl.DocbookPackageImpl#getSect2()
		 * @generated
		 */
		EClass SECT2 = eINSTANCE.getSect2();

		/**
		 * The meta object literal for the '{@link docbook.impl.ParaImpl <em>Para</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see docbook.impl.ParaImpl
		 * @see docbook.impl.DocbookPackageImpl#getPara()
		 * @generated
		 */
		EClass PARA = eINSTANCE.getPara();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARA__CONTENT = eINSTANCE.getPara_Content();

		/**
		 * The meta object literal for the '{@link docbook.impl.IdentifiableImpl <em>Identifiable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see docbook.impl.IdentifiableImpl
		 * @see docbook.impl.DocbookPackageImpl#getIdentifiable()
		 * @generated
		 */
		EClass IDENTIFIABLE = eINSTANCE.getIdentifiable();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIABLE__ID = eINSTANCE.getIdentifiable_Id();

	}

} //DocbookPackage
