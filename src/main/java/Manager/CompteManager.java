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


    public static Compte loadCompteById(int compteid){

        try {
            EntityManager em = getEntityManager();
            TypedQuery<Compte> query = em.createQuery("SELECT c from Compte c where c.id ='" + compteid + "'", Compte.class);
            Compte compte = query.getSingleResult();
            return compte;
        } catch (Exception var4) {
            return null;
        }

    }


    public static void createNewCompte(Compte compte) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(compte);
        em.getTransaction().commit();

        //TypedQuery<Compte> query = em.createQuery("INSERT INTO Compte VALUES compte");
    }

    public static void soldeUpdate(int compteId,int compteReceptionId, float montant) {

        Compte compte = CompteManager.loadCompteById(compteId);
        Compte compteReception = CompteManager.loadCompteById(compteReceptionId);
        System.out.println(compte);

        float solde = compte.getSolde();
        float soldeReception = compteReception.getSolde();

        float newSolde = solde - montant;
        float newSoldeReception = soldeReception + montant;
        System.out.println(newSolde);


        try {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            em.createQuery("UPDATE Compte SET solde= '"+ newSolde + "' WHERE id='" + compteId + "'").executeUpdate();
            em.createQuery("UPDATE Compte SET solde= '"+ newSoldeReception + "' WHERE id='" + compteReceptionId + "'").executeUpdate();
            em.getTransaction().commit();

        } catch (Exception var4){
            System.out.println("error update solde");
        }

    }
}
