package com.Project.Sportsclub.repository;

import java.util.List;


import org.hibernate.Session;
//import com.Project.Sportsclub.utilites.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Project.Sportsclub.entity.Game;
import com.Project.Sportsclub.entity.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class PlayerDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	public GameDAO gamedao;
	
	public PlayerDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Transactional
	public void addPlayer(String game_name,Player p) {
		System.out.println("78");
		Session session = entityManager.unwrap(Session.class);
		System.out.println("rw");
		TypedQuery<Game> query = session.createQuery("from Game where name = :name", Game.class);
		query.setParameter("name", game_name);

		List<Game> games = query.getResultList();
		
		System.out.println("games");
		System.out.println(games);
		
		if(!games.isEmpty()) {
			Game game = games.get(0);
	        p.setGame_name(game);
	        System.out.println("done");
			session.persist(p);
			session.close();
			// gamedao.addPlayertoGame(game_name, p);
			System.out.println("Game doees  exist");
		}
		
		else{
			System.out.println("Game doees not exist");
		}
	}
	

	public List<Player> getPlayers() {
		Session session = entityManager.unwrap(Session.class);
		TypedQuery<Player> query = session.createQuery("from Player",Player.class);
		
		List <Player> p = query.getResultList();
		session.close();
		return p;
		
	}
	
	public Player getPlayer(int id) {
		Session session = entityManager.unwrap(Session.class);
		Player p = session.get(Player.class,id);
		
		session.close();
		
		return p;
	}
	
	@Transactional
	public void updatePlayer(Player p) {
		Session session = entityManager.unwrap(Session.class);
		session.merge(p);
		session.close();
		
	}
	
	@Transactional
	public void deletePlayer(int id) {
		Session session = entityManager.unwrap(Session.class);
		Player p = session.get(Player.class,id);
		session.remove(p);
		session.close();
		
	}
		
}
	

	
	