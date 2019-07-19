/**
 */
package docbook.impl;

import docbook.DocbookPackage;
import docbook.Sect1;
import docbook.Sect2;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sect1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link docbook.impl.Sect1Impl#getSections_2 <em>Sections 2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Sect1Impl extends SectionImpl implements Sect1 {
	/**
	 * The cached value of the '{@link #getSections_2() <em>Sections 2</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSections_2()
	 * @generated
	 * @ordered
	 */
	protected EList<Sect2> sections_2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Sect1Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DocbookPackage.Literals.SECT1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Sect2> getSections_2() {
		if (sections_2 == null) {
			sections_2 = new EObjectContainmentEList<Sect2>(Sect2.class, this, DocbookPackage.SECT1__SECTIONS_2);
		}
		return sections_2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DocbookPackage.SECT1__SECTIONS_2:
				return ((InternalEList<?>)getSections_2()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DocbookPackage.SECT1__SECTIONS_2:
				return getSections_2();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DocbookPackage.SECT1__SECTIONS_2:
				getSections_2().clear();
				getSections_2().addAll((Collection<? extends Sect2>)newValue);
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
			case DocbookPackage.SECT1__SECTIONS_2:
				getSections_2().clear();
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
			case DocbookPackage.SECT1__SECTIONS_2:
				return sections_2 != null && !sections_2.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //Sect1Impl
