package com.Project.Sportsclub.services.copy;

import java.util.List;


import com.Project.Sportsclub.entity.Game;
import com.Project.Sportsclub.repository.GameDAO;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class GameServices {
	
	@Autowired
	private GameDAO gamedao ;

	public Game getGame(final int id) {
		return gamedao.getGame(id);
	}

	public List<Game> getGames() {
		return gamedao.getGames();
	}

	public void addGame(final Game game) {
		gamedao.addGame(game);
	}

	public void updateGame(final Game game) {
		gamedao.updateGame(game);
	}

	public void deleteGame(final int id) {
		gamedao.deleteGame(id);
	}

}

