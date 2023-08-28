package com.Project.Sportsclub.entity;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Game {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	 @Column(name = "name")
	private String name;
	 @Column(name = "minimum_fees")
	private int minimum_fees;
	
	
	@OneToMany(targetEntity = Player.class,mappedBy = "game_name", cascade = CascadeType.ALL)
	private List<Player> players;
	
	@OneToOne(targetEntity = Tournament.class,mappedBy = "Tournamentgame_name", cascade = CascadeType.ALL)
	private Tournament tournament;
//	
	//@JoinColumn(name= "player_id")
	
	
	
	public Game(String name, int minimum_fees) {
		super();
		this.name = name;
		this.minimum_fees = minimum_fees;
	}


	public List<Player> getPlayers() {
		return players;
	}


	public void setPlayers(List<Player> players) {
		this.players = players;
	}


	public Long getId() {
		return id;
	}
 

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



	public int getMinimum_fees() {
		return minimum_fees;
	}


	public void setMinimum_fees(int minimum_fees) {
		this.minimum_fees = minimum_fees;
	}


	public Game() {
		// TODO Auto-generated constructor stub
	}


	public Tournament getTournament() {
		return tournament;
	}


	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

}
