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
@Table(name = "allergene")
public class Allergene {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_all;
	
	@Column(name = "nom", length = 300, nullable = false)
	private String nom;
	
	/**
	 * @param id_all
	 * @param nom
	 */
	public Allergene(int id_all, String nom) {
		super();
		this.id_all = id_all;
		this.nom = nom;
	}
	
	public Allergene(String nom) {
		this.nom = nom;
	}
	
	public Allergene() {
		
	}
	
//	@ManyToMany
//	@JoinTable(name="jointure_prod_all", 
//				joinColumns = @JoinColumn(name="id_all", referencedColumnName="id_all"),
//				inverseJoinColumns = @JoinColumn(name="id_prod", referencedColumnName = "id_prod"))
//	private Set<Produit>produitsAll;
	
	@ManyToMany(mappedBy="listeAllergnes", cascade=CascadeType.ALL)
	private List<Produit> all = new ArrayList<Produit>();

	/**
	 * @return the id_all
	 */
	public int getId_all() {
		return id_all;
	}

	/**
	 * @param id_all the id_all to set
	 */
	public void setId_all(int id_all) {
		this.id_all = id_all;
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
	 * @return the all
	 */
	public List<Produit> getAll() {
		return all;
	}

	/**
	 * @param all the all to set
	 */
	public void setAll(List<Produit> all) {
		this.all = all;
	}

	@Override
	public String toString() {
		return "Allergene [id_all=" + id_all + ", nom=" + nom + "]";
	}


}
