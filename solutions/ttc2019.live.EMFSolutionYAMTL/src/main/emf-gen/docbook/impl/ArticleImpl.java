/**
 */
package docbook.impl;

import docbook.Article;
import docbook.DocbookPackage;
import docbook.Sect1;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Article</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link docbook.impl.ArticleImpl#getSections_1 <em>Sections 1</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArticleImpl extends TitledElementImpl implements Article {
	/**
	 * The cached value of the '{@link #getSections_1() <em>Sections 1</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSections_1()
	 * @generated
	 * @ordered
	 */
	protected EList<Sect1> sections_1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArticleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DocbookPackage.Literals.ARTICLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Sect1> getSections_1() {
		if (sections_1 == null) {
			sections_1 = new EObjectContainmentEList<Sect1>(Sect1.class, this, DocbookPackage.ARTICLE__SECTIONS_1);
		}
		return sections_1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DocbookPackage.ARTICLE__SECTIONS_1:
				return ((InternalEList<?>)getSections_1()).basicRemove(otherEnd, msgs);
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
			case DocbookPackage.ARTICLE__SECTIONS_1:
				return getSections_1();
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
			case DocbookPackage.ARTICLE__SECTIONS_1:
				getSections_1().clear();
				getSections_1().addAll((Collection<? extends Sect1>)newValue);
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
			case DocbookPackage.ARTICLE__SECTIONS_1:
				getSections_1().clear();
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
			case DocbookPackage.ARTICLE__SECTIONS_1:
				return sections_1 != null && !sections_1.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ArticleImpl
