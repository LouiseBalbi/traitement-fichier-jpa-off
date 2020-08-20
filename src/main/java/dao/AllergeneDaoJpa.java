package dao;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entites.Allergene;


public class AllergeneDaoJpa implements AllergneDao {

	private EntityManagerFactory factory = null;
	
	@Override
	public void insert(Allergene allergene) {
		
		factory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = factory.createEntityManager();
		
		if(em != null) {
				//J'ouvre une transaction
		em.getTransaction().begin();
		//j'ajoute dans la BDD mon nouveau Livre
		em.persist(allergene);
		//Je commite et ferme la transaction
		em.getTransaction().commit();
		}	
		em.close();
		factory.close();
		
	}
	
	
	public Allergene getAllergeneIdByName(String nom) {
		
		Allergene a = new Allergene();
		try {
			factory = Persistence.createEntityManagerFactory("pu_essai");
			EntityManager em = factory.createEntityManager();
			
			
			if(em != null ) {
				String query = "SELECT a FROM Allergene a where a.nom = :nom";
				TypedQuery<Allergene> q = em.createQuery(query, Allergene.class).setParameter("nom", nom);
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
	public boolean delete(Allergene allergene) {
		// TODO Auto-generated method stub
		return false;
	}


	

}
