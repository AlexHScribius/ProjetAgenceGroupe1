package com.formation.dao.impl;

import java.util.List;

import com.formation.dao.ILocationDao;
import com.formation.model.Client;
import com.formation.model.Location;
import com.formation.model.Voiture;

public class LocationDao extends ManagerDao<Location> implements ILocationDao {

	@Override
	public void creerLocation(Voiture v,Client c) {
		Location l = new Location();
		l.setVoiture(v);
		l.setClient(c);
		v.setDispo(false);
	}
	
	public List<Location> consulterListeLocation(){
		LocationDao locationDao = new LocationDao();
		return locationDao.findAll(Location.class);
	}
	
	
}