package com.formation.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("agent")
public class Agent extends Personne implements Serializable {

	private static final long serialVersionUID = 7706350252168417880L;

	private Date dateEmbauche;
	private Agence agence;

	//constructeur paramétré
	public Agent(Long id_personne, String nom, String prenom, String login, String pwd, String mail, String adresse,
			Date dateNaissance, Date dateEmbauche) {
		super(id_personne, nom, prenom, login, pwd, mail, adresse, dateNaissance);
		this.dateEmbauche = dateEmbauche;
	}

	//constructeur paramétré sans id
	public Agent(String nom, String prenom, String login, String pwd, String mail, String adresse, Date dateNaissance,
			Date dateEmbauche) {
		super(nom, prenom, login, pwd, mail, adresse, dateNaissance);
		this.dateEmbauche = dateEmbauche;
	}

	//constructeur par défaut
	public Agent() {
		super();
	}

	//getters setters
	@Column(name="dateEmbauche")
	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_agence")
	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	//toString
	@Override
	public String toString() {
		return super.toString() + "Agent [dateEmbauche=" + dateEmbauche + "]";
	}

	
	
	
	
}
