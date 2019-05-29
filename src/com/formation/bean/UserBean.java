package com.formation.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;

import com.formation.model.Client;
import com.formation.model.Personne;
import com.formation.service.IPersonneService;
import com.formation.service.impl.PersonneService;
import com.formation.util.HibernateUtil;

@ManagedBean(name = "UserBean")
@SessionScoped
public class UserBean extends HibernateUtil implements Serializable {

	private static final long serialVersionUID = -570101150423358447L;
	/////////////////////////////////////////////
	// Attributs :
	private String login;
	private String pwd;
	private static Personne connectedUser;

	/////////////////////////////////////////////
	// Méthodes :
	public String connect() {
		// on vérifie que la personne existe dans la base
		IPersonneService personneservice = new PersonneService();
		connectedUser=personneservice.getByLoginAndPassword(login, pwd);
		if (connectedUser == null) {
			
			return "index";

		} else {
			Personne.connectedUser = personneservice.getByLoginAndPassword(login, pwd);
			connectedUser=Personne.connectedUser;
			
			return (Personne.connectedUser instanceof Client)?"MenuClient" : "MenuAgent";
		}
	}
	
	@PostConstruct
	public void init() {
		@SuppressWarnings("static-access")
		Session hibernateSession = this.getSessionFactory().openSession();
	}

	/////////////////////////////////////////////
	// Getters && Setters :
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public static Personne getConnectedUser() {
		return connectedUser;
	}

	public static void setConnectedUser(Personne connectedUser) {
		UserBean.connectedUser = connectedUser;
	}
	

}