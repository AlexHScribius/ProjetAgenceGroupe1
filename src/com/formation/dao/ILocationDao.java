package com.formation.dao;

import java.util.List;

import com.formation.model.Client;
import com.formation.model.Location;
import com.formation.model.Voiture;

public interface ILocationDao extends IManagerDao<Location> {

	public void creerLocation(Voiture v,Client c);
	public List<Location> consulterListeLocation();
	
}
