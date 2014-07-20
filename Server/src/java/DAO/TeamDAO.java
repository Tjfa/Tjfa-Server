/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.annotation.Resource;
import model.Team;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author CZM
 */
@Component("teamDAO")
public class TeamDAO {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource(name = "hibernateTemplate")
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void delete(int id) {

        Team team = (Team) hibernateTemplate.load(Team.class, id);
        team = hibernateTemplate.merge(team);
        hibernateTemplate.delete(team);

    }
     public Team getTeam(int id){
        
      
      return (Team)hibernateTemplate.get(Team.class, id);
          
 
    }
    public void save(Team team) {
         
    
        hibernateTemplate.save(team);
     
    }
public void update(Team team){
hibernateTemplate.merge(team);
hibernateTemplate.flush();
}
  public List<Team> getTeams(){
  List<Team> teams;
  teams= hibernateTemplate.find("from Team");
      return teams;
      
  }
}
