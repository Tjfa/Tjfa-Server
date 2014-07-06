/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import DAO.MatchDAO;
import DAO.PlayerDAO;
import java.util.List;
import javax.annotation.Resource;
import model.Match;

import org.springframework.stereotype.Component;

/**
 *
 * @author CZM
 */
@Component("matchService")
public class MatchService {
    private MatchDAO dao;

    public MatchDAO getDao() {
        return dao;
    }
@Resource(name="matchDAO")
    public void setDao(MatchDAO dao) {
        this.dao = dao;
    }
    public void delete(int id){
    dao.delete(id);
    }
    public void update(Match match){
    dao.update(match);
    }
    public void save(Match match){
    dao.save(match);
    }
    public Match getMatch(int id){
    return dao.getMatch(id);
    }
    public List<Match> getMatches(){
    return dao.getMatches();
    }
}
