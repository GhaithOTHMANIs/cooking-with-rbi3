package com.dsi.tp1.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dsi.tp1.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer>{

	//JPQL still better and more secure than SQL, and also portable
	@Query(
		value = "SELECT TIMESTAMPDIFF(YEAR, date_naissance, CURRENT_DATE) AS age "
				+ "FROM Etudiant WHERE code=1", 
		nativeQuery = true
	)
	int selectQuerytest();
	
	
	@Query(
			value = "SELECT TIMESTAMPDIFF(YEAR, date_naissance, CURRENT_DATE) AS age "
					+ "FROM Etudiant ", 
			nativeQuery = true
		)
	int[] selectAllAges();
	
	
	
	@Query(
		value = "SELECT * FROM Etudiant", 
		nativeQuery = true
	)
	List<Etudiant> findAllWithNativeSQL();
	List<Etudiant> findAllByNom(String nom);
}
