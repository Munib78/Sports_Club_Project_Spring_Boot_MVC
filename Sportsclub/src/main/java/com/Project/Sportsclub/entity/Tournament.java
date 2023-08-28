package com.Project.Sportsclub.entity;

//import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Tournament {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String location;
	String date;
	String time;
	
//	@OneToMany(targetEntity = Match.class,mappedBy="tournament_name",cascade = CascadeType.ALL)
//	List <Match> match_list;
//	
	
	@OneToOne(targetEntity = Game.class,cascade = CascadeType.ALL)
	Game Tournamentgame_name;
	
//	public List<Match> getMatch_list() {
//		return match_list;
//	}
//
//	public void setMatch_list(List<Match> match_list) {
//		this.match_list = match_list;
//	}

	public Game getTournamentgame_name() {
		return Tournamentgame_name;
	}

	public void setTournamentgame_name(Game Tournamentgame_name) {
		this.Tournamentgame_name = Tournamentgame_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getlocation() {
		return location;
	}

	public void setlocation(String location) {
		this.location = location;
	}

	public String getdate() {
		return date;
	}

	public void setdate(String date) {
		this.date = date;
	}

	public String gettime() {
		return time;
	}

	public void settime(String time) {
		this.time = time;
	}

	public Tournament() {
		super();
		// TODO Auto-generated constructor stub
	}

}
