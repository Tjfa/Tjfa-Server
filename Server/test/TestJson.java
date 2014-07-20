
import java.util.Date;
import model.News;
import net.sf.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CZM
 */
public class TestJson {
    public static void main(String agr[]){
    News news=new News();
    java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
      
    news.setDate(new Date());
    news.setNewsId(1);
    news.setTitle("newstitle");
    news.setContent("newscontent");
     String s = format1.format(news.getDate());
    NewsJson newJson=new NewsJson();
    
    newJson.setNewsId(news.getNewsId());
    newJson.setDate(s);
    newJson.setTitle(news.getTitle());
    JSONObject object = JSONObject.fromObject(newJson);
    StringBuilder json = new StringBuilder();
    json.append("[");
    json.append(object.toString());
    json.append(",");
    json.append(object.toString());
    json.append(",");
    json.append(object.toString());
    json.append("]");
    //{"content":"<div style=\"color:red; font-size:30px\">aaaa<\/div>"}
    String str="\"content\":<div style=\\\"color:red;font-size:30px\\\">aaaa<\\/div>\"";
    str=str.replace("aaaa", news.getContent());
    System.out.println(str.toString());
    System.out.println(json.toString());
    }
}
