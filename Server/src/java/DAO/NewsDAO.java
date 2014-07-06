/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.annotation.Resource;
import model.News;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author CZM
 */
@Component("newsDAO")
public class NewsDAO {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource(name = "hibernateTemplate")
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void delete(int id) {

        News news = (News) hibernateTemplate.load(News.class, id);
        news = hibernateTemplate.merge(news);
        hibernateTemplate.delete(news);

    }
     public News getNews(int id){
        
      
      return (News)hibernateTemplate.get(News.class, id);
          
 
    }
    public void save(News news) {
         
    
        hibernateTemplate.save(news);
     
    }
public void update(News news){
hibernateTemplate.merge(news);
hibernateTemplate.flush();
}
  public List<News> getNews(){
  List<News> news;
  news= hibernateTemplate.find("from News");
      return news;
      
  }
}
