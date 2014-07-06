/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import DAO.CompetitionDAO;

import java.util.List;
import javax.annotation.Resource;
import model.Competition;

import org.springframework.stereotype.Component;

/**
 *
 * @author CZM
 */
@Component("competitionService")
public class CompetitionService {
    private CompetitionDAO dao;

    public CompetitionDAO getDao() {
        return dao;
    }

    
@Resource(name="competitionDAO")
    public void setDao(CompetitionDAO dao) {
        this.dao = dao;
    }
    public void delete(int id){
    dao.delete(id);
    }
    public void update(Competition competition){
    dao.update(competition);
    }
    public void save(Competition competition){
    dao.save(competition);
    }
    public Competition getCompetition(int id){
    return dao.getCompetition(id);
    }
    public List<Competition> getCompetitions(){
    return dao.getCompetitions();
    }
}
