package com.dsi.tp1.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class EtatLivre implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int code;
	
	private boolean disponible;
	
	private boolean emprunte;

	
	@OneToMany(mappedBy="etatL")
	private List<Livre> livres;
	
	


	
	




	@Override
	public String toString() {
		return "EtatLivre [disponible=" + disponible + ", emprunte=" + emprunte + "]";
	}




	public EtatLivre(boolean disponible, boolean emprunte) {
		super();
		this.disponible = disponible;
		this.emprunte = emprunte;
	}




	public EtatLivre() {
		super();
	}
	
	
	

	//getters and setters
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public boolean isEmprunte() {
		return emprunte;
	}

	public void setEmprunte(boolean emprunte) {
		this.emprunte = emprunte;
	}
	
	
	
	

	
}
