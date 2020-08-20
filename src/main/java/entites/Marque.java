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
@Table(name = "marque")
public class Marque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_marque;
	
	@Column(name = "nom", length = 300, nullable = false)
	private String nom;
	
	/**
	 * @param id_marque
	 * @param nom
	 */
	public Marque(int id_marque, String nom) {
		super();
		this.id_marque = id_marque;
		this.nom = nom;
	}
	
	public Marque(String nom) {
		this.nom = nom;
	}
	
	public Marque() {
		
	}
	
	@OneToMany(mappedBy="marque")
	private Set<Produit>produits;
	
	/**
	 * @return the id_marque
	 */
	public int getId_marque() {
		return id_marque;
	}
	/**
	 * @param id_marque the id_marque to set
	 */
	public void setId_marque(int id_marque) {
		this.id_marque = id_marque;
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
		return "Marque [id_marque=" + id_marque + ", nom=" + nom + "]";
	}

	

}
