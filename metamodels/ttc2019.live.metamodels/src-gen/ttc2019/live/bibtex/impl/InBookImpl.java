/**
 */
package ttc2019.live.bibtex.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ttc2019.live.bibtex.BibtexPackage;
import ttc2019.live.bibtex.InBook;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>In Book</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ttc2019.live.bibtex.impl.InBookImpl#getChapter <em>Chapter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InBookImpl extends BookImpl implements InBook {
	/**
	 * The default value of the '{@link #getChapter() <em>Chapter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChapter()
	 * @generated
	 * @ordered
	 */
	protected static final int CHAPTER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getChapter() <em>Chapter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChapter()
	 * @generated
	 * @ordered
	 */
	protected int chapter = CHAPTER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InBookImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BibtexPackage.Literals.IN_BOOK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getChapter() {
		return chapter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setChapter(int newChapter) {
		int oldChapter = chapter;
		chapter = newChapter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.IN_BOOK__CHAPTER, oldChapter, chapter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BibtexPackage.IN_BOOK__CHAPTER:
				return getChapter();
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
			case BibtexPackage.IN_BOOK__CHAPTER:
				setChapter((Integer)newValue);
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
			case BibtexPackage.IN_BOOK__CHAPTER:
				setChapter(CHAPTER_EDEFAULT);
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
			case BibtexPackage.IN_BOOK__CHAPTER:
				return chapter != CHAPTER_EDEFAULT;
		}
		return super.eIsSet(featureID);
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
		result.append(" (chapter: ");
		result.append(chapter);
		result.append(')');
		return result.toString();
	}

} //InBookImpl
