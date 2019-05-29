package com.formation.dao;

import java.util.List;

import com.formation.model.Voiture;

public interface IVoitureDao extends IManagerDao<Voiture> {

	public void ajouterVoiture();
	public void supprimerVoiture();
	public void majVoiture();
	public List<Voiture> consulterListeVoiture();
	public Voiture getByImmatriculation(String immatriculation);
	public List<Voiture> consulterListeVoitureDispo();
	public void consulterListeVoitureNonDispo();
	
}
