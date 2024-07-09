package com.dsi.tp1.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Etudiant implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int code;

	private String nom;
	
	private String prenom;
	
	@Temporal(TemporalType.DATE)
	private LocalDate dateNaissance;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="idAdresse")
	private Adresse adrissa;
	
	
	@ManyToMany
    @JoinTable(
        name = "emprunt",
        joinColumns = @JoinColumn(name = "etudiant_id"),
        inverseJoinColumns = @JoinColumn(name = "livre_id")
	)
	private List<Livre> livres=new ArrayList<>();
	
	public Etudiant() {
		super();
	}
	

	public Etudiant(String nom, String prenom, LocalDate dateNaissance, Adresse adrissa) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adrissa = adrissa;
	}



	public Etudiant(String nom, String prenom, LocalDate dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}



	@Override
	public String toString() {
		return "Etudiant [nom=" + nom + ", prenom=" + prenom + ", adrissa=" + adrissa + "]";
	}
	
	
	
	
	//getters and setters

	
	


	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public Adresse getAdrissa() {
		return adrissa;
	}


	public void setAdrissa(Adresse adrissa) {
		this.adrissa = adrissa;
	}


	public List<Livre> getLivres() {
		return livres;
	}


	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}
	
	
	
	
}
