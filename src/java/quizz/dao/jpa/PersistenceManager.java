/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz.dao.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author a.delgado
 */
public class PersistenceManager {
    private static EntityManagerFactory emf;
    
    //constructeur en privé pour ne pas etre instancié
    private PersistenceManager(){}
    
    public static EntityManagerFactory getEntityManagerFactory(){
        if (emf==null){
            emf = Persistence.createEntityManagerFactory("quizzPU");
        }
        
        return emf;
    }
    
}
