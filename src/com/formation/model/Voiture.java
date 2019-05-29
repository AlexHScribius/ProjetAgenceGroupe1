package com.formation.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Voiture")
public class Voiture implements Serializable {

	private static final long serialVersionUID = 1059682376624329721L;

	private Long id_voiture;
	private String marque;
	private String immatriculation;
	private double prix;
	private boolean dispo;
	private boolean editable;
	
	private Location location;
	private Agence agence;
	
	//constructeur paramétré
	public Voiture(Long id_voiture, String marque, String immatriculation, double prix, boolean dispo) {
		super();
		this.id_voiture = id_voiture;
		this.marque = marque;
		this.immatriculation = immatriculation;
		this.prix = prix;
		this.dispo = dispo;
	}

	//constructeur paramétré sans id
	public Voiture(String marque, String immatriculation, double prix, boolean dispo) {
		super();
		this.marque = marque;
		this.immatriculation = immatriculation;
		this.prix = prix;
		this.dispo = dispo;
	}

	//constructeur par défaut
	public Voiture() {
		super();
	}

	
	//getters setters
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_voiture")
	public Long getId_voiture() {
		return id_voiture;
	}

	public void setId_voiture(Long id_voiture) {
		this.id_voiture = id_voiture;
	}

	@Column(name = "marque")
	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	@Column(name = "immatriculation")
	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	@Column(name = "prix")
	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Column(name = "dispo")
	public boolean isDispo() {
		return dispo;
//		return this.dispo;
	}

	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}
	
	//getters setters association Location
	@OneToOne(mappedBy = "voiture")
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	//getters setters association Agence
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_agence")
	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	@Column(name="editable")
	public boolean isEditable() {
		return editable;
	}

	public String setEditable(boolean editable) {
		this.editable = editable;
		return null;
	}

	//toString
	@Override
	public String toString() {
		return "Voiture [id_voiture=" + id_voiture + ", marque=" + marque + ", immatriculation=" + immatriculation
				+ ", prix=" + prix + ", dispo=" + dispo + "]";
	}
	
	
	
}
