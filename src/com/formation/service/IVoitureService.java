package com.formation.service;

import java.util.List;

import com.formation.model.Voiture;

public interface IVoitureService extends IManagerService<Voiture> {

	public void ajouterVoiture();
	public void supprimerVoiture();
	public void majVoiture();
	public List<Voiture> consulterListeVoiture();
	public Voiture getByImmatriculation(String immatriculation);
	public List<Voiture> consulterListeVoitureDispo();
	public void consulterListeVoitureNonDispo();
	
}
