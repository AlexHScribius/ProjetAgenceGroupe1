package com.formation.service.impl;

import java.text.ParseException;

import com.formation.dao.IClientDao;
import com.formation.dao.impl.ClientDao;
import com.formation.model.Client;
import com.formation.service.IClientService;

public class ClientService extends PersonneService implements IClientService {

	IClientDao dao = new ClientDao();
	
	@Override
	public void ajouterClient() throws ParseException {
		dao.ajouterClient();		
	}

	@Override
	public void supprimerClient() {
		dao.supprimerClient();
	}

	@Override
	public void majClient() throws ParseException {
		dao.majClient();
	}

	@Override
	public void consulterListeClients() {
		dao.consulterListeClients();
	}

	@Override
	public Client getByLoginAndPassword(String login, String pwd) {
		return dao.getByLoginAndPassword(login, pwd);
	}

	@Override
	public Client getByLogin(String login) {
		return dao.getByLogin(login);
	}

	@Override
	public Client getByNom(String nom) {
		return dao.getByNom(nom);
	}

	@Override
	public void CreerCompteClient(String login) throws ParseException {
		dao.CreerCompteClient(login);
		
	}

}
