package com.Project.Sportsclub.services.copy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.Project.Sportsclub.entity.Player;
import com.Project.Sportsclub.repository.PlayerDAO;

@Service
public class PlayerServices {
	@Autowired
	private PlayerDAO playerdao;

	public Player getPlayer(final int id) {
		return playerdao.getPlayer(id);
	}

	public List<Player> getPlayers() {
		return playerdao.getPlayers();
	}

	public void addPlayer(final String game_name, final Player player)
	{
		System.out.println("ji");

		playerdao.addPlayer(game_name, player);
	}

	public void updatePlayer(final Player player) {
		playerdao.updatePlayer(player);;
	}

	public void deletePlayer(final int id) {
		playerdao.deletePlayer(id);
	}
}
