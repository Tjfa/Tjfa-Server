/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Service.MatchService;
import Service.TeamService;
import com.opensymphony.xwork2.ActionSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import model.Match;
import model.Team;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author CZM
 */

    public class MatchAction extends ActionSupport implements SessionAware,ServletRequestAware{
    Map<String, Object> session;
    HttpServletRequest request;
    private MatchService matchService;
    private TeamService teamService;

    public MatchService getMatchService() {
        return matchService;
    }

    public void setMatchService(MatchService matchService) {
        this.matchService = matchService;
    }

    public TeamService getTeamService() {
        return teamService;
    }

    public void setTeamService(TeamService teamService) {
        this.teamService = teamService;
    }
    @Override
    public void setSession(Map<String, Object> session) {
        this.session=session;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request=request;
    }
      public String list(){
    return "list";
    }
      public String add(){
      Match match=new Match();
      String name=request.getParameter("name");
      String date=request.getParameter("date");
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       Date date1=null;
        try {
             date1 = sdf.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(MatchAction.class.getName()).log(Level.SEVERE, null, ex);
        }
     String teamA=request.getParameter("teamA");
     String teamB=request.getParameter("teamB");
     String type=request.getParameter("type");
     String scoreA=request.getParameter("scoreA");
     String scoreB=request.getParameter("scoreB");
     match.setCompetition(null);
     match.setDate(date1);
     match.setIsStart(true);
     match.setMatchProperty(Integer.parseInt(type));
     match.setScoreA(Integer.parseInt(scoreA));
     match.setScoreA(Integer.parseInt(scoreB));
     Team teamA1=teamService.getTeam(Integer.parseInt(teamA));
     Team teamB1=teamService.getTeam(Integer.parseInt(teamB));
     match.setTeamA(teamA1);
     match.setTeamB(teamB1);
     matchService.save(match);
      return "add";
      }
}

