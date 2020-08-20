package entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produit")
public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_prod;
	
	@ManyToOne
	@JoinColumn(name="id_cat")
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name="id_marque")
	private Marque marque;
	
	@Column(name = "nom", length = 300, nullable = false)
	private String nom;
	
	@Column(name = "nutritionGrade", length = 300, nullable = true)
	private String nutritionGrade;
	
	@Column(name = "energie100g", nullable = false)
	private double energie100g;
	
	@Column(name = "graisse100g", nullable = true)
	private double graisse100g;
	
	@Column(name = "sucres100g", nullable = true)
	private double sucres100g;
	
	@Column(name = "fibres100g", nullable = true)
	private double fibres100g;
	
	@Column(name = "proteines100g", nullable = true)
	private double proteine100g;
	
	@Column(name = "sel100g", nullable = true)
	private double sel100g;
	
	@Column(name = "vitA_100g", nullable = true)
	private double vitA;
	
	@Column(name = "vitD_100g", nullable = true)
	private double vitD;
	
	@Column(name = "vitE_100g", nullable = true)
	private double vitE;
	
	@Column(name = "vitK_100g", nullable = true)
	private double vitK;
	
	@Column(name = "vitC_100g", nullable = true)
	private double vitC;
	
	@Column(name = "vitB1_100g", nullable = true)
	private double vitB1;
	
	@Column(name = "vitB2_100g", nullable = true)
	private double vitB2;
	
	@Column(name = "vitPP_100g", nullable = true)
	private double vitPP;
	
	@Column(name = "vitB6_100g", nullable = true)
	private double vitB6;
	
	@Column(name = "vitB9_100g", nullable = true)
	private double vitB9;
	
	@Column(name = "vitB121_100g", nullable = true)
	private double vitB121;
	
	@Column(name = "calcium100g", nullable = true)
	private double calcium;
	
	@Column(name = "magnesium100g", nullable = true)
	private double magnesium;
	
	@Column(name = "iron100g", nullable = true)
	private double iron;
	
	@Column(name = "fer100g", nullable = true)
	private double fer;
	
	@Column(name = "betacarotene100g", nullable = true)
	private double betacarotene;
	
	@Column(name = "huileDePalme", nullable = true)
	private boolean huileDePalme;
	
	@ManyToMany(mappedBy="produitsAll")
	private List<Allergene> listeAllergnes = new ArrayList<Allergene>();
	
	@ManyToMany(mappedBy="produitsAdd")
	private List<Additif> listeAdditifs = new ArrayList<Additif>();
	
	@ManyToMany(mappedBy="produitsIng")
	private List<Ingredient> listeIngredients = new ArrayList<Ingredient>();
	/**
	 * @param id_prod
	 * @param categorie
	 * @param marque
	 * @param nom
	 * @param nutritionGrade
	 * @param energie100g
	 * @param graisse100g
	 * @param sucres100g
	 * @param fibres100g
	 * @param proteine100g
	 * @param sel100g
	 * @param vitA
	 * @param vitD
	 * @param vitE
	 * @param vitK
	 * @param vitC
	 * @param vitB1
	 * @param vitB2
	 * @param vitPP
	 * @param vitB6
	 * @param vitB9
	 * @param vitB121
	 * @param calcium
	 * @param magnesium
	 * @param iron
	 * @param fer
	 * @param betacarotene
	 * @param huileDePalme
	 * @param listeAllergnes
	 * @param listeAdditifs
	 * @param listeIngredients
	 * 	
	 */
	
	public Produit(String nom) {
		this.nom = nom;
	}
	
	public Produit(int id_prod, Categorie categorie, Marque marque, String nom, String nutritionGrade,
			double energie100g, double graisse100g, double sucres100g, double fibres100g, double proteine100g,
			double sel100g, double vitA, double vitD, double vitE, double vitK, double vitC, double vitB1, double vitB2,
			double vitPP, double vitB6, double vitB9, double vitB121, double calcium, double magnesium, double iron,
			double fer, double betacarotene, boolean huileDePalme, List<Allergene> listeAllergnes,
			List<Additif> listeAdditifs, List<Ingredient> listeIngredients) {
		super();
		this.id_prod = id_prod;
		this.categorie = categorie;
		this.marque = marque;
		this.nom = nom;
		this.nutritionGrade = nutritionGrade;
		this.energie100g = energie100g;
		this.graisse100g = graisse100g;
		this.sucres100g = sucres100g;
		this.fibres100g = fibres100g;
		this.proteine100g = proteine100g;
		this.sel100g = sel100g;
		this.vitA = vitA;
		this.vitD = vitD;
		this.vitE = vitE;
		this.vitK = vitK;
		this.vitC = vitC;
		this.vitB1 = vitB1;
		this.vitB2 = vitB2;
		this.vitPP = vitPP;
		this.vitB6 = vitB6;
		this.vitB9 = vitB9;
		this.vitB121 = vitB121;
		this.calcium = calcium;
		this.magnesium = magnesium;
		this.iron = iron;
		this.fer = fer;
		this.betacarotene = betacarotene;
		this.huileDePalme = huileDePalme;
		this.listeAllergnes = listeAllergnes;
		this.listeAdditifs = listeAdditifs;
		this.listeIngredients = listeIngredients;
	}
	
	
	public Produit() {
		
	}
	
	/**
	 * @return the id_prod
	 */
	public int getId_prod() {
		return id_prod;
	}
	/**
	 * @param id_prod the id_prod to set
	 */
	public void setId_prod(int id_prod) {
		this.id_prod = id_prod;
	}
	/**
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}
	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	/**
	 * @return the marque
	 */
	public Marque getMarque() {
		return marque;
	}
	/**
	 * @param marque the marque to set
	 */
	public void setMarque(Marque marque) {
		this.marque = marque;
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
	 * @return the nutritionGrade
	 */
	public String getNutritionGrade() {
		return nutritionGrade;
	}
	/**
	 * @param nutritionGrade the nutritionGrade to set
	 */
	public void setNutritionGrade(String nutritionGrade) {
		this.nutritionGrade = nutritionGrade;
	}
	/**
	 * @return the energie100g
	 */
	public double getEnergie100g() {
		return energie100g;
	}
	/**
	 * @param energie100g the energie100g to set
	 */
	public void setEnergie100g(double energie100g) {
		this.energie100g = energie100g;
	}
	/**
	 * @return the graisse100g
	 */
	public double getGraisse100g() {
		return graisse100g;
	}
	/**
	 * @param graisse100g the graisse100g to set
	 */
	public void setGraisse100g(double graisse100g) {
		this.graisse100g = graisse100g;
	}
	/**
	 * @return the sucres100g
	 */
	public double getSucres100g() {
		return sucres100g;
	}
	/**
	 * @param sucres100g the sucres100g to set
	 */
	public void setSucres100g(double sucres100g) {
		this.sucres100g = sucres100g;
	}
	/**
	 * @return the fibres100g
	 */
	public double getFibres100g() {
		return fibres100g;
	}
	/**
	 * @param fibres100g the fibres100g to set
	 */
	public void setFibres100g(double fibres100g) {
		this.fibres100g = fibres100g;
	}
	/**
	 * @return the proteine100g
	 */
	public double getProteine100g() {
		return proteine100g;
	}
	/**
	 * @param proteine100g the proteine100g to set
	 */
	public void setProteine100g(double proteine100g) {
		this.proteine100g = proteine100g;
	}
	/**
	 * @return the sel100g
	 */
	public double getSel100g() {
		return sel100g;
	}
	/**
	 * @param sel100g the sel100g to set
	 */
	public void setSel100g(double sel100g) {
		this.sel100g = sel100g;
	}
	/**
	 * @return the vitA
	 */
	public double getVitA() {
		return vitA;
	}
	/**
	 * @param vitA the vitA to set
	 */
	public void setVitA(double vitA) {
		this.vitA = vitA;
	}
	/**
	 * @return the vitD
	 */
	public double getVitD() {
		return vitD;
	}
	/**
	 * @param vitD the vitD to set
	 */
	public void setVitD(double vitD) {
		this.vitD = vitD;
	}
	/**
	 * @return the vitE
	 */
	public double getVitE() {
		return vitE;
	}
	/**
	 * @param vitE the vitE to set
	 */
	public void setVitE(double vitE) {
		this.vitE = vitE;
	}
	/**
	 * @return the vitK
	 */
	public double getVitK() {
		return vitK;
	}
	/**
	 * @param vitK the vitK to set
	 */
	public void setVitK(double vitK) {
		this.vitK = vitK;
	}
	/**
	 * @return the vitC
	 */
	public double getVitC() {
		return vitC;
	}
	/**
	 * @param vitC the vitC to set
	 */
	public void setVitC(double vitC) {
		this.vitC = vitC;
	}
	/**
	 * @return the vitB1
	 */
	public double getVitB1() {
		return vitB1;
	}
	/**
	 * @param vitB1 the vitB1 to set
	 */
	public void setVitB1(double vitB1) {
		this.vitB1 = vitB1;
	}
	/**
	 * @return the vitB2
	 */
	public double getVitB2() {
		return vitB2;
	}
	/**
	 * @param vitB2 the vitB2 to set
	 */
	public void setVitB2(double vitB2) {
		this.vitB2 = vitB2;
	}
	/**
	 * @return the vitPP
	 */
	public double getVitPP() {
		return vitPP;
	}
	/**
	 * @param vitPP the vitPP to set
	 */
	public void setVitPP(double vitPP) {
		this.vitPP = vitPP;
	}
	/**
	 * @return the vitB6
	 */
	public double getVitB6() {
		return vitB6;
	}
	/**
	 * @param vitB6 the vitB6 to set
	 */
	public void setVitB6(double vitB6) {
		this.vitB6 = vitB6;
	}
	/**
	 * @return the vitB9
	 */
	public double getVitB9() {
		return vitB9;
	}
	/**
	 * @param vitB9 the vitB9 to set
	 */
	public void setVitB9(double vitB9) {
		this.vitB9 = vitB9;
	}
	/**
	 * @return the vitB121
	 */
	public double getVitB121() {
		return vitB121;
	}
	/**
	 * @param vitB121 the vitB121 to set
	 */
	public void setVitB121(double vitB121) {
		this.vitB121 = vitB121;
	}
	/**
	 * @return the calcium
	 */
	public double getCalcium() {
		return calcium;
	}
	/**
	 * @param calcium the calcium to set
	 */
	public void setCalcium(double calcium) {
		this.calcium = calcium;
	}
	/**
	 * @return the magnesium
	 */
	public double getMagnesium() {
		return magnesium;
	}
	/**
	 * @param magnesium the magnesium to set
	 */
	public void setMagnesium(double magnesium) {
		this.magnesium = magnesium;
	}
	/**
	 * @return the iron
	 */
	public double getIron() {
		return iron;
	}
	/**
	 * @param iron the iron to set
	 */
	public void setIron(double iron) {
		this.iron = iron;
	}
	/**
	 * @return the fer
	 */
	public double getFer() {
		return fer;
	}
	/**
	 * @param fer the fer to set
	 */
	public void setFer(double fer) {
		this.fer = fer;
	}
	/**
	 * @return the betacarotene
	 */
	public double getBetacarotene() {
		return betacarotene;
	}
	/**
	 * @param betacarotene the betacarotene to set
	 */
	public void setBetacarotene(double betacarotene) {
		this.betacarotene = betacarotene;
	}
	/**
	 * @return the huileDePalme
	 */
	public boolean isHuileDePalme() {
		return huileDePalme;
	}
	/**
	 * @param huileDePalme the huileDePalme to set
	 */
	public void setHuileDePalme(boolean huileDePalme) {
		this.huileDePalme = huileDePalme;
	}
	/**
	 * @return the listeAllergnes
	 */
	public List<Allergene> getListeAllergnes() {
		return listeAllergnes;
	}
	/**
	 * @param listeAllergnes the listeAllergnes to set
	 */
	public void setListeAllergnes(List<Allergene> listeAllergnes) {
		this.listeAllergnes = listeAllergnes;
	}
	/**
	 * @return the listeAdditifs
	 */
	public List<Additif> getListeAdditifs() {
		return listeAdditifs;
	}
	/**
	 * @param listeAdditifs the listeAdditifs to set
	 */
	public void setListeAdditifs(List<Additif> listeAdditifs) {
		this.listeAdditifs = listeAdditifs;
	}
	/**
	 * @return the listeIngredients
	 */
	public List<Ingredient> getListeIngredients() {
		return listeIngredients;
	}
	/**
	 * @param listeIngredients the listeIngredients to set
	 */
	public void setListeIngredients(List<Ingredient> listeIngredients) {
		this.listeIngredients = listeIngredients;
	}

	@Override
	public String toString() {
		return "Produit [id_prod=" + id_prod + ", categorie=" + categorie + ", marque=" + marque + ", nom=" + nom
				+ ", nutritionGrade=" + nutritionGrade + "]";
	}

	

	
}
