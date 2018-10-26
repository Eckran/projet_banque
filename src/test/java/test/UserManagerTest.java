package test;

import Manager.UserManager;
import model.Compte;
import model.Transaction;
import model.User;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

class UserManagerTest {

    /*@BeforeAll
    public void dropTable(){
        UserManager.purgeTable();
        Logger.info("nettoyage des tables");
    }*/

    @Test
    public void createNewUser(){
        User user = new User();
        user.setPrenom("Romain");
        user.setNom("Gary");
        user.setLogin("test");
        user.setPassword("azerty");
        user.setAdresse("15 rue pinsson");
        user.setPhone("0600000000");
        user.setMail("test@test.fr");
        user.setbDate(new Date());

        // ADD COMPTE

        Set<Compte> comptes= new LinkedHashSet<Compte>();

        Compte firstCompte = new Compte();
        firstCompte.setSolde(1500);
        firstCompte.setDate_creation(new Date());
        firstCompte.setRomain(user);

        Compte secondCompte = new Compte();
        secondCompte.setSolde(4000);
        secondCompte.setDate_creation(new Date());
        secondCompte.setRomain(user);

        comptes.add(firstCompte);
        comptes.add(secondCompte);

        user.setComptes(comptes);

        // ADD TRANSACTION

        Set<Transaction> transactions = new LinkedHashSet<Transaction>();

        Transaction firstTrans = new Transaction();
        firstTrans.setLibelle("la premiere");
        firstTrans.setMontant(200);
        firstTrans.setDateTransaction(new Date());
        firstTrans.setUserCompte(firstCompte);

        Transaction secondTrans = new Transaction();
        secondTrans.setLibelle("la premiere");
        secondTrans.setMontant(200);
        secondTrans.setDateTransaction(new Date());
        secondTrans.setUserCompte(firstCompte);

        transactions.add(firstTrans);
        transactions.add(secondTrans);

        firstCompte.setTransactions(transactions);



        UserManager.saveClient(user);
    }

    @Test
    public void loadUserByLogin(){

        User user = new User();
        user = UserManager.loadUserByLoginAndPassword("test", "azerty");
        System.out.println(user);

    }
}