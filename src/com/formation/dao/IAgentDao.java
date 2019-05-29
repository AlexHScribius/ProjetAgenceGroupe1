package com.formation.dao;

import com.formation.model.Agent;

public interface IAgentDao extends IPersonneDao {

//	public void ajouterAgent() throws ParseException;
	public void supprimerAgent();
//	public void majAgent() throws ParseException;
	public void consulterListeAgent();
	public Agent getByLoginAndPassword(String login, String pwd);
	public Agent getByLogin(String login);
	public Agent getByNom(String nom);
	
}
