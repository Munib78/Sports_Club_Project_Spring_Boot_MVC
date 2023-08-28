package com.Project.Sportsclub.repository;

import java.util.List;



import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//import com.Project.Sportsclub.utilites.HibernateUtil;
//import com.Project.Sportsclub.entity.Game;
//import com.Project.Sportsclub.entity.Match;
//import com.Project.Sportsclub.entity.Game;
import com.Project.Sportsclub.entity.Tournament;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class TournamentDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public TournamentDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Transactional
	public void addTournament(Tournament t) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(t);
		session.close();

	}
	
//	@Transactional
//	public void addMatchtoTounament(String tournament_name, Match m) {
//		Session session = entityManager.unwrap(Session.class);
//		Tournament t =  session.get(Tournament.class, tournament_name);
//		
//		if(t != null) {
//			List <Match> match = t.getMatch_list();
//			match.add(m);
//			session.persist(m);
//			session.close();
//		}
//		
//		
//	}
	

	public Tournament getTournamentName(String name) {
		Session currsession = entityManager.unwrap(Session.class);
		
		//TypedQuery<Tournament> q = currsession.createQuery("from Tournament where name = " + name, Tournament.class);
		TypedQuery<Tournament> query = currsession.createQuery("from Game where name = :name", Tournament.class);
		query.setParameter("name", name);
		
		
		List<Tournament> t = query.getResultList();
		Tournament tournament = t.get(0);
		currsession.close();
		return tournament;
	}
	
	public Tournament getTournament(int id) {
		Session session = entityManager.unwrap(Session.class);
		Tournament t= session.get(Tournament.class, id);
		session.close();
		return t;
	}
	
	public List<Tournament> getTournaments(){
		Session session = entityManager.unwrap(Session.class);
		
		TypedQuery<Tournament> q = session.createQuery("from Tournament",Tournament.class);
		List<Tournament> t= q.getResultList();
		session.close();
		return t;
	} 
	
	@Transactional
	public void updateTournament(Tournament t) {
		Session session = entityManager.unwrap(Session.class);
		session.merge(t);
		session.close();
	}
	
	@Transactional
	public void deleteTournament(int id) {
		Session session = entityManager.unwrap(Session.class);
		Tournament t = session.get(Tournament.class, id);
		
		if(t != null) {
			session.remove(t);
			session.close();
		}
		
		else {
			System.out.println("No such tournament exist");
		}
	}

}
