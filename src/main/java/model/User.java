package model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="user")
public class User {

    //Logger logger = LogManager.getLogger(LoginServlet.class);
    //logger.error("Client not found!" + user + password)

    @Id
    private String login;
    private String password;
    private String nom;
    private String prenom;
    private String mail;
    private String phone;
    private Date bDate;
    private String adresse;
    @OneToMany(mappedBy = "romain", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Compte> comptes = new LinkedHashSet<Compte>();

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", bDate=" + bDate +
                ", adresse='" + adresse + '\'' +
                ", comptes=" + comptes +
                '}';
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }

    public User() {
    }
}
