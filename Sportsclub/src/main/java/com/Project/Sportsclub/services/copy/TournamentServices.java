package com.Project.Sportsclub.services.copy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.Sportsclub.entity.Tournament;

import com.Project.Sportsclub.repository.TournamentDAO;

@Service
public class TournamentServices {


	@Autowired
	private TournamentDAO tournamentdao;

	public Tournament getTournament(final int id) {
		return tournamentdao.getTournament(id);
	}

	public List<Tournament> getTournaments() {
		return tournamentdao.getTournaments();
	}

	public void addTournamnet(final Tournament t) {
		tournamentdao.addTournament(t);
	}

	public void updateTournament(final Tournament t) {
		tournamentdao.updateTournament(t);
	}

	public void deleteTournament(final int id) {
		tournamentdao.getTournament(id);
	}
	
}
