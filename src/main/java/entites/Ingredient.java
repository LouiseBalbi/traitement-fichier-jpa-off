package entites;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ingredient")
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_ing;
	
	@Column(name = "nom", length = 300, nullable = false)
	private String nom;
	
	/**
	 * @param id_ing
	 * @param nom
	 */
	
	public Ingredient(String nom) {
		this.nom = nom;
	}
	
	public Ingredient(int id_ing, String nom) {
		super();
		this.id_ing = id_ing;
		this.nom = nom;
	}
	
	public Ingredient() {
	
	}
	
	
//	@ManyToMany
//	@JoinTable(name="jointure_prod_ing", 
//				joinColumns = @JoinColumn(name="id_ing", referencedColumnName="id_ing"),
//				inverseJoinColumns = @JoinColumn(name="id_prod", referencedColumnName = "id_prod"))
//	private Set<Produit>produitsIng;
	
	@ManyToMany(mappedBy="listeIngredients", cascade=CascadeType.ALL)
	private List<Produit> ing = new ArrayList<Produit>();

	
	/**
	 * @return the id_ing
	 */
	public int getId_ing() {
		return id_ing;
	}
	/**
	 * @param id_ing the id_ing to set
	 */
	public void setId_ing(int id_ing) {
		this.id_ing = id_ing;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}



	/**
	 * @return the ing
	 */
	public List<Produit> getIng() {
		return ing;
	}

	/**
	 * @param ing the ing to set
	 */
	public void setIng(List<Produit> ing) {
		this.ing = ing;
	}

	@Override
	public String toString() {
		return "Ingredient [id_ing=" + id_ing + ", nom=" + nom + "]";
	}


}
