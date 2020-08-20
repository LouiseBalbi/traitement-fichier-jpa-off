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

import entites.Additif;
import entites.Allergene;
import entites.Categorie;
import entites.Ingredient;
import entites.Marque;
import entites.Produit;
import lectureFichier.StringUtils;

public class ProduitDaoJpa implements ProduitDao {

	private EntityManagerFactory factory = null;

	public Produit getProduitIdByName(String nom) {

		Produit p = new Produit();
		try {
			factory = Persistence.createEntityManagerFactory("pu_essai");
			EntityManager em = factory.createEntityManager();

			if (em != null) {
				String query = "SELECT p FROM Produit p where p.nom = :nom";
				TypedQuery<Produit> q = em.createQuery(query, Produit.class).setParameter("nom", nom);
				p = q.getResultList().get(0);

				em.close();
				factory.close();
			}

		} catch (Exception e) {
			System.err.println("erreur d'éxecution : " + e.getMessage());
		}
		return p;
	}

	@Override
	public void insert(Produit produit) {

//		try {

			factory = Persistence.createEntityManagerFactory("pu_essai");
			EntityManager em = factory.createEntityManager();

			Categorie categorie = produit.getCategorie();
			if (categorie != null) {
				CategorieDaoJpa cat = new CategorieDaoJpa();
				categorie = cat.getCategorieIdByName(categorie.getNom());
				int id_cat = categorie.getId_cat();
				
				if (id_cat == 0) {
					cat.insert(categorie);
					categorie = cat.getCategorieIdByName(categorie.getNom());
				}
				produit.setCategorie(categorie);
			}

		

			Marque marque = produit.getMarque();
			
			if (marque != null) {
				MarqueDaoJpa mar = new MarqueDaoJpa();
				marque = mar.getMarqueIdByName(marque.getNom());
				int id_marque = marque.getId_marque();
				
				if (id_marque == 0) {
					mar.insert(marque);
					marque = mar.getMarqueIdByName(marque.getNom());
				}
				produit.setMarque(marque);
			}

			



			int id_prod = this.getProduitIdByName(produit.getNom()).getId_prod();

			if (id_prod == 0) {



				IngredientDaoJpa ing = new IngredientDaoJpa();
				List<Ingredient> ingredients = produit.getListeIngredients();

				// parcours de la liste d'ingrédient et ajout des ingrédients aux tables
				// ingrédients + jointure
				
				if (ingredients != null) {
					for (Ingredient ingredient : ingredients) {
						int id_ing = ing.getIngredientIdByName(ingredient.getNom()).getId_ing();
						if (id_ing == 0) {
							ing.insert(ingredient);
							ingredient = ing.getIngredientIdByName(ingredient.getNom());
						}						
					}
					produit.setListeIngredients(ingredients);					
				}
				

				AllergeneDaoJpa all = new AllergeneDaoJpa();
				List<Allergene> allergenes = produit.getListeAllergnes();

				// parcours de la liste d'allergene et ajout des allergene aux tables allergene
				// + jointure
				if (allergenes != null) {
					for (Allergene allergene : allergenes) {
						int id_all = all.getAllergeneIdByName(allergene.getNom()).getId_all();
						if (id_all == 0) {
							all.insert(allergene);
							allergene = all.getAllergeneIdByName(allergene.getNom());			
						}
					}
					produit.setListeAllergnes(allergenes);
				}
				

				AdditifDaoJpa add = new AdditifDaoJpa();
				List<Additif> additifs = produit.getListeAdditifs();

				// parcours de la liste d'additifs et ajout des additifs aux tables additifs +
				// jointure
				if (additifs != null) {
					for (Additif additif : additifs) {
						int id_add = add.getAdditifIdByName(additif.getNom()).getId_add();
						if (id_add == 0) {
							add.insert(additif);
							additif = add.getAdditifIdByName(additif.getNom());
						}
					}
					produit.setListeAdditifs(additifs);
				}
				
				if (em != null) {
					System.out.println(produit.toString());
					// J'ouvre une transaction
					em.getTransaction().begin();
					// j'ajoute dans la BDD mon nouveau Produit
					em.persist(produit);
					// Je commite et ferme la transaction
					em.getTransaction().commit();
				}

				em.close();
				factory.close();
			}

//		} catch (Exception e) {
//			System.err.println("erreur d'éxecution, insert produit : " + e.getMessage());
//		}

	}


	@Override
	public int update(Produit ancienProduit, Produit nouveauProduit) {
		// TODO Auto-generated method stub
		return 0;
	}

}
