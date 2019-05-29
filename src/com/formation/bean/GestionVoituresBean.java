package com.formation.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.primefaces.event.RowEditEvent;

import com.formation.model.Client;
import com.formation.model.Location;
import com.formation.model.Voiture;
import com.formation.service.ILocationService;
import com.formation.service.IPersonneService;
import com.formation.service.IVoitureService;
import com.formation.service.impl.LocationService;
import com.formation.service.impl.PersonneService;
import com.formation.service.impl.VoitureService;

@ManagedBean (name="GestionVoituresBean")
@ViewScoped
public class GestionVoituresBean {

	///////////////////////////////////////////
	// Attributs :
	IVoitureService voitureService = new VoitureService();
	ILocationService locationService = new LocationService();
	IPersonneService personneService = new PersonneService();
	
	private String marque;
	private String immatriculation;
	private double prix;
	private int id_voiture;
	private int id_client;
	private static List<Voiture> listeVoitures;
	private static List<Voiture> listeVoituresDispo;
	private static List<Location> listeLocations;
	
	
	///////////////////////////////////////////
	// Méthodes :
	@PostConstruct
	private void init() {
		listeVoitures=getVoitureListAll();
		listeVoituresDispo=getVoitureList();
		listeLocations=getLocationListAll();
	}
	
	
	public List<Voiture> getVoitureList(){
		return voitureService.consulterListeVoitureDispo();
	}
	
	public List<Voiture> getVoitureListAll(){
		return voitureService.consulterListeVoiture();
	}
	
	public void reserverVoiture(Voiture v) {
		locationService.reserverVoiture(v, new Client(UserBean.getConnectedUser()));
	}
	
	public String saveAjout() {
		Voiture voiture = new Voiture(marque, immatriculation, prix, true);
		voitureService.add(voiture);
		listeVoitures=getVoitureListAll();
		return null;
	}
	
    public void onRowEditVoiture(RowEditEvent event) {
    	voitureService.update((Voiture) event.getObject());
        FacesMessage msg = new FacesMessage("Voiture modifiée");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancelVoiture(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Modification annulée");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowEditLocation(RowEditEvent event) {
    	locationService.update((Location) event.getObject());
        FacesMessage msg = new FacesMessage("Location modifiée");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancelLocation(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Modification annulée");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public List<Location> getLocationListAll(){
		return locationService.consulterListeLocation();
	}
	
	public String editerLocation (Location l) {
		return l.setEditable(true);
	}
	
	public String saveEditionLocation() {
		for (Location l : locationService.consulterListeLocation()) {
			l.setEditable(false);
		}
		return null;
	}
	
	public String supprimerVoiture (Voiture v) {
		voitureService.delete(v);
		return null;
	}
	
	public String supprimerLocation (Location l) {
		locationService.delete(l);
		return null;
	}
	
	public String saveAjoutLocation() {
		Voiture voiture = voitureService.findById(Voiture.class, id_voiture);
		Client client = (Client) personneService.findById(Client.class, id_client);
		locationService.reserverVoiture(voiture, client);
		return null;
	}
	
	public void saveVoiture(Voiture currentVoiture) {
		voitureService.update(currentVoiture);
	}
	
	///////////////////////////////////////////
	// Getters && Setters :
	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getId_voiture() {
		return id_voiture;
	}

	public void setId_voiture(int id_voiture) {
		this.id_voiture = id_voiture;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}


	public List<Voiture> getListeVoitures() {
		return listeVoitures;
	}


	public void setListeVoitures(List<Voiture> listeVoitures) {
		GestionVoituresBean.listeVoitures = listeVoitures;
	}


	public List<Voiture> getListeVoituresDispo() {
		return listeVoituresDispo;
	}


	public void setListeVoituresDispo(List<Voiture> listeVoituresDispo) {
		GestionVoituresBean.listeVoituresDispo = listeVoituresDispo;
	}


	public List<Location> getListeLocations() {
		return listeLocations;
	}


	public void setListeLocations(List<Location> listeLocations) {
		GestionVoituresBean.listeLocations = listeLocations;
	}
	
	
}






