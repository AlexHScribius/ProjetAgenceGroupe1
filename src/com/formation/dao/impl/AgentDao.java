package com.formation.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.formation.dao.IAgentDao;
import com.formation.model.Agent;
import com.formation.model.Personne;


public class AgentDao extends PersonneDao implements IAgentDao {

	DateFormat dateformat = new SimpleDateFormat("dd/mm/yyyy");

	@SuppressWarnings("resource")
	@Override
	public void supprimerAgent() {
		String repeat="oui";
		
		while (repeat == "oui") {
			Scanner input =new Scanner(System.in);
			System.out.print("Veuillez saisir le nom de l'agent à supprimer : ");
			String nom= input.next();
			AgentDao a = new AgentDao();
			Agent a1=new Agent();
			if(a.getByNom(nom) == null) {
				System.out.println("Cet agent n'existe pas");
			}else {
				repeat ="non";
				a1=a.getByNom(nom);
				a.delete(a1);
				System.out.println("L'agent a été supprimé");
			}
		}		
		
	}

//	@SuppressWarnings("resource")
//	@Override
//	public void majAgent() throws ParseException {
//		String repeat="oui";
//		
//		while (repeat == "oui") {
//			Scanner input = new Scanner(System.in);
//			System.out.print("Veuillez saisir le nom de l'agent à modifier : ");
//			String nom= input.next();
//			AgentDao a= new AgentDao();
//			Agent a1=new Agent();
//			if(a.getByNom(nom) == null) {
//				System.out.println("Cet agent n'existe pas");
//			}else {
//				
//				repeat="non";
//				a1=a.getByNom(nom);
//			
//				System.out.println("\nVeuillez saisir son nom : ");
//				a1.setNom(input.next());
//				System.out.println("\nVeuillez saisir son prenom : ");
//				a1.setPrenom(input.next());
//				System.out.println("\nVeuillez saisir son mail");
//				a1.setMail(input.next());
//				System.out.println("\nVeuillez saisir son adresse");
//				input.nextLine();
//				a1.setAdresse(input.nextLine());
//				System.out.println("\nVeuillez saisir sa date naissance");
//				a1.setDateNaissance(dateformat.parse(input.next()));
//				System.out.println("\nVeuillez saisir sa date d'embauche");
//				a1.setDateEmbauche(dateformat.parse(input.next()));
//				System.out.println("\nVeuillez saisir sa fonction");
//				a1.setFonction(input.next());
//						
//				a.update(a1);
//				System.out.println("L'agent a bien été modifié.");
//				
//			}
//						
//		}
//		
//	}

	@Override
	public void consulterListeAgent() {
		System.out.println("Liste des agents");
		AgentDao agentDao = new AgentDao();
		List<Personne> ag = agentDao.findAll(Agent.class);
		for (Personne ag1 : ag) {
			System.out.println();
			System.out.println(ag1.toString());
		}
		}
	

	@SuppressWarnings("static-access")
	@Override
	public Agent getByLoginAndPassword(String login, String pwd) {
			Criteria criteria = this.getSessionFactory().openSession().createCriteria(Agent.class);
			criteria.add(Restrictions.eq("login", login));
			criteria.add(Restrictions.eq("pwd", pwd));
			return (Agent) criteria.uniqueResult();
	}

	@SuppressWarnings("static-access")
	@Override
	public Agent getByLogin(String login) {
		Criteria criteria = this.getSessionFactory().openSession().createCriteria(Agent.class);
		criteria.add(Restrictions.eq("login", login));
		return (Agent) criteria.uniqueResult();
	}

	@SuppressWarnings("static-access")
	@Override
	public Agent getByNom(String nom) {
		Criteria criteria = this.getSessionFactory().openSession().createCriteria(Agent.class);
		criteria.add(Restrictions.eq("nom", nom));
		return (Agent) criteria.uniqueResult();
	}

}
