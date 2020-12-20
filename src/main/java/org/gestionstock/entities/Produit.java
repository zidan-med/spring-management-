package org.gestionstock.entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	@Column(name="NOM", length=30)
	private String nom;
	private double prix;
	private String photo;
	public Produit() {
		super();
		}

	public Produit(long id, String nom, double prix, String photo) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.photo = photo;
	}

	public Produit(String nom, double prix, String photo) {
		this.nom = nom;
		this.prix = prix;
		this.photo = photo;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "Produit [nom=" + nom + ", prix=" + prix + ", photo=" + photo + "]";
	}
	
	
}