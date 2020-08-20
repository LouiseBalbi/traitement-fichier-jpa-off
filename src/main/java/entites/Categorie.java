package entites;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorie")
public class Categorie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cat;
	
	@Column(name = "nom", length = 300, nullable = false)
	private String nom;
	
	/**
	 * @param id_cat
	 * @param nom
	 */
	public Categorie(int id_cat, String nom) {
		super();
		this.id_cat = id_cat;
		this.nom = nom;
	}
	
	public Categorie(String nom) {
		this.nom = nom;
	}
	
	public Categorie() {
		
	}

	
	@OneToMany(mappedBy="categorie")
	private Set<Produit>produits;
	
	/**
	 * @return the id_cat
	 */
	public int getId_cat() {
		return id_cat;
	}

	/**
	 * @param id_cat the id_cat to set
	 */
	public void setId_cat(int id_cat) {
		this.id_cat = id_cat;
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
	 * @return the produits
	 */
	public Set<Produit> getProduits() {
		return produits;
	}

	/**
	 * @param produits the produits to set
	 */
	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}

	@Override
	public String toString() {
		return "Categorie [id_cat=" + id_cat + ", nom=" + nom + "]";
	}


}
