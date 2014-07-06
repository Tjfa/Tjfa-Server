/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import DAO.PlayerDAO;
import DAO.TeamDAO;
import java.util.List;
import javax.annotation.Resource;
import model.Team;

import org.springframework.stereotype.Component;

/**
 *
 * @author CZM
 */
@Component("teamService")
public class TeamService {
    private TeamDAO dao;

    public TeamDAO getDao() {
        return dao;
    }
@Resource(name="teamDAO")
    public void setDao(TeamDAO dao) {
        this.dao = dao;
    }
    public void delete(int id){
    dao.delete(id);
    }
    public void update(Team team){
    dao.update(team);
    }
    public void save(Team team){
    dao.save(team);
    }
    public Team getTeam(int id){
    return dao.getTeam(id);
    }
    public List<Team> getTeams(){
    return dao.getTeams();
    }
}
