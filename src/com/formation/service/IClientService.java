package com.formation.service;

import java.text.ParseException;

import com.formation.model.Client;

public interface IClientService extends IPersonneService {

	public void ajouterClient() throws ParseException;
	public void supprimerClient();
	public void majClient() throws ParseException;
	public void consulterListeClients() throws ParseException;
	public Client getByLoginAndPassword(String login, String pwd);
	public Client getByLogin(String login);
	public Client getByNom(String nom);
//	public Location louerVoiture();
//	public Location louerVoiture(String immatriculation);
	public void CreerCompteClient(String login) throws ParseException;
	
}
