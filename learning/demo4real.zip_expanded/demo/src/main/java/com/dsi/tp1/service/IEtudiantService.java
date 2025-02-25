package com.dsi.tp1.service;

import java.util.List;

import com.dsi.tp1.entities.Etudiant;

public interface IEtudiantService {

	public List<Etudiant> getAllEtudiant();
	public Etudiant findEtudiant(int id);
	public boolean saveEtudiant(Etudiant etudiant);
	public boolean deleteEtudiant(int id);
	public Etudiant updateEtudiant(Etudiant etudiant, int id);
	public List<Etudiant> findEtudiantsParNom(String nom);
}
