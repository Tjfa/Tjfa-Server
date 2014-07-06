/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import DAO.NewsDAO;
import DAO.PlayerDAO;
import java.util.List;
import javax.annotation.Resource;
import model.News;
import model.Player;
import org.springframework.stereotype.Component;

/**
 *
 * @author CZM
 */
@Component("newsService")
public class NewsService {
    private NewsDAO dao;

    public NewsDAO getDao() {
        return dao;
    }
@Resource(name="newsDAO")
    public void setDao(NewsDAO dao) {
        this.dao = dao;
    }
    public void delete(int id){
    dao.delete(id);
    }
    public void update(News news){
    dao.update(news);
    }
    public void save(News news){
    dao.save(news);
    }
    public News getNews(int id){
    return dao.getNews(id);
    }
    public List<News> getNews(){
    return dao.getNews();
    }
}
