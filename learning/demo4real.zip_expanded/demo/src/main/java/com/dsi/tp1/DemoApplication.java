package com.dsi.tp1;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dsi.tp1.entities.Adresse;
import com.dsi.tp1.entities.EtatLivre;
import com.dsi.tp1.entities.Etudiant;
import com.dsi.tp1.entities.Livre;
import com.dsi.tp1.repositories.EtatLivreRepository;
import com.dsi.tp1.repositories.EtudiantRepository;
import com.dsi.tp1.repositories.LivreRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	
	@Autowired
	private EtudiantRepository etudiantRepo;
	
	@Autowired
	private EtatLivreRepository etatLivreRepo;
	
	@Autowired
	private LivreRepository livreRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	
	
	@Override
	@Transactional //ensures that all database operations within this method are part of the same transaction.
	public void run (String... args)throws Exception{
		Etudiant et1= new Etudiant("etudiant_1","etudiant_1",LocalDate.of(2000,2,12),new Adresse("Ariana"));
		Etudiant et2= new Etudiant("etudiant_2","etudiant_2",LocalDate.of(2001,11,5),new Adresse("Grande"));
		etudiantRepo.save(et1);
		etudiantRepo.save(et2);
	
		List<Etudiant> listeEtudiants = etudiantRepo.findAll();
	
		
		System.out.println(listeEtudiants);
		
		
		EtatLivre etat1=new EtatLivre(true, true);
		EtatLivre etat2=new EtatLivre(true, true);
		
		etatLivreRepo.save(etat1);
		etatLivreRepo.save(etat2);
		
		
		livreRepo.save(new Livre( "je ne regrette rien", "Ghaith", etat1));
		livreRepo.save(new Livre( "oh la la", "Ghaith", etat1));
		livreRepo.save(new Livre( "who asked", "SOne", etat2));
		
		List<Livre> listeLivres= livreRepo.findAll();
		
		System.out.println(listeLivres);
		
		
		//getReferenceById returns a proxy object that loads the actual entity from the database on-demand
		borrowBook(et1, livreRepo.getReferenceById(1));
		borrowBook(et1, livreRepo.getReferenceById(3));
		
		
		
		System.out.println(et1.getLivres());
		
		
	}
	
	@Transactional
	private void borrowBook(Etudiant etudiant, Livre livre) {
		etudiant.getLivres().add(livre);
		livre.getEtudiants().add(etudiant);
		etudiantRepo.save(etudiant);
    }
}
