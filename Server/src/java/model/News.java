/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**@dynamic content;
@dynamic date;
@dynamic newsId;
@dynamic title;
 *
 * @author CZM
 */
@Entity
public class News {
    private String content;
    private int newsId;
    private String title;
    private Date date;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
@Id
@GeneratedValue
    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="_date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
