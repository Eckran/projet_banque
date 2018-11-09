package test;

import Manager.CompteManager;
import model.Compte;
import model.User;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompteManagerTest {

    @Test
    public void newCompte() {

        User user = new User();
        user.setPrenom("Romain");
        user.setNom("Gary");
        user.setLogin("test");
        user.setPassword("azerty");
        user.setAdresse("15 rue pinsson");
        user.setPhone("0600000000");
        user.setMail("test@test.fr");
        user.setbDate(new Date());

        Compte newCompte = new Compte();
        newCompte.setSolde(0);
        newCompte.setDate_creation(new Date());
        newCompte.setRomain(user);

        CompteManager.createNewCompte(newCompte);
    }

    @Test
    public void transactionAjout() {


        CompteManager.soldeUpdate( 3, 200);

    }

    @Test
    public void transactionDebit() {

        CompteManager.soldeUpdate(3, -200);
    }

}