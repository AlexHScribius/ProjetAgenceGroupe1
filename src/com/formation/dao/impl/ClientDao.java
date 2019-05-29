package com.formation.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.formation.dao.IClientDao;
import com.formation.model.Client;
import com.formation.model.Personne;
import com.formation.model.Voiture;

public class ClientDao extends PersonneDao implements IClientDao {


	DateFormat dateformat = new SimpleDateFormat("dd/mm/yyyy");
	
	@SuppressWarnings("resource")
	@Override
	public void ajouterClient() throws ParseException {
		Scanner input = new Scanner(System.in);
		ClientDao c = new ClientDao();
		Client c1 = new Client();
		
		System.out.println("\nVeuillez saisir son nom : ");
		c1.setNom(input.next());
		System.out.println("\nVeuillez saisir son prenom : ");
		c1.setPrenom(input.next());
		System.out.println("\nVeuillez saisir son mail");
		c1.setMail(input.next());
		System.out.println("\nVeuillez saisir son adresse");
		input.nextLine();
		c1.setAdresse(input.nextLine());
		System.out.println("\nVeuillez saisir sa date naissance");
		c1.setDateNaissance(dateformat.parse(input.next()));
		System.out.println("\nVeuillez saisir son choix de prix");
		c1.setChoixPrix(input.nextDouble());
		System.out.println("\nVeuillez saisir son choix de marque");
		c1.setChoixMarque(input.next());
		System.out.println("\nVeuillez saisir son solde");
		c1.setChoixPrix(input.nextDouble());
		
		c.add(c1);
		System.out.println("Client ajouté");
}
	
	@SuppressWarnings("resource")
	@Override
	public void supprimerClient() {
		String repeat="oui";
		
		while (repeat == "oui") {
			Scanner input =new Scanner(System.in);
			System.out.print("Veuillez saisir le nom du client à supprimer : ");
			String nom= input.next();
			ClientDao c= new ClientDao();
			Client c1=new Client();
			if(c.getByNom(nom) == null) {
				System.out.println("Ce client n'existe pas");
			}else {
				repeat ="non";
				c1=c.getByNom(nom);
				c.delete(c1);
				System.out.println("Le client a été supprimé");
			}
		}		
	}


	@SuppressWarnings("resource")
	@Override
	public void majClient() throws ParseException {
		String repeat="oui";
		
		while (repeat == "oui") {
			Scanner input = new Scanner(System.in);
			System.out.print("Veuillez saisir le nom du client à modifier : ");
			String nom= input.next();
			ClientDao c= new ClientDao();
			Client c1=new Client();
			if(c.getByNom(nom) == null) {
				System.out.println("Ce client n'existe pas");
			}else {
				
				repeat="non";
				c1=c.getByNom(nom);
			
				System.out.println("\nVeuillez saisir son nom : ");
				c1.setNom(input.next());
				System.out.println("\nVeuillez saisir son prenom : ");
				c1.setPrenom(input.next());
				System.out.println("\nVeuillez saisir son mail");
				c1.setMail(input.next());
				System.out.println("\nVeuillez saisir son adresse");
				input.nextLine();
				c1.setAdresse(input.nextLine());
				System.out.println("\nVeuillez saisir sa date naissance");
				c1.setDateNaissance(dateformat.parse(input.next()));
				System.out.println("\nVeuillez saisir son choix de prix");
				c1.setChoixPrix(input.nextDouble());
				System.out.println("\nVeuillez saisir son choix de marque");
				c1.setChoixMarque(input.next());
				System.out.println("\nVeuillez saisir son solde");
				c1.setChoixPrix(input.nextDouble());
				
				
				c.update(c1);
				System.out.println("Le client a bien été modifié.");
				
			}
						
		}
		
	}

	@Override
	public void consulterListeClients() {
		System.out.println("Liste des clients");
		ClientDao clientDao = new ClientDao();
		List<Personne> c = clientDao.findAll(Client.class);
		for (Personne c1 : c) {
			System.out.println();
			System.out.println(c1.toString());
		}
			
	}
		

	@SuppressWarnings("static-access")
	@Override
	public Client getByLoginAndPassword(String login, String pwd) {
		Criteria criteria = this.getSessionFactory().openSession().createCriteria(Client.class);
		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("pwd", pwd));
		return (Client) criteria.uniqueResult();
	}

	@SuppressWarnings("static-access")
	@Override
	public Client getByLogin(String login) {
			Criteria criteria = this.getSessionFactory().openSession().createCriteria(Client.class);
			criteria.add(Restrictions.eq("login", login));
			return (Client) criteria.uniqueResult();
	}

	@SuppressWarnings("static-access")
	@Override
	public Client getByNom(String nom) {
		Criteria criteria = this.getSessionFactory().openSession().createCriteria(Client.class);
		criteria.add(Restrictions.eq("nom", nom));
		return (Client) criteria.uniqueResult();
	}

//	@Override
//	public Location louerVoiture() {
//		Location loc1 = new Location();
//		@SuppressWarnings("resource")
//		Scanner sc = new Scanner(System.in);
//		VoitureDao vdao = new VoitureDao();
//		
//		String repeat = "oui";
//		while (repeat == "oui") {
//			System.out.println("Liste des voitures disponibles");
//			vdao.consulterListeVoitureDispo();
//			System.out.println();
//			System.out.println("Sélectionner l'immatriculation de la voiture à louer");
//
//			Voiture v = new Voiture();
//			String immatriculation = sc.next();
//
//			v= vdao.getByImmatriculation(immatriculation);
//			
//			if (v.isDispo() == false) {
//				System.out.println();
//				System.out.println("Voiture déjà louée, veuillez rentrer une nouvelle immatriculation");
//			} else {
//				v.setDispo(false); // on met a jour la disponibilité de la voiture dans la liste comme étant
//									// indisponible
//				System.out.println("Combien de jours voulez-vous louer le véhicule ?");
//				loc1.setDuree(sc.nextInt());
//				if (loc1.getDuree() <= 0) {
//					System.out.println("Veuillez rentrer un nombre positif.");
//				} else {
//					double cout = v.getPrix() * loc1.getDuree();
//					loc1.setCout(cout);
//					System.out.println("Location effectuée, le prix de la location est:" + loc1.getCout());
//					
//					Client.connectedClient = (Client) Personne.connectedUser;
//					
//					
//					Client.connectedClient.setSolde(Client.connectedClient.getSolde() - loc1.getCout());
//					update(Client.connectedClient);
//					System.out.println("Votre nouveau solde est: " + Client.connectedClient.getSolde());
//
//					repeat = "non";
//				}
//				
//			}
//		}
//		return loc1;
//	}

//	@Override
//	public Location louerVoiture(String immatriculation) {
//		Scanner sc = new Scanner(System.in);
//		Location loc1 = new Location();
//		VoitureDao v = new VoitureDao();
//
//		String repeat = "oui";
//		while (repeat == "oui") {
//			System.out.println("Combien de jours voulez-vous louer le véhicule ?");
//			loc1.setDuree(sc.nextInt());
//			if (loc1.getDuree() <= 0) {
//				System.out.println("Veuillez rentrer un nombre positif.");
//			} else {
//				repeat = "non";
//			}
//		}
//		Calendar c = Calendar.getInstance();
//		Date d = Date.from(c.toInstant());
//		loc1.setDateEmprunt(d);
//
//		loc1.setClient(Client.getConnectedClient());
//		loc1.setVoiture(v.getByImmatriculation(immatriculation));
//		double cout = v.getByImmatriculation(immatriculation).getPrix() * loc1.getDuree();
//		loc1.setCout(cout);
//
//		sc.close();
//		return loc1;
//	}



	@SuppressWarnings("resource")
	@Override
	public void CreerCompteClient(String login) throws ParseException {
		Scanner sc =new Scanner(System.in);
		ClientDao c= new ClientDao();
		Client c1=new Client();
		
		c1.setLogin(login);
		
		System.out.print("\nVeuillez saisir votre mdp : ");
		c1.setMdp(sc.next());
		System.out.print("\nVeuillez saisir votre prenom : ");
		c1.setPrenom(sc.next());
		System.out.print("\nVeuillez saisir votre nom : ");
		c1.setNom(sc.next());
		System.out.print("\nVeuillez saisir votre date de naissance (jj/mm/aaaa) : ");
		c1.setDateNaissance(dateformat.parse(sc.next()));
		System.out.print("\nVeuillez saisir votre mail : ");
		c1.setMail(sc.next());
		System.out.print("\nVeuillez saisir votre adresse : ");
		sc.nextLine();
		c1.setAdresse(sc.nextLine());
		System.out.print("\nVeuillez saisir votre choix de prix : ");
		c1.setChoixPrix(sc.nextDouble());
		System.out.print("\nVeuillez saisir votre choix de marque : ");
		c1.setChoixMarque(sc.next());
		System.out.print("\nVeuillez saisir votre solde : ");
		c1.setSolde(sc.nextDouble());
			//maj client:
		c.add(c1);
		System.out.println("le client a bien été ajouté.");
		
		
	}

	@Override
	public List<Voiture> consulterCatalogue() {
		// TODO Auto-generated method stub
		return null;
	}
		
	}
	


