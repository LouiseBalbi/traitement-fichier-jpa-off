package dao;

import java.util.List;
import entites.Categorie;


public interface CategorieDao {
	
	void insert(Categorie categorie);
	int update(String ancienNom, String nouveauNom);
	boolean delete(Categorie categorie);

}
