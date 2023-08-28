package com.Project.Sportsclub.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Project.Sportsclub.entity.Game;
//import com.Project.Sportsclub.entity.Player;
import com.Project.Sportsclub.entity.Tournament;
import com.Project.Sportsclub.repository.GameDAO;
//import com.Project.Sportsclub.services.copy.GameServices;
//import com.Project.Sportsclub.services.copy.PlayerServices;
import com.Project.Sportsclub.services.copy.TournamentServices;

@Controller
public class TournamentController {

//	@Autowired
//	public PlayerServices playerservices;

	@Autowired
	public TournamentServices tournamentservices;
	
	@Autowired
	public GameDAO gamedao;
		
	//tournament
	@GetMapping("/addTournament")
	public String addTournament() {
		return "addTournament";
	}
	
	@GetMapping ("/tournament/{id}")
	public String getTournamentId(@PathVariable int id, ModelMap tournamentModel) {
		Tournament tournament = tournamentservices.getTournament(id);
		tournamentModel.addAttribute("tournament", tournament);
		
		return "Tournament";
	}
	
	@GetMapping("/Tournaments")
	public String getTournaments(ModelMap tournamentModel) {
		//List<Tournament> tournaments = tournamentservices.getTournaments();
		System.out.println("tournament");
		tournamentModel.addAttribute("tournaments", tournamentservices.getTournaments());
		System.out.println("tournament");
		System.out.println(tournamentservices.getTournaments());
		return "Tournaments";
	}
	
	@PostMapping("/addTournament/tournament")
	public String addTournament(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "location", required = true) String location,
			@RequestParam(value = "date", required = true) String date,
			@RequestParam(value = "time", required = true) String time,
			@RequestParam(value = "Tournamentgame_name", required = true) String tournamentgame_name,
			ModelMap tournamentModel)
	{	
		System.out.print("hello");
		Game g = gamedao.getGameName(tournamentgame_name);
		
		if(g != null) {
			Tournament t = new Tournament();
			t.setname(name);
			t.setdate(date);
			t.setlocation(location);
			t.settime(time);
			t.setTournamentgame_name(g);
			tournamentservices.addTournamnet(t);
			tournamentModel.addAttribute("msg", "Tournamnet added successfulyy");
			//List <Tournament> tournaments = tournamentservices.getTournaments();
			tournamentModel.addAttribute("tournaments", tournamentservices.getTournaments());
			}
		
		else {
			System.out.print("Game does not exist");
		}
		
		return"redirect:/Tournaments";
	}
	
	@PostMapping("updateTournament/tournament")
	public String updateTournament(@RequestParam int id,@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "location", required = true) String location,
			@RequestParam(value = "date", required = true) String date,
			@RequestParam(value = "time", required = true) String time,
			@RequestParam(value = "Tournamentgame_name", required = true) String Tournamentgame_name,
			ModelMap tournamentModel) {
		
		System.out.println("hi");
		Game g = gamedao.getGameName(Tournamentgame_name);
		
		Tournament t = new Tournament();
		t.setId(id);
		t.setname(name);
		t.setdate(date);
		t.setlocation(location);
		t.settime(time);
		t.setTournamentgame_name(g);
		tournamentservices.updateTournament(t);
		
		//List<Tournament> tournament = tournamentservices.getTournaments();
		tournamentModel.addAttribute("tournament", tournamentservices.getTournaments());
		tournamentModel.addAttribute("id", id);
		tournamentModel.addAttribute("msg", "Tournament updated Successfully");

		
		
		return "redirect:/Tournamnets";
	}
	
	
	@GetMapping("/updateTournament/tournament/{id}")
	public String updateTournamentId(@PathVariable int id, ModelMap tournamentModel) {
		tournamentModel.addAttribute("id", id);
		Tournament tournament = tournamentservices.getTournament(id);
		tournamentModel.addAttribute("tournament", tournament);
		
		return "UpdateTournament";
	}
	
	@GetMapping("/deleteTournament/tournament/{id}")
	public String deleteTournament(@PathVariable int id, ModelMap tournamentModel) {
		tournamentservices.deleteTournament(id);
		//List <Tournament> tournament = tournamentservices.getTournaments();
		tournamentModel.addAttribute("tournament", tournamentservices.getTournaments());
		tournamentModel.addAttribute("msg", "Tournament deleted successfully");
		return "redirect:/Tournaments";
	}

}



//package com.Project.Sportsclub.controller;
//
////import java.util.List;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
////import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.Project.Sportsclub.entity.Game;
//import com.Project.Sportsclub.entity.Tournament;
//import com.Project.Sportsclub.repository.GameDAO;
//import com.Project.Sportsclub.services.copy.TournamentServices;
//
//public class TournamentController {
//	@Autowired
//	public TournamentServices tournamentservices;
//	
//	@Autowired
//	public GameDAO gamedao;
//	
////	   @RequestMapping("/error")
////	   public String handleError() {
////	       // return custom error view
////	       return "customerror";
////	   }
////	
////	   public String getErrorPath() {
////	       return "/error";
////	   }
//	
//	
//	@GetMapping("/addTournament")
//	public String addTournament() {
//		return "addTournament";
//	}
//	
//	@GetMapping ("/tournament/{id}")
//	public String getTournamentId(@PathVariable int id, ModelMap tournamentModel) {
//		Tournament tournament = tournamentservices.getTournament(id);
//		tournamentModel.addAttribute("tournament", tournament);
//		
//		return "Tournament";
//	}
//	
//	@GetMapping("/Tournaments")
//	public String getTournaments(ModelMap tournamentModel) {
//		//List<Tournament> tournaments = tournamentservices.getTournaments();
//		System.out.println("tournament");
//		tournamentModel.addAttribute("tournaments", tournamentservices.getTournaments());
//		System.out.println("tournament");
//		System.out.println(tournamentservices.getTournaments());
//		return "Tournaments";
//	}
//	
//	@PostMapping("addTournament/tournamnet")
//	public String addTournament(@RequestParam(value = "name", required = true) String name,
//			@RequestParam(value = "location", required = true) String location,
//			@RequestParam(value = "date", required = true) String date,
//			@RequestParam(value = "time", required = true) String time,
//			@RequestParam(value = "Tournamentgame_name", required = true) String tournamentgame_name,
//			ModelMap tournamentModel)
//	{	Game g = gamedao.getGameName(tournamentgame_name);
//		
//		if(g != null) {
//			Tournament t = new Tournament();
//			t.setname(name);
//			t.setdate(date);
//			t.setlocation(location);
//			t.settime(time);
//			t.setTournamentgame_name(g);
//			tournamentservices.addTournamnet(t);
//			tournamentModel.addAttribute("msg", "Tournamnet added successfulyy");
//			//List <Tournament> tournaments = tournamentservices.getTournaments();
//			tournamentModel.addAttribute("tournaments", tournamentservices.getTournaments());
//			}
//		
//		else {
//			System.out.print("Game does not exist");
//		}
//		
//		return"redirect:/Tournaments";
//	}
//	
//	@PostMapping("updateTournament/tournament")
//	public String updateTournament(@RequestParam int id,@RequestParam(value = "name", required = true) String name,
//			@RequestParam(value = "location", required = true) String location,
//			@RequestParam(value = "date", required = true) String date,
//			@RequestParam(value = "time", required = true) String time,
//			@RequestParam(value = "Tournamentgame_name", required = true) String tournamentgame_name,
//			ModelMap tournamentModel) {
//		
//		Game g = gamedao.getGameName(tournamentgame_name);
//		
//		Tournament t = new Tournament();
//		t.setId(id);
//		t.setname(name);
//		t.setdate(date);
//		t.setlocation(location);
//		t.settime(time);
//		t.setTournamentgame_name(g);
//		tournamentservices.updateTournament(t);
//		
//		//List<Tournament> tournament = tournamentservices.getTournaments();
//		tournamentModel.addAttribute("tournament", tournamentservices.getTournaments());
//		tournamentModel.addAttribute("id", id);
//		tournamentModel.addAttribute("msg", "Tournament updated Successfully");
//
//		
//		
//		return "redirect:/Tournamnets";
//	}
//	
//	
//	@GetMapping("/updateTournament/tournament/{id}")
//	public String updateTournamentId(@PathVariable int id, ModelMap tournamentModel) {
//		tournamentModel.addAttribute("id", id);
//		Tournament tournament = tournamentservices.getTournament(id);
//		tournamentModel.addAttribute("tournament", tournament);
//		
//		return "UpdateTournament";
//	}
//	
//	@GetMapping("/deleteTournament/tournament/{id}")
//	public String deleteTournament(@PathVariable int id, ModelMap tournamentModel) {
//		tournamentservices.deleteTournament(id);
//		//List <Tournament> tournament = tournamentservices.getTournaments();
//		tournamentModel.addAttribute("tournament", tournamentservices.getTournaments());
//		tournamentModel.addAttribute("msg", "Tournament deleted successfully");
//		return "redirect:/Tournaments";
//	}
//	
//}
