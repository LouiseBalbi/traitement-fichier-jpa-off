package dao;

import java.util.List;
import entites.Allergene;

public interface AllergneDao {
	
	void insert(Allergene allergene);
	int update(String ancienNom, String nouveauNom);
	boolean delete(Allergene allergene);


}
