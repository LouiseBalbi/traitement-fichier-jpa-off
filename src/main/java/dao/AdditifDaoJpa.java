package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.QueryHint;
import javax.persistence.TypedQuery;

import entites.Additif;





public class AdditifDaoJpa implements AdditifDao {
	
	private EntityManagerFactory factory = null;
	

	@Override
	public void insert(Additif additif) {
		
		
		factory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = factory.createEntityManager();
		
		if(em != null) {
				//J'ouvre une transaction
		em.getTransaction().begin();
		//j'ajoute dans la BDD mon nouveau Livre
		em.persist(additif);
		//Je commite et ferme la transaction
		em.getTransaction().commit();
		}	
		em.close();
		factory.close();
		
	}
	
	public Additif getAdditifIdByName(String nom) {
		
		Additif a = new Additif();
		try {
			factory = Persistence.createEntityManagerFactory("pu_essai");
			EntityManager em = factory.createEntityManager();
			
			
			if(em != null ) {
				String query = "SELECT a FROM Additif a where a.nom = :nom";
				TypedQuery<Additif> q = em.createQuery(query, Additif.class).setParameter("nom", nom);
				a = q.getResultList().get(0);
				
				em.close();
				factory.close();
			} 
			
		} catch(Exception e) {
			System.err.println("erreur d'éxecution : " + e.getMessage());
		}
		return a;
	}


	

	@Override
	public int update(String ancienNom, String nouveauNom) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Additif additif) {
		// TODO Auto-generated method stub
		return false;
	}



}
