package Manager;

import model.Compte;
import model.Transaction;

import javax.persistence.EntityManager;
import java.util.Date;

public class TransactionManager extends BaseManager {

    public static void addTransaction (float montant, Date addDate, String libelle, Compte receveur){

        Transaction trans = new Transaction();
        trans.setMontant(montant);
        trans.setDateTransaction(addDate);
        trans.setLibelle(libelle);
        trans.setUserCompte(receveur);

        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(trans);
        em.getTransaction().commit();

    }

}
