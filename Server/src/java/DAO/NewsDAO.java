/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import model.News;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

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
  public List<News> getLimitList(int id,int limit){
      final int newsId=id;
  final int nums=limit;
  List<News> news=hibernateTemplate.executeFind(new HibernateCallback() {

           @Override
           public Object doInHibernate(Session sn) throws HibernateException, SQLException {
               Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from News news where news.newsId<="+newsId+" order by news.newsId desc");
            query.setFirstResult(0);
            query.setMaxResults(nums);
List list = query.list();
            return list;
           }
       });
      return news;
  
  }
  public List<News> getLatest(int limit){
  final int x=limit;
  List<News> news=hibernateTemplate.executeFind(new HibernateCallback() {

           @Override
           public Object doInHibernate(Session sn) throws HibernateException, SQLException {
               Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from News news order by news.newsId desc");
            query.setFirstResult(0);
            query.setMaxResults(x);
List list = query.list();
            return list;
           }
       });
      return news;
  }
  
}
