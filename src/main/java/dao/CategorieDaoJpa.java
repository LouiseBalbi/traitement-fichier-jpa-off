package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entites.Allergene;
import entites.Categorie;


public class CategorieDaoJpa implements CategorieDao {

	private EntityManagerFactory factory = null;
	
	@Override
	public void insert(Categorie categorie) {
		
		factory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = factory.createEntityManager();
		
		if(em != null) {
				//J'ouvre une transaction
		em.getTransaction().begin();
		//j'ajoute dans la BDD mon nouveau Livre
		em.persist(categorie);
		//Je commite et ferme la transaction
		em.getTransaction().commit();
		}	
		em.close();
		factory.close();
		
	}

	
	
	public Categorie getCategorieIdByName(String nom) {
		
		Categorie c = new Categorie();
		try {
			factory = Persistence.createEntityManagerFactory("pu_essai");
			EntityManager em = factory.createEntityManager();
			
			
			if(em != null ) {
				String query = "SELECT c FROM Categorie c where c.nom = :nom";
				TypedQuery<Categorie> q = em.createQuery(query, Categorie.class).setParameter("nom", nom);
				c = q.getResultList().get(0);
				
				em.close();
				factory.close();
			} 
			
		} catch(Exception e) {
			System.err.println("erreur d'éxecution : " + e.getMessage());
		}
		return c;
	}
	
	
	@Override
	public int update(String ancienNom, String nouveauNom) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Categorie categorie) {
		// TODO Auto-generated method stub
		return false;
	}




}
