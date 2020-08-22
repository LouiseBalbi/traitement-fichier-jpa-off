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
@Table(name = "additif")
public class Additif {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_add;

	@Column(name = "nom", length = 300, nullable = false)
	private String nom;

	/**
	 * @param id_add
	 * @param nom
	 */
	public Additif(int id_add, String nom) {
		super();
		this.id_add = id_add;
		this.nom = nom;
	}

	public Additif(String nom) {
		this.nom = nom;
	}

	/** constructeur sans argument */
	public Additif() {

	}
	
	
//	@ManyToMany
//	@JoinTable(name="jointure_prod_add", 
//				joinColumns = @JoinColumn(name="id_add", referencedColumnName="id_add"),
//				inverseJoinColumns = @JoinColumn(name="id_prod", referencedColumnName = "id_prod"))
//	private Set<Produit>produitsAdd;
	
	@ManyToMany(mappedBy="listeAdditifs", cascade=CascadeType.ALL)
	private List<Produit> add = new ArrayList<Produit>();

	/**
	 * @return the id_add
	 */
	public int getId_add() {
		return id_add;
	}

	/**
	 * @param id_add the id_add to set
	 */
	public void setId_add(int id_add) {
		this.id_add = id_add;
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
	 * @return the add
	 */
	public List<Produit> getAdd() {
		return add;
	}

	/**
	 * @param add the add to set
	 */
	public void setAdd(List<Produit> add) {
		this.add = add;
	}

	@Override
	public String toString() {
		return "Additif [id_add=" + id_add + ", nom=" + nom + "]";
	}
}
