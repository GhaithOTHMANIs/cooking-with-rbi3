package com.dsi.tp1.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Adresse implements Serializable{


	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int code;

	private int numAppart;
	
	@Column(length=50)
	private String rue;
	
	@Column(length=30)
	private String ville;
	
	@Column(length=4)
	private String codePostal;
	
	
	@OneToOne(mappedBy = "adrissa")
	private Etudiant etudiant;
	
	
	
	public Adresse(String ville) {
		super();
		this.ville = ville;
	}


	public Adresse() {
		super();
	}

	
	
	@Override
	public String toString() {
		return "Adresse [ville=" + ville + "]";
	}
	
	

	//getters and setters


	


	public int getCode() {
		return code;
	}





	public void setCode(int code) {
		this.code = code;
	}





	public int getNumAppart() {
		return numAppart;
	}





	public void setNumAppart(int numAppart) {
		this.numAppart = numAppart;
	}





	public String getRue() {
		return rue;
	}





	public void setRue(String rue) {
		this.rue = rue;
	}





	public String getVille() {
		return ville;
	}





	public void setVille(String ville) {
		this.ville = ville;
	}





	public String getCodePostal() {
		return codePostal;
	}





	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	
	

}
