/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.annotation.Resource;
import model.Match;


import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author CZM
 */
@Component("matchDAO")
public class MatchDAO {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource(name = "hibernateTemplate")
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void delete(int id) {

        Match match = (Match) hibernateTemplate.load(Match.class, id);
        match = hibernateTemplate.merge(match);
        hibernateTemplate.delete(match);

    }
     public Match getMatch(int id){
        
      
      return (Match)hibernateTemplate.get(Match.class, id);
          
 
    }
    public void save(Match match) {
         
    
        hibernateTemplate.save(match);
     
    }
public void update(Match match){
hibernateTemplate.merge(match);
hibernateTemplate.flush();
}
  public List<Match> getMatches(){
  List<Match> matches;
  matches= hibernateTemplate.find("from Match");
      return matches;
      
  }
}
