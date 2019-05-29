package com.formation.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Agence")
public class Agence implements Serializable {

	private static final long serialVersionUID = -8932662519554325201L;

	private Long id_agence;
	private String nom;
	private String adresse;
	
	List<Voiture> voitures = new ArrayList<>();
	List<Client> clients = new ArrayList<>();
	List<Agent> agents= new ArrayList<Agent>();
	
	//constructeur paramétré
	public Agence(Long id_agence, String nom, String adresse) {
		super();
		this.id_agence = id_agence;
		this.nom = nom;
		this.adresse = adresse;
	}

	//constructeur paramétré sans id
	public Agence(String nom, String adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
	}


	//constructeur par défaut
	public Agence() {
		super();
	}

	
	//getters setters
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_agence")
	public Long getId_agence() {
		return id_agence;
	}

	public void setId_agence(Long id_agence) {
		this.id_agence = id_agence;
	}

	@Column(name = "nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "adresse")
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	
	//getters setters association Voiture
	@OneToMany(mappedBy = "agence")
	public List<Voiture> getVoitures() {
		return voitures;
	}

	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}
	
	//getters setters association Agent
	@OneToMany(mappedBy = "agence")
	public List<Agent> getAgents() {
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
	

	//getters setters association Client
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "client_agence", joinColumns = { @JoinColumn(name = "id_agence") }, inverseJoinColumns = { @JoinColumn(name = "id_client") })
	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	//toString
	@Override
	public String toString() {
		return "Agence [id_agence=" + id_agence + ", nom=" + nom + ", adresse=" + adresse + "]";
	}
	
	
	
}
