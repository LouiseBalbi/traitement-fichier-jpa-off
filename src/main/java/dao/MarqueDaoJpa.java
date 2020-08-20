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

import entites.Ingredient;
import entites.Marque;

public class MarqueDaoJpa implements MarqueDao {

	private EntityManagerFactory factory = null;

	@Override
	public void insert(Marque marque) {

		factory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = factory.createEntityManager();

		if (em != null) {
			// J'ouvre une transaction
			em.getTransaction().begin();
			// j'ajoute dans la BDD 
			em.persist(marque);
			// Je commite et ferme la transaction
			em.getTransaction().commit();
		}
		em.close();
		factory.close();

	}
	
	
	public Marque getMarqueIdByName(String nom) {
		
		Marque m = new Marque();
			try {
				factory = Persistence.createEntityManagerFactory("pu_essai");
				EntityManager em = factory.createEntityManager();
				
				
				if(em != null) {
					String query = "SELECT m FROM Marque m where m.nom = :nom";
					TypedQuery<Marque> q = em.createQuery(query, Marque.class).setParameter("nom", nom);
					m = q.getResultList().get(0);
					
					em.close();
					factory.close();
				} 
				
			} catch(Exception e) {
				System.err.println("erreur d'éxecution : " + e.getMessage());
			}
			return m;
		}

	@Override
	public int update(String ancienNom, String nouveauNom) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Marque marque) {
		// TODO Auto-generated method stub
		return false;
	}

}
