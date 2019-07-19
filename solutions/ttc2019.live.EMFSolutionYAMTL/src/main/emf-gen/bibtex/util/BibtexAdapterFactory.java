/**
 */
package bibtex.util;

import bibtex.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see bibtex.BibtexPackage
 * @generated
 */
public class BibtexAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BibtexPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BibtexAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = BibtexPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BibtexSwitch<Adapter> modelSwitch =
		new BibtexSwitch<Adapter>() {
			@Override
			public Adapter caseBibTeXFile(BibTeXFile object) {
				return createBibTeXFileAdapter();
			}
			@Override
			public Adapter caseAuthor(Author object) {
				return createAuthorAdapter();
			}
			@Override
			public Adapter caseBibTeXEntry(BibTeXEntry object) {
				return createBibTeXEntryAdapter();
			}
			@Override
			public Adapter caseAuthoredEntry(AuthoredEntry object) {
				return createAuthoredEntryAdapter();
			}
			@Override
			public Adapter caseDatedEntry(DatedEntry object) {
				return createDatedEntryAdapter();
			}
			@Override
			public Adapter caseTitledEntry(TitledEntry object) {
				return createTitledEntryAdapter();
			}
			@Override
			public Adapter caseBookTitledEntry(BookTitledEntry object) {
				return createBookTitledEntryAdapter();
			}
			@Override
			public Adapter caseArticle(Article object) {
				return createArticleAdapter();
			}
			@Override
			public Adapter caseTechReport(TechReport object) {
				return createTechReportAdapter();
			}
			@Override
			public Adapter caseUnpublished(Unpublished object) {
				return createUnpublishedAdapter();
			}
			@Override
			public Adapter caseManual(Manual object) {
				return createManualAdapter();
			}
			@Override
			public Adapter caseProceedings(Proceedings object) {
				return createProceedingsAdapter();
			}
			@Override
			public Adapter caseInProceedings(InProceedings object) {
				return createInProceedingsAdapter();
			}
			@Override
			public Adapter caseBooklet(Booklet object) {
				return createBookletAdapter();
			}
			@Override
			public Adapter caseBook(Book object) {
				return createBookAdapter();
			}
			@Override
			public Adapter caseInCollection(InCollection object) {
				return createInCollectionAdapter();
			}
			@Override
			public Adapter caseInBook(InBook object) {
				return createInBookAdapter();
			}
			@Override
			public Adapter caseMisc(Misc object) {
				return createMiscAdapter();
			}
			@Override
			public Adapter caseThesisEntry(ThesisEntry object) {
				return createThesisEntryAdapter();
			}
			@Override
			public Adapter casePhDThesis(PhDThesis object) {
				return createPhDThesisAdapter();
			}
			@Override
			public Adapter caseMasterThesis(MasterThesis object) {
				return createMasterThesisAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link bibtex.BibTeXFile <em>Bib Te XFile</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bibtex.BibTeXFile
	 * @generated
	 */
	public Adapter createBibTeXFileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bibtex.Author <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bibtex.Author
	 * @generated
	 */
	public Adapter createAuthorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bibtex.BibTeXEntry <em>Bib Te XEntry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bibtex.BibTeXEntry
	 * @generated
	 */
	public Adapter createBibTeXEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bibtex.AuthoredEntry <em>Authored Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bibtex.AuthoredEntry
	 * @generated
	 */
	public Adapter createAuthoredEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bibtex.DatedEntry <em>Dated Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bibtex.DatedEntry
	 * @generated
	 */
	public Adapter createDatedEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bibtex.TitledEntry <em>Titled Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bibtex.TitledEntry
	 * @generated
	 */
	public Adapter createTitledEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bibtex.BookTitledEntry <em>Book Titled Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bibtex.BookTitledEntry
	 * @generated
	 */
	public Adapter createBookTitledEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bibtex.Article <em>Article</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bibtex.Article
	 * @generated
	 */
	public Adapter createArticleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bibtex.TechReport <em>Tech Report</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bibtex.TechReport
	 * @generated
	 */
	public Adapter createTechReportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bibtex.Unpublished <em>Unpublished</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bibtex.Unpublished
	 * @generated
	 */
	public Adapter createUnpublishedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bibtex.Manual <em>Manual</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bibtex.Manual
	 * @generated
	 */
	public Adapter createManualAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bibtex.Proceedings <em>Proceedings</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bibtex.Proceedings
	 * @generated
	 */
	public Adapter createProceedingsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bibtex.InProceedings <em>In Proceedings</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bibtex.InProceedings
	 * @generated
	 */
	public Adapter createInProceedingsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bibtex.Booklet <em>Booklet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bibtex.Booklet
	 * @generated
	 */
	public Adapter createBookletAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bibtex.Book <em>Book</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bibtex.Book
	 * @generated
	 */
	public Adapter createBookAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bibtex.InCollection <em>In Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bibtex.InCollection
	 * @generated
	 */
	public Adapter createInCollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bibtex.InBook <em>In Book</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bibtex.InBook
	 * @generated
	 */
	public Adapter createInBookAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bibtex.Misc <em>Misc</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bibtex.Misc
	 * @generated
	 */
	public Adapter createMiscAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bibtex.ThesisEntry <em>Thesis Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bibtex.ThesisEntry
	 * @generated
	 */
	public Adapter createThesisEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bibtex.PhDThesis <em>Ph DThesis</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bibtex.PhDThesis
	 * @generated
	 */
	public Adapter createPhDThesisAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link bibtex.MasterThesis <em>Master Thesis</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see bibtex.MasterThesis
	 * @generated
	 */
	public Adapter createMasterThesisAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //BibtexAdapterFactory
