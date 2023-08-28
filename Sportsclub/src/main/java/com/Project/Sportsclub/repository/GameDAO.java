package com.Project.Sportsclub.repository;

import java.util.List;



import org.hibernate.Session;
//import com.Project.Sportsclub.utilites.HibernateUtil;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.Project.Sportsclub.entity.Game;
import com.Project.Sportsclub.entity.Player;
// import com.Project.SportsClub.utilites.HibernateUtilites;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;


@Repository
public class GameDAO {
 
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public GameDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Transactional
	public void addGame(Game g) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(g);
		session.close();
	}
	
	@Transactional
	public void addPlayertoGame(String game_name,Player p) {
		Session session =  entityManager.unwrap(Session.class);
		Game g = session.get(Game.class, game_name);
		
		if(g != null) {
			
			List<Player> player = g.getPlayers();
			player.add(p);
			session.persist(p);
			session.close();
			
		}
	}
	

	public List<Game> getGames() {
		Session currsession =  entityManager.unwrap(Session.class);
		
		TypedQuery<Game> query = currsession.createQuery("from Game",Game.class);
		
		List <Game> games = query.getResultList();
		currsession.close();
		return games;
	}
	
	public Game getGame(int id) {
		Session currsession =  entityManager.unwrap(Session.class);
		Game g = currsession.get(Game.class, id);
		currsession.close();
		return g;
	}
	
	public Game getGameName(String name) {
		Session currsession = entityManager.unwrap(Session.class);
		System.out.println("ac");
		
		TypedQuery<Game> q = currsession.createQuery("from Game where name = " + name + " ",Game.class);
		
		//TypedQuery<Game> q = currsession.createQuery("from Game where name = '" + name + "'", Game.class);
		//TypedQuery<Game> q = currsession.createQuery("from Game where name = :name", Game.class);
		//q.setParameter("name", name);
		System.out.println(q);
		List<Game> g = q.getResultList();
		
		System.out.println("g");
		System.out.println(g);
		
		Game game = g.get(0);
		
		System.out.println("game");
		System.out.println(game);
		currsession.close();
		return game;
	}
	
//	public Game getGameName(Game name) {
//		Session currsession = entityManager.unwrap(Session.class);
//		System.out.println("acq");
//		
//		TypedQuery<Game> q = currsession.createQuery("from Game where name = " + name + " ",Game.class);
//		
//		//TypedQuery<Game> q = currsession.createQuery("from Game where name = '" + name + "'", Game.class);
//		//TypedQuery<Game> q = currsession.createQuery("from Game where name = :name", Game.class);
//		q.setParameter("name", name);
//		System.out.println(q);
//		List<Game> g = q.getResultList();
//		
//		System.out.println("g");
//		System.out.println(g);
//		
//		Game game = g.get(0);
//		
//		System.out.println("game");
//		System.out.println(game);
//		currsession.close();
//		return game;
//	}
	
	@Transactional
	public void updateGame(Game game) {
		Session session =  entityManager.unwrap(Session.class);
		session.merge(game);
		session.close();
	}
	
	@Transactional
	public void deleteGame(int id) {
		Session session =  entityManager.unwrap(Session.class);
		Game g = session.get(Game.class, id);
		if(g != null) {
			session.remove(g);
			session.close();
		}
		
		else {
			System.out.println("No such Game Found");
			session.close();
		}
	
	}
		
	
}
	
