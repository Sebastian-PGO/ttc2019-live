/**
 */
package ttc2019.live.bibtex.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ttc2019.live.bibtex.BibtexPackage;
import ttc2019.live.bibtex.BookTitledEntry;
import ttc2019.live.bibtex.InCollection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>In Collection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ttc2019.live.bibtex.impl.InCollectionImpl#getBooktitle <em>Booktitle</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InCollectionImpl extends BookImpl implements InCollection {
	/**
	 * The default value of the '{@link #getBooktitle() <em>Booktitle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBooktitle()
	 * @generated
	 * @ordered
	 */
	protected static final String BOOKTITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBooktitle() <em>Booktitle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBooktitle()
	 * @generated
	 * @ordered
	 */
	protected String booktitle = BOOKTITLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InCollectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BibtexPackage.Literals.IN_COLLECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBooktitle() {
		return booktitle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBooktitle(String newBooktitle) {
		String oldBooktitle = booktitle;
		booktitle = newBooktitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_COLLECTION__BOOKTITLE, oldBooktitle, booktitle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BibtexPackage.IN_COLLECTION__BOOKTITLE:
				return getBooktitle();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BibtexPackage.IN_COLLECTION__BOOKTITLE:
				setBooktitle((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BibtexPackage.IN_COLLECTION__BOOKTITLE:
				setBooktitle(BOOKTITLE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BibtexPackage.IN_COLLECTION__BOOKTITLE:
				return BOOKTITLE_EDEFAULT == null ? booktitle != null : !BOOKTITLE_EDEFAULT.equals(booktitle);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == BookTitledEntry.class) {
			switch (derivedFeatureID) {
				case BibtexPackage.IN_COLLECTION__BOOKTITLE: return BibtexPackage.BOOK_TITLED_ENTRY__BOOKTITLE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == BookTitledEntry.class) {
			switch (baseFeatureID) {
				case BibtexPackage.BOOK_TITLED_ENTRY__BOOKTITLE: return BibtexPackage.IN_COLLECTION__BOOKTITLE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (booktitle: ");
		result.append(booktitle);
		result.append(')');
		return result.toString();
	}

} //InCollectionImpl
