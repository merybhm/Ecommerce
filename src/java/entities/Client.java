/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author  
 * 
 */
@Entity


public class Client extends User  {
  
    private String nom;
      private String prenom;
        private int tel;
           private String adresse ;

 @OneToMany(targetEntity=Commande.class,mappedBy = "client", fetch = FetchType.EAGER)
         
    List<Commande>commandes;
    public Client() {
    }

    public Client(String nom, String prenom, int tel, String adresse, String email, String password) {
        super(email, password);
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.adresse = adresse;
    }

 

    

    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
        
}
