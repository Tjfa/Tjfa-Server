/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Service.NewsService;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.News;
import model.NewsJson;
import net.sf.json.JSONObject;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author CZM
 */
public class NewsAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware {

    Map<String, Object> session;
    HttpServletRequest request;
    private NewsService newsService;
    private HttpServletResponse response;

    public NewsService getNewsService() {
        return newsService;
    }

    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void list()  {
        response.setContentType("text/html");
        
        PrintWriter out=null;
        try {
            out=response.getWriter();
        } catch (IOException ex) {
            Logger.getLogger(NewsAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        String newsId = request.getParameter("newsId");
        String limit = request.getParameter("limit");
        int limits = Integer.parseInt(limit);
        int id = Integer.parseInt(newsId);
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (id == -1) {
            List<News> newses = newsService.getLatest(limits);
            for (int i = 0; i < newses.size(); i++) {
                News news = newses.get(i);
                NewsJson newJson = new NewsJson();

                newJson.setNewsId(news.getNewsId());
                java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String dateStr = format1.format(news.getDate());
                newJson.setDate(dateStr);
                newJson.setTitle(news.getTitle());
                JSONObject object = JSONObject.fromObject(newJson);
                json.append(object.toString());
                json.append(",");

            }
            json.deleteCharAt(json.lastIndexOf(","));
            json.append("]");
        } else {
            List<News> newses = newsService.getLimitList(id,limits);
            for (int i = 0; i < newses.size() ; i++) {
                News news = newses.get(i);
                NewsJson newJson = new NewsJson();

                newJson.setNewsId(news.getNewsId());
                java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String dateStr = format1.format(news.getDate());
                newJson.setDate(dateStr);
                newJson.setTitle(news.getTitle());
                JSONObject object = JSONObject.fromObject(newJson);
                json.append(object.toString());
                json.append(",");
            }
            json.deleteCharAt(json.lastIndexOf(","));
            json.append("]");
        }
        out.write(json.toString());
        
    }

    public String add() {
        try {

            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(NewsAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String content = request.getParameter("content");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = sdf.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(MatchAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        News news = new News();
        news.setContent(content);
        news.setDate(date1);
        news.setTitle(name);
        session.put("name", name);
        session.put("content", content);
        newsService.save(news);
        return "add";
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response=response;
    }
    public void content(){
     response.setContentType("text/html");
        
        PrintWriter out=null;
        try {
            out=response.getWriter();
        } catch (IOException ex) {
            Logger.getLogger(NewsAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        String newsId = request.getParameter("newsId");
        News news=newsService.getNews(Integer.parseInt(newsId));
        String str="\"content\":<div style=\\\"color:red;font-size:30px\\\">aaaa<\\/div>\"";
    str=str.replace("aaaa", news.getContent());
        out.write(str.toString());
    }
}
