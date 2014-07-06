/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.annotation.Resource;
import model.Player;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author CZM
 */
@Component("playerDAO")
public class PlayerDAO {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource(name = "hibernateTemplate")
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void delete(int id) {

        Player player = (Player) hibernateTemplate.load(Player.class, id);
        player = hibernateTemplate.merge(player);
        hibernateTemplate.delete(player);

    }
     public Player getPlayer(int id){
        
      
      return (Player)hibernateTemplate.get(Player.class, id);
          
 
    }
    public void save(Player player) {
         
    
        hibernateTemplate.save(player);
     
    }
public void update(Player c){
hibernateTemplate.merge(c);
hibernateTemplate.flush();
}
  public List<Player> getPlayers(){
  List<Player> players;
  players= hibernateTemplate.find("from Player");
      return players;
      
  }
}
