package com.formation.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("client")
public class Client extends Personne implements Serializable {

	private static final long serialVersionUID = -6775460452688852723L;

	public static Client connectedClient;
	
	private Double choixPrix;
	private String choixMarque;
	private Double solde;
	
	List<Location> locations = new ArrayList<>();
	List<Agence> agences = new ArrayList<>();
	
	//constructeur paramétré
	public Client(Long id_personne, String nom, String prenom, String login, String pwd, String mail, String adresse,
			Date dateNaissance, Double choixPrix, String choixMarque, Double solde) {
		super(id_personne, nom, prenom, login, pwd, mail, adresse, dateNaissance);
		this.choixPrix = choixPrix;
		this.choixMarque = choixMarque;
		this.solde = solde;
	}

	//constructeur paramétré sans id
	public Client(String nom, String prenom, String login, String pwd, String mail, String adresse, Date dateNaissance,
			Double choixPrix, String choixMarque, Double solde) {
		super(nom, prenom, login, pwd, mail, adresse, dateNaissance);
		this.choixPrix = choixPrix;
		this.choixMarque = choixMarque;
		this.solde = solde;
	}

	//constructeur par défaut
	public Client() {
		super();
	}
	
	public Client(Personne currentPersonne) {
		this.setId_personne(currentPersonne.getId_personne());
		this.setAdresse(currentPersonne.getAdresse());
		this.setDateNaissance(currentPersonne.getDateNaissance());
		this.setLogin(currentPersonne.getLogin());
		this.setMail(currentPersonne.getMail());
		this.setMdp(currentPersonne.getMdp());
		this.setNom(currentPersonne.getNom());
		this.setPrenom(currentPersonne.getPrenom());
	}

	public Client(Long id_personne, String nom, String prenom, String login, String pwd, String mail, String adresse,
			Date dateNaissance) {
		super(id_personne, nom, prenom, login, pwd, mail, adresse, dateNaissance);
	}

	public Client(String nom, String prenom, String login, String pwd, String mail, String adresse,
			Date dateNaissance) {
		super(nom, prenom, login, pwd, mail, adresse, dateNaissance);
	}

	
	//getters setters
	@Column(name="choixPrix")
	public Double getChoixPrix() {
		return choixPrix;
	}

	public void setChoixPrix(Double choixPrix) {
		this.choixPrix = choixPrix;
	}

	@Column(name="choixMarque")
	public String getChoixMarque() {
		return choixMarque;
	}

	public void setChoixMarque(String choixMarque) {
		this.choixMarque = choixMarque;
	}

	@Column(name="Solde")
	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}
	

	public static Client getConnectedClient() {
		return connectedClient;
	}

	public static void setConnectedClient(Client connectedClient) {
		Client.connectedClient = connectedClient;
	}

	//getters setters association Location
	@OneToMany(mappedBy = "client")
	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	
	//getters setters association Agence
	@ManyToMany(mappedBy = "clients")
	public List<Agence> getAgences() {
		return agences;
	}

	public void setAgences(List<Agence> agences) {
		this.agences = agences;
	}

	//toString
	@Override
	public String toString() {
		return "Client [choixPrix=" + choixPrix + ", choixMarque=" + choixMarque + ", solde=" + solde + " " + super.toString() + "]";
	}
	
	
	
	
}
