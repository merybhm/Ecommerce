/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author admin
 */
@Entity
public class Categorie implements Serializable{
   
   

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
     private String  nom;
   
    @ManyToOne
    @JoinColumn(name = "parent_categorie_id", nullable = true)

   private Categorie parentCategorie ;
@OneToMany(mappedBy = "parentCategorie", cascade = CascadeType.REMOVE, fetch=FetchType.LAZY)
 private List<Categorie> sousCategories = new ArrayList<>();

 @OneToMany(mappedBy = "Categorie")
     private List<Produit> produits = new ArrayList<Produit>();
   
    public Categorie() {
    }

    public Categorie(String nom) {
        this.nom = nom;
    }

   
    
    

    

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
    
}
