package com.dsi.tp1.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "livre_biblio")  // Change the table name to "livre_biblio"
public class Livre implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Column(name = "code")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int code;
	
	@Column(name = "isbn")
	private String ISBN;
	
	@Column(name = "titre_livre")
	private String titre;
	
	@Column(name = "auteur_livre", length = 40)
	private String auteur;
	
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="idEtat")
	private EtatLivre etatL;
	
	
	@ManyToMany(mappedBy= "livres")
	private List<Etudiant> etudiants=new ArrayList<>();
	
	
	
	/*
	 * @Temporal(TemporalType.DATE) NOT required after JPA 2.1 and java.time.LocalDate
	 * 
	 * but might be when using java.util.Date and java.util.Calendar
	 * java.time package are automatically handled by JPA 2.1 and later without the need for @Temporal
	 * not the case for java.util
	 */
	
	@Column(name = "date_publication")
	private LocalDate date_de_publication;
	
	@Column(name = "nb_copies")
	private int nombre_de_copies;

	
	
	@Override
	public String toString() {
		return "Livre [titre=" + titre + ", auteur=" + auteur + ", etatL=" + etatL + "]";
	}
	
	
	public Livre(String titre, String auteur, EtatLivre etatL) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.etatL = etatL;
	}


	public Livre() {	
		super();
	}
	
	
	//getters and setters
	
	

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public LocalDate getDate_de_publication() {
		return date_de_publication;
	}

	public void setDate_de_publication(LocalDate date_de_publication) {
		this.date_de_publication = date_de_publication;
	}

	public int getNombre_de_copies() {
		return nombre_de_copies;
	}

	public void setNombre_de_copies(int nombre_de_copies) {
		this.nombre_de_copies = nombre_de_copies;
	}


	public List<Etudiant> getEtudiants() {
		return etudiants;
	}


	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	
	
	
	
	
}
