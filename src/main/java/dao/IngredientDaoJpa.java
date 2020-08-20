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

import entites.Categorie;
import entites.Ingredient;
import entites.Marque;

public class IngredientDaoJpa implements IngredientDao {

	private EntityManagerFactory factory = null;

	@Override
	public void insert(Ingredient ingredient) {

		factory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = factory.createEntityManager();

		if (em != null) {
			// J'ouvre une transaction
			em.getTransaction().begin();
			// j'ajoute dans la BDD mon nouveau Livre
			em.persist(ingredient);
			// Je commite et ferme la transaction
			em.getTransaction().commit();
		}
		em.close();
		factory.close();

	}
	
public Ingredient getIngredientIdByName(String nom) {
		
	Ingredient i = new Ingredient();
		try {
			factory = Persistence.createEntityManagerFactory("pu_essai");
			EntityManager em = factory.createEntityManager();
			
			
			if(em != null ) {
				String query = "SELECT i FROM Ingredient i where i.nom = :nom";
				TypedQuery<Ingredient> q = em.createQuery(query, Ingredient.class).setParameter("nom", nom);
				i = q.getResultList().get(0);
				
				em.close();
				factory.close();
			} 
			
		} catch(Exception e) {
			System.err.println("erreur d'éxecution : " + e.getMessage());
		}
		return i;
	}

	@Override
	public int update(String ancienNom, String nouveauNom) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Ingredient ingredient) {
		// TODO Auto-generated method stub
		return false;
	}

}
