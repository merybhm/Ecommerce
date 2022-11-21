/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import entities.Client;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author Lachgar
 */
@Entity
public class Commande implements Serializable{
       
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
     @Temporal(TemporalType.DATE)
    private Date date;
   @ManyToOne
 
   private Facture facture;
   @ManyToOne

   private Client client;
    @ManyToOne
   private LigneCommande ligneCommande ;



    public Commande() {
    }

    public Commande(Date date) {
        this.date = date;
       
    }

    

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

  
    
    
    
}
