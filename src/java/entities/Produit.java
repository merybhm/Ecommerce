/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 *
 * @author Lachgar
 */
@Entity
public class Produit implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom  ;
    @ManyToOne
    private Categorie Categorie;
    @ManyToOne
    private Marque marque;
    // private List <Image> images = new ArrayList<>(0);
    private String photo;

    public Produit() {
    }

    public Produit(String nom, Categorie Categorie, Marque marque, String photo) {
        this.nom = nom;
        this.Categorie = Categorie;
        this.marque = marque;
        this.photo = photo;
    }

   

   
    

    /* public Produit(String nom, Categorie Categorie, Marque marque,List<Image>images) {
        this.nom = nom;
        this.Categorie = Categorie;
        this.marque = marque;
        this.images =images;
    }
 */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

  /* public List<Image> getImages() {
        return images;
    }

    /* public void setImages(List<Image> images) {
        this.images = images;
    }
     */

    public Categorie getCategorie() {
        return Categorie;
    }

    public void setCategorie(Categorie Categorie) {
        this.Categorie = Categorie;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    
}
