package lectureFichier;

import java.util.ArrayList;
import java.util.List;

import dao.AdditifDaoJpa;
import dao.AllergeneDaoJpa;
import dao.CategorieDaoJpa;
import dao.IngredientDaoJpa;
import dao.MarqueDaoJpa;
import dao.ProduitDaoJpa;
import entites.Additif;
import entites.Allergene;
import entites.Categorie;
import entites.Ingredient;
import entites.Marque;
import entites.Produit;

public class Test {

	public static void main(String[] args) {
		
//		AllergeneDaoJpa adj = new AllergeneDaoJpa();
//		System.out.println(adj.getAllergeneIdByName("soja").toString());
//	 	
//  	    System.out.println(adj.getAllergeneIdByName("batman").toString());
		
//		CategorieDaoJpa cat = new CategorieDaoJpa();
//		System.out.println(cat.getCategorieIdByName("Additifs alimentaires").toString());
//		
//		
//		IngredientDaoJpa ing = new IngredientDaoJpa();
//		System.out.println(ing.getIngredientIdByName("Sucre").toString());
		
//		MarqueDaoJpa mar = new MarqueDaoJpa();
//		System.out.println(mar.getMarqueIdByName("La Droguerie Écologique").toString());
//		
		Categorie cat = new Categorie("Beignets");
		Marque mar = new Marque("Priméal");

		
		Allergene all1 = new Allergene();
		Allergene all2 = new Allergene();
		List<Allergene> all = new ArrayList<Allergene>();
		all.add(all1);
		all.add(all2);
		
		Additif add1 = new Additif();
		Additif add2 = new Additif();
		List<Additif> add = new ArrayList<Additif>();
		add.add(add1);
		add.add(add2);
		
		Ingredient ing1 = new Ingredient();
		Ingredient ing2 = new Ingredient();
		List<Ingredient> ing = new ArrayList<Ingredient>();
		ing.add(ing1);
		ing.add(ing2);
		
		Produit produit = new Produit(0, cat, mar,"toto", "A", 1.1, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false,
				null, add, null);
		
		
		ProduitDaoJpa pdt = new ProduitDaoJpa();
		pdt.insert(produit);
		
		//System.out.println(pdt.getProduitIdByName("Bicarbonate Soude Alimentaire").toString());

		
	}

}
