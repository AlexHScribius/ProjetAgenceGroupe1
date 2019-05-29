package com.formation.service.impl;

import java.util.List;

import com.formation.dao.IPersonneDao;
import com.formation.dao.impl.PersonneDao;
import com.formation.model.Personne;
import com.formation.model.Voiture;
import com.formation.service.IPersonneService;

public class PersonneService extends ManagerService<Personne> implements IPersonneService {

	IPersonneDao dao = new PersonneDao();
	
	@Override
	public List<Voiture> consulterCatalogue() {
		return dao.consulterCatalogue();
	}

	@Override
	public List<Voiture> consulterCatalogue(String marque) {
		return dao.consulterCatalogue(marque);
	}

	@Override
	public List<Voiture> consulterCatalogue(float prixMax) {
		return dao.consulterCatalogue(prixMax);
	}

	@Override
	public List<Voiture> consulterCatalogue(String marque, float prixMax) {
		return dao.consulterCatalogue(marque, prixMax);
	}

	@Override
	public Personne getByLoginAndPassword(String login, String mdp) {
		return dao.getByLoginAndPassword(login, mdp);
	}

}
