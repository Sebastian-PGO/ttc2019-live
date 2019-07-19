/**
 */
package bibtex.impl;

import bibtex.BibtexPackage;
import bibtex.DatedEntry;
import bibtex.ThesisEntry;
import bibtex.TitledEntry;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Thesis Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link bibtex.impl.ThesisEntryImpl#getYear <em>Year</em>}</li>
 *   <li>{@link bibtex.impl.ThesisEntryImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link bibtex.impl.ThesisEntryImpl#getSchool <em>School</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ThesisEntryImpl extends AuthoredEntryImpl implements ThesisEntry {
	/**
	 * The default value of the '{@link #getYear() <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYear()
	 * @generated
	 * @ordered
	 */
	protected static final int YEAR_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getYear() <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYear()
	 * @generated
	 * @ordered
	 */
	protected int year = YEAR_EDEFAULT;

	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchool() <em>School</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchool()
	 * @generated
	 * @ordered
	 */
	protected static final String SCHOOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSchool() <em>School</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchool()
	 * @generated
	 * @ordered
	 */
	protected String school = SCHOOL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThesisEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BibtexPackage.Literals.THESIS_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getYear() {
		return year;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setYear(int newYear) {
		int oldYear = year;
		year = newYear;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.THESIS_ENTRY__YEAR, oldYear, year));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.THESIS_ENTRY__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSchool() {
		return school;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSchool(String newSchool) {
		String oldSchool = school;
		school = newSchool;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.THESIS_ENTRY__SCHOOL, oldSchool, school));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BibtexPackage.THESIS_ENTRY__YEAR:
				return getYear();
			case BibtexPackage.THESIS_ENTRY__TITLE:
				return getTitle();
			case BibtexPackage.THESIS_ENTRY__SCHOOL:
				return getSchool();
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
			case BibtexPackage.THESIS_ENTRY__YEAR:
				setYear((Integer)newValue);
				return;
			case BibtexPackage.THESIS_ENTRY__TITLE:
				setTitle((String)newValue);
				return;
			case BibtexPackage.THESIS_ENTRY__SCHOOL:
				setSchool((String)newValue);
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
			case BibtexPackage.THESIS_ENTRY__YEAR:
				setYear(YEAR_EDEFAULT);
				return;
			case BibtexPackage.THESIS_ENTRY__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case BibtexPackage.THESIS_ENTRY__SCHOOL:
				setSchool(SCHOOL_EDEFAULT);
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
			case BibtexPackage.THESIS_ENTRY__YEAR:
				return year != YEAR_EDEFAULT;
			case BibtexPackage.THESIS_ENTRY__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case BibtexPackage.THESIS_ENTRY__SCHOOL:
				return SCHOOL_EDEFAULT == null ? school != null : !SCHOOL_EDEFAULT.equals(school);
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
		if (baseClass == DatedEntry.class) {
			switch (derivedFeatureID) {
				case BibtexPackage.THESIS_ENTRY__YEAR: return BibtexPackage.DATED_ENTRY__YEAR;
				default: return -1;
			}
		}
		if (baseClass == TitledEntry.class) {
			switch (derivedFeatureID) {
				case BibtexPackage.THESIS_ENTRY__TITLE: return BibtexPackage.TITLED_ENTRY__TITLE;
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
		if (baseClass == DatedEntry.class) {
			switch (baseFeatureID) {
				case BibtexPackage.DATED_ENTRY__YEAR: return BibtexPackage.THESIS_ENTRY__YEAR;
				default: return -1;
			}
		}
		if (baseClass == TitledEntry.class) {
			switch (baseFeatureID) {
				case BibtexPackage.TITLED_ENTRY__TITLE: return BibtexPackage.THESIS_ENTRY__TITLE;
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
		result.append(" (year: ");
		result.append(year);
		result.append(", title: ");
		result.append(title);
		result.append(", school: ");
		result.append(school);
		result.append(')');
		return result.toString();
	}

} //ThesisEntryImpl
