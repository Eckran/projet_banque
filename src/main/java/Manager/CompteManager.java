package Manager;


import model.Compte;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


public class CompteManager extends BaseManager {
    public CompteManager() {
    }

    public static List<Compte> loadCompteByUtilisateur(String login) {
        try {
            EntityManager em = getEntityManager();
            TypedQuery<Compte> query = em.createQuery("SELECT c from Compte c where c.romain ='" + login + "'", Compte.class);
            List<Compte> comptes = query.getResultList();
            return comptes;
        } catch (Exception var4) {
            return null;
        }
    }
}
