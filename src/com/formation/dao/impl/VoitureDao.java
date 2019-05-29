package com.formation.dao.impl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.formation.dao.IVoitureDao;
import com.formation.model.Voiture;

public class VoitureDao extends ManagerDao<Voiture> implements IVoitureDao {

	@SuppressWarnings("resource")
	@Override
	public void ajouterVoiture() {
		Scanner input = new Scanner(System.in);
		VoitureDao v = new VoitureDao();
		Voiture v1 = new Voiture();
		
		System.out.println("\nVeuillez saisir sa marque : ");
		v1.setMarque(input.next());
		System.out.println("\nVeuillez saisir son immatriculation : ");
		v1.setImmatriculation(input.next());
		System.out.println("\nVeuillez saisir son prix");
		v1.setPrix(input.nextDouble());
		System.out.println("\nVeuillez saisir sa disponibilité");
		v1.setDispo(input.hasNext());
		
		v.add(v1);
		System.out.println("Vehicule ajouté");
		
	}

	@SuppressWarnings("resource")
	@Override
	public void supprimerVoiture() {
		String repeat="oui";
		
		while (repeat == "oui") {
			Scanner input =new Scanner(System.in);
			System.out.print("Veuillez saisir l'immatriculation du véhicule à supprimer : ");
			String immatriculation = input.next();
			VoitureDao v = new VoitureDao();
			Voiture v1=new Voiture();
			if(v.getByImmatriculation(immatriculation) == null) {
				System.out.println("Ce véhicule n'existe pas");
			}else {
				repeat ="non";
				v1=v.getByImmatriculation(immatriculation);
				v.delete(v1);
				System.out.println("Le véhicule a été supprimé");
			}
		}		
		
	}

	@SuppressWarnings("resource")
	@Override
	public void majVoiture() {
		String repeat="oui";
		
		while (repeat == "oui") {
			Scanner input = new Scanner(System.in);
			System.out.print("Veuillez saisir l'immatriculation du véhicule à modifier : ");
			String immatriculation = input.next();
			VoitureDao v = new VoitureDao();
			Voiture v1 = new Voiture();
			if(v.getByImmatriculation(immatriculation) == null) {
				System.out.println("Ce véhicule n'existe pas");
			}else {
				
				repeat="non";
				v1=v.getByImmatriculation(immatriculation);
			
				System.out.println("\nVeuillez saisir sa marque : ");
				v1.setMarque(input.next());
				System.out.println("\nVeuillez saisir son immatriculation : ");
				v1.setImmatriculation(input.next());
				System.out.println("\nVeuillez saisir son prix");
				v1.setPrix(input.nextDouble());
				System.out.println("\nVeuillez saisir sa disponibilité");
				v1.setDispo(input.hasNext());
				
				v.update(v1);
				System.out.println("Le véhicule a bien été modifié.");
				
			}
						
		}
		
	}

	@Override
	public List<Voiture> consulterListeVoiture() {
		VoitureDao voitureDao = new VoitureDao();
		return voitureDao.findAll(Voiture.class);
	}
	

	@SuppressWarnings("static-access")
	@Override
	public Voiture getByImmatriculation(String immatriculation) {
		Criteria criteria = this.getSessionFactory().openSession().createCriteria(Voiture.class);
		criteria.add(Restrictions.eq("immatriculation", immatriculation));
		return (Voiture) criteria.uniqueResult();
	}

	@Override
	public List<Voiture> consulterListeVoitureDispo() {
		VoitureDao voitureDao = new VoitureDao();
		return voitureDao.findAll(Voiture.class);
	}

	@Override
	public void consulterListeVoitureNonDispo() {
		VoitureDao voitureDao = new VoitureDao();
		List<Voiture> v = voitureDao.findAll(Voiture.class);
		for (Voiture v1 : v) {
			if (!v1.isDispo()) {
			System.out.println();
			System.out.print(v1.toString());
		}
			}
				
	}

}
