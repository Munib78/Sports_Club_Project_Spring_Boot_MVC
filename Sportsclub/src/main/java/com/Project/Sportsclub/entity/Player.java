package com.Project.Sportsclub.entity;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
 public class Player {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
	@Column(name = "name")
	 private String name;
	
	
	@Column(name = "mobile_no")
	 private Long mobile_no;
	 
	 @ManyToOne(targetEntity = Game.class,cascade = CascadeType.ALL)
	 private Game game_name;
	 
	 public Game getGame_name() 
	 {
		return game_name;
	 }


	public void setGame_name(Game game_name) 
	{
		this.game_name = game_name;
	}


	public Long getId() 
	{
		return id;
	}


	public void setId(Long id) 
	{
		this.id = id;
	}


	public String getname() 
	{
		return name;
	}


	public void setname(String name) 
	{
		this.name = name;
	}


	public Long getmobile_no() 
	{
		return mobile_no;
	}


	public void setmobile_no(Long mobile_no) 
	{
		this.mobile_no = mobile_no;
	}


	public Player() {
		// TODO Auto-generated constructor stub
	}

}
