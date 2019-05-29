package com.formation.service.impl;

import java.util.List;

import com.formation.dao.ILocationDao;
import com.formation.dao.impl.LocationDao;
import com.formation.model.Client;
import com.formation.model.Location;
import com.formation.model.Voiture;
import com.formation.service.ILocationService;

public class LocationService extends ManagerService<Location> implements ILocationService {

	ILocationDao locationDao= new LocationDao();
	
	public void reserverVoiture(Voiture v,Client c) {
		locationDao.creerLocation(v,c);
	}
	
	public List<Location> consulterListeLocation(){
		return locationDao.consulterListeLocation();
	}
	
}
