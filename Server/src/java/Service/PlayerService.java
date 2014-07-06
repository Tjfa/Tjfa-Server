/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import DAO.PlayerDAO;
import java.util.List;
import javax.annotation.Resource;
import model.Player;
import org.springframework.stereotype.Component;

/**
 *
 * @author CZM
 */
@Component("playerService")
public class PlayerService {
    private PlayerDAO dao;

    public PlayerDAO getDao() {
        return dao;
    }
@Resource(name="playerDAO")
    public void setDao(PlayerDAO dao) {
        this.dao = dao;
    }
    public void delete(int id){
    dao.delete(id);
    }
    public void update(Player player){
    dao.update(player);
    }
    public void save(Player player){
    dao.save(player);
    }
    public Player getPlayer(int id){
    return dao.getPlayer(id);
    }
    public List<Player> getPlayers(){
    return dao.getPlayers();
    }
}
