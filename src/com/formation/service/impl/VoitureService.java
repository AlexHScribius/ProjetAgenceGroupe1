package com.formation.service.impl;

import java.util.List;

import com.formation.dao.IVoitureDao;
import com.formation.dao.impl.VoitureDao;
import com.formation.model.Voiture;
import com.formation.service.IVoitureService;

public class VoitureService extends ManagerService<Voiture> implements IVoitureService {

	IVoitureDao dao = new VoitureDao();
	
	@Override
	public void ajouterVoiture() {
		dao.ajouterVoiture();
	}

	@Override
	public void supprimerVoiture() {
		dao.supprimerVoiture();
	}

	@Override
	public void majVoiture() {
		dao.majVoiture();
	}

	@Override
	public List<Voiture> consulterListeVoiture() {
		return dao.consulterListeVoiture();
	}

	@Override
	public Voiture getByImmatriculation(String immatriculation) {
		return dao.getByImmatriculation(immatriculation);
	}

	@Override
	public List<Voiture> consulterListeVoitureDispo() {
		return dao.consulterListeVoitureDispo();
	}

	@Override
	public void consulterListeVoitureNonDispo() {
		dao.consulterListeVoitureNonDispo();
	}

	
	
}
