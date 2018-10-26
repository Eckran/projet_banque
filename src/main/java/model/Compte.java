package model;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="compte")
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float solde;
    //private TypeCompte typeComptes;
    private Date date_creation;
    @OneToMany(mappedBy = "userCompte", cascade=CascadeType.ALL)
    private Set<Transaction> transactions = new LinkedHashSet<Transaction>();
    @ManyToOne
    @JoinColumn(name="clicli")
    private User romain;


    public Compte() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    /*public TypeCompte getTypeComptes() {
        return typeComptes;
    }

    public void setTypeComptes(TypeCompte typeComptes) {
        this.typeComptes = typeComptes;
    }*/

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public User getRomain() {
        return romain;
    }

    public void setRomain(User romain) {
        this.romain = romain;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }
}