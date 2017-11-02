/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import quizz.dao.PlayerDAO;
import quizz.entities.Player;

/**
 *
 * @author a.delgado
 */
public class JpaPlayerDAO implements PlayerDAO {
    
    private EntityManagerFactory emf;
    
    /**
     * Constructor
     * @param emf 
     */
    public JpaPlayerDAO(EntityManagerFactory emf){
        this.emf = emf;
    }

    @Override
    public void create(Player player) {
        EntityManager em = this.emf.createEntityManager();
        EntityTransaction t = em.getTransaction();

        try{
            t.begin();
            em.persist(player);
            em.flush();
            t.commit();
        }finally{
            if(t.isActive()){
                t.rollback();
            }
            em.close();
        }
    }

    @Override
    public boolean isExist(String email){
        EntityManager em = this.emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Player as p WHERE p.email = :email");
        query.setParameter("email", email);
        try {
            query.getSingleResult();
            return true;
        }catch(NoResultException e){
            return false;
        }
    }
    
    @Override
    public List<Player> findAll() {
        EntityManager em = this.emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Player as p ORDER BY p.nbGoodAnswers DESC");
        return query.getResultList();
    }

    @Override
    public List<Player> getWinners() {
        EntityManager em = this.emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Player as p WHERE p.nbGoodAnswers = :max");
        query.setParameter("max", 10);
        return query.getResultList();
    }

    @Override
    public List<Player> findAllbyPage(int page, int nbParpages) {
        //parametre de page
        int first = (page-1)*nbParpages;
        
        EntityManager em = this.emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Player as p ORDER BY p.nbGoodAnswers DESC");
        query.setFirstResult(first);
        query.setMaxResults(nbParpages);
        return query.getResultList();
    }
    
}
