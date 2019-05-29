package com.formation.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Personne")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="statut",discriminatorType=DiscriminatorType.STRING,length=6)
public abstract class Personne implements Serializable {

	private static final long serialVersionUID = -4772344647242374889L;
	
	public static Personne connectedUser;
	
	private Long id_personne;
	private String nom;
	private String prenom;
	private String login;
	private String pwd;
	private String mail;
	private String adresse;
	private Date dateNaissance;
	
	//constructeur paramétré
	public Personne(Long id_personne, String nom, String prenom, String login, String pwd, String mail, String adresse,
			Date dateNaissance) {
		super();
		this.id_personne = id_personne;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.pwd = pwd;
		this.mail = mail;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
	}

	//constructeur paramétré sans id
	public Personne(String nom, String prenom, String login, String pwd, String mail, String adresse,
			Date dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.pwd = pwd;
		this.mail = mail;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
	}

	//constructeur par défaut
	public Personne() {
		super();
	}

	
	//getters setters
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_personne")
	public Long getId_personne() {
		return id_personne;
	}

	public void setId_personne(Long id_personne) {
		this.id_personne = id_personne;
	}

	@Column(name = "nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prenom")
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "login")
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "pwd")
	public String getMdp() {
		return pwd;
	}

	public void setMdp(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "mail")
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name = "adresse")
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name = "dateNaissance")
	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	
	public static Personne getConnectedUser() {
		return connectedUser;
	}

	public static void setConnectedUser(Personne connectedUser) {
		Personne.connectedUser = connectedUser;
	}

	//toString
	@Override
	public String toString() {
		return "Personne [id_personne=" + id_personne + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login
				+ ", pwd=" + pwd + ", mail=" + mail + ", adresse=" + adresse + ", dateNaissance=" + dateNaissance + "]";
	}
	
	

}
