/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.annotation.Resource;
import model.Competition;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author CZM
 */
@Component("competitionDAO")
public class CompetitionDAO {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource(name = "hibernateTemplate")
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void delete(int id) {

        Competition competition = (Competition) hibernateTemplate.load(Competition.class, id);
        competition = hibernateTemplate.merge(competition);
        hibernateTemplate.delete(competition);

    }
     public Competition getCompetition(int id){
        
      
      return (Competition)hibernateTemplate.get(Competition.class, id);
          
 
    }
    public void save(Competition competition) {
         
    
        hibernateTemplate.save(competition);
     
    }
public void update(Competition c){
hibernateTemplate.merge(c);
hibernateTemplate.flush();
}
  public List<Competition> getCompetitions(){
  List<Competition> competitions;
  competitions= hibernateTemplate.find("from Player");
      return competitions;
      
  }
}
