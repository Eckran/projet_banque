package Manager;

import model.Compte;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UserManager extends BaseManager{

    public static void saveClient(User user) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public static User loadUserById(Integer userId) {
        EntityManager em = getEntityManager();
        User use = em.find(User.class, userId);
        return use;
    }

    public static User loadUserByLoginAndPassword(String login, String password) {
        EntityManager em = getEntityManager();
        TypedQuery<User> query = em.createQuery(
                "SELECT c FROM User c WHERE c.login='" + login +
                        "' and c.password='" + password + "'", User.class);
        User use = query.getSingleResult();

        /*for(Compte iter:use.getComptes()){
            System.out.println(iter);
        }*/

        return use;
    }


    public static void purgeTable() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.createQuery("delete from Transaction").executeUpdate();
        em.createQuery("delete from Compte").executeUpdate();
        em.createQuery("delete from User").executeUpdate();
        em.getTransaction().commit();
    }

    public static void deleteUser(User use){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(use);
        em.getTransaction().commit();
    }
}
