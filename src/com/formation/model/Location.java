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
@Table(name = "Location")
public class Location implements Serializable {

	private static final long serialVersionUID = -1459467416237584659L;

	private Long id_location;
	private boolean editable;
	
	private Voiture voiture;
	private Client client;
	
	//constructeur par défaut
	public Location() {
		super();
	}

	
	//getters setters
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_location")
	public Long getId_location() {
		return id_location;
	}

	public void setId_location(Long id_location) {
		this.id_location = id_location;
	}

	public boolean isEditable() {
		return editable;
	}


	public String setEditable(boolean editable) {
		this.editable = editable;
		return null;
	}


	//getters setters association Voiture
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_voiture")
	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	
	//getters setters association Client
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_client")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	//toString
	@Override
	public String toString() {
		return "Location [id_location=" + id_location + ", voiture=" + voiture + ", client=" + client + "]";
	}
	
	
}
