/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *@dynamic date;
@dynamic matchId;
@dynamic isStart;
@dynamic matchProperty;
@dynamic scoreA;
@dynamic scoreB;
@dynamic winTeamId;
@dynamic competition;
@dynamic teams;
 * @author CZM
 */
@Entity
@Table(name="_match")
public class Match implements Serializable {
    private Date date;
    private boolean isStart;
    private int matchProperty;
    private int scoreA;
    private int scoreB;
    private Team winTeam;
    private Competition competition;
    private List<Team> teams;
    private int matchId;
@Id
@GeneratedValue
    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="_date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isIsStart() {
        return isStart;
    }

    public void setIsStart(boolean isStart) {
        this.isStart = isStart;
    }

    public int getMatchProperty() {
        return matchProperty;
    }

    public void setMatchProperty(int matchProperty) {
        this.matchProperty = matchProperty;
    }

    public int getScoreA() {
        return scoreA;
    }

    public void setScoreA(int scoreA) {
        this.scoreA = scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    public void setScoreB(int scoreB) {
        this.scoreB = scoreB;
    }

    @ManyToOne
    public Team getWinTeam() {
        return winTeam;
    }

    public void setWinTeam(Team winTeam) {
        this.winTeam = winTeam;
    }

    @ManyToOne
    
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    
    @OneToMany(mappedBy = "match")
    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
