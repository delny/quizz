/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz.dao;

import quizz.dao.jpa.JpaPlayerDAO;
import quizz.dao.jpa.PersistenceManager;

/**
 *
 * @author a.delgado
 */
public class DaoFactory {
    
    //constructeur privé
    private DaoFactory(){
        System.out.println("Je ne m'afficherais jamais !");
    }
    
    public static PlayerDAO getPlayerDAO(){
        return new JpaPlayerDAO(PersistenceManager.getEntityManagerFactory());
    }
    
}
