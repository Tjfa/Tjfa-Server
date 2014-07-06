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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *@dynamic competitionId;
@dynamic isStart;
@dynamic name;
@dynamic number;
@dynamic time;
@dynamic type;

@dynamic matches;
@dynamic teams;
@dynamic players;
 * @author CZM
 */
@Entity
public class Competition implements Serializable {
    private int competitionId;
    private boolean isStart;
    private String name;
    private int number;
    private Date time;
    private int type;
    private List<Match> matches;
    private List<Team> teams;

    @OneToMany(mappedBy = "competition")
    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    @OneToMany(mappedBy = "competition")
    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @OneToMany(mappedBy = "competition")
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    private List<Player> players;
@Id
@GeneratedValue
    public int getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(int competitionId) {
        this.competitionId = competitionId;
    }

    public boolean isIsStart() {
        return isStart;
    }

    public void setIsStart(boolean isStart) {
        this.isStart = isStart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
     @Column(name="_date")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
