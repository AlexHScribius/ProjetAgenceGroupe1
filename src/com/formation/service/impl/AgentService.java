package com.formation.service.impl;

import java.text.ParseException;

import com.formation.dao.IAgentDao;
import com.formation.dao.impl.AgentDao;
import com.formation.model.Agent;
import com.formation.service.IAgentService;

public class AgentService extends PersonneService implements IAgentService {

	IAgentDao dao = new AgentDao();
	
	@Override
	public void ajouterAgent() throws ParseException {
//		dao.ajouterAgent();
	}

	@Override
	public void supprimerAgent() {
		dao.supprimerAgent();
	}

	@Override
	public void majAgent() throws ParseException {
//		dao.majAgent();
	}

	@Override
	public void consulterListeAgent() {
		dao.consulterListeAgent();
	}

	@Override
	public Agent getByLoginAndPassword(String login, String pwd) {
		return dao.getByLoginAndPassword(login, pwd);
	}

	@Override
	public Agent getByLogin(String login) {
		return dao.getByLogin(login);
	}

	@Override
	public Agent getByNom(String nom) {
		return dao.getByNom(nom);
	}

}
