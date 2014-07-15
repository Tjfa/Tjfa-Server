/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author CZM
 */
public class PlayerAction extends ActionSupport implements SessionAware,ServletRequestAware{
    Map<String, Object> session;
    HttpServletRequest request;

    @Override
    public void setSession(Map<String, Object> session) {
        this.session=session;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request=request;
    }
    public String edit(){
    String name=request.getParameter("name");
    String id=request.getParameter("id");
    session.put("name", name);
    session.put("id", id);
        return "editsuccess";
    }
    public String list(){
    return "list";
    }
}
