package com.formation.dao;

import java.util.List;

import com.formation.model.Personne;
import com.formation.model.Voiture;

public interface IPersonneDao extends IManagerDao<Personne> {

	List<Voiture> consulterCatalogue();
	List<Voiture> consulterCatalogue(String marque);
	List<Voiture> consulterCatalogue(float prixMax);
	List<Voiture> consulterCatalogue(String marque,float prixMax);
	Personne getByLoginAndPassword(String login, String mdp);
	
}
