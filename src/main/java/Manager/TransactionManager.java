package Manager;

import model.Compte;
import model.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

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

    public static List<Transaction> loadTransactionByCompteId(int idCompte){
        try {
            EntityManager em = getEntityManager();
            TypedQuery<Transaction> query = em.createQuery(
                    "SELECT c FROM Transaction c WHERE c.userCompte='" + idCompte + "'", Transaction.class);
            List<Transaction> trans = query.getResultList();

            for(Transaction iter:trans){
                System.out.println(iter.toString());
            }

            return trans;

        } catch (Exception var4) {
            return null;
        }
    }

}
