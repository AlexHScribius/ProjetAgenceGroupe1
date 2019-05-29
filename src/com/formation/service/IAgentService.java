package com.formation.service;

import java.text.ParseException;

import com.formation.model.Agent;

public interface IAgentService extends IPersonneService {

	public void ajouterAgent() throws ParseException;
	public void supprimerAgent();
	public void majAgent() throws ParseException;
	public void consulterListeAgent();
	public Agent getByLogin(String login);
	public Agent getByNom(String nom);
	
}
