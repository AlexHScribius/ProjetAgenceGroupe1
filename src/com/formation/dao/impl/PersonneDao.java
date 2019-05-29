package com.formation.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.formation.dao.IPersonneDao;
import com.formation.model.Personne;
import com.formation.model.Voiture;

public class PersonneDao extends ManagerDao<Personne> implements IPersonneDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Voiture> consulterCatalogue() {
		List<Voiture> result = (List<Voiture>) hibernateSession.createQuery("FROM "+ this.getClass());
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Voiture> consulterCatalogue(String marque) {
			List<Voiture> result = (List<Voiture>) hibernateSession.createQuery("FROM "+ this.getClass().getName() + " WHERE marque=" + marque);
			return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Voiture> consulterCatalogue(float prixMax) {
		List<Voiture> result = (List<Voiture>) hibernateSession.createQuery("FROM "+ this.getClass().getName() + " WHERE prix<=" + prixMax);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Voiture> consulterCatalogue(String marque, float prixMax) {
		List<Voiture> result = (List<Voiture>) hibernateSession.createQuery("FROM "+ this.getClass().getName() + " WHERE marque=" + marque + " AND prix<=" + prixMax);
		return result;
	}

	@Override
	public Personne getByLoginAndPassword(String login, String mdp) {
		@SuppressWarnings("static-access")
		Criteria criteria = this.getSessionFactory().openSession().createCriteria(Personne.class);
		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("mdp", mdp));
		return (Personne) criteria.uniqueResult();
	}

}
