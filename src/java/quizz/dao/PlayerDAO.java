/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz.dao;

import java.util.List;
import quizz.entities.Player;

/**
 *
 * @author a.delgado
 */
public interface PlayerDAO {
    
    public void create(Player player);
    public boolean isExist(String email);
    public List<Player> findAll();
    public List<Player> findAllbyPage(int page,int nbParpages);
    public List<Player> getWinners();
    
}
