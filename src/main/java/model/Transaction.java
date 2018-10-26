package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float montant;
    private Date dateTransaction;
    private String libelle;
    //private Compte destinataire;
    //private Compte receveur;
    @ManyToOne
    @JoinColumn(name="idCompte")
    private Compte userCompte;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    /*public Compte getSource() {
        return source;
    }

    public void setSource(Compte source) {
        this.source = source;
    }

    public Compte getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Compte destinataire) {
        this.destinataire = destinataire;
    }*/

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Compte getUserCompte() {
        return userCompte;
    }

    public void setUserCompte(Compte userCompte) {
        this.userCompte = userCompte;
    }

}
