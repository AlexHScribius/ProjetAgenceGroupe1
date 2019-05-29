package com.formation.service;

import java.util.List;

import com.formation.model.Personne;
import com.formation.model.Voiture;

public interface IPersonneService extends IManagerService<Personne> {

	List<Voiture> consulterCatalogue();
	List<Voiture> consulterCatalogue(String marque);
	List<Voiture> consulterCatalogue(float prixMax);
	List<Voiture> consulterCatalogue(String marque,float prixMax);
	Personne getByLoginAndPassword(String login, String mdp);
}
