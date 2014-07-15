/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Service.MatchService;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import model.Match;
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
      session.put("date", date);
      return "add";
      }
}

