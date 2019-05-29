package com.formation.service;

import java.util.List;

import com.formation.model.Client;
import com.formation.model.Location;
import com.formation.model.Voiture;

public interface ILocationService extends IManagerService<Location> {

	public void reserverVoiture(Voiture v,Client c);
	public List<Location> consulterListeLocation();
	
	
}
