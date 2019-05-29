package com.formation.dao;

import java.text.ParseException;

import com.formation.model.Client;

public interface IClientDao extends IPersonneDao {

	public void ajouterClient() throws ParseException;
	public void supprimerClient();
	public void majClient() throws ParseException;
	public void consulterListeClients();
	public Client getByLoginAndPassword(String login, String pwd);
	public Client getByLogin(String login);
	public Client getByNom(String nom);
//	public Location louerVoiture();
//	public Location louerVoiture(String immatriculation);
	public void CreerCompteClient(String login) throws ParseException;
	
}
