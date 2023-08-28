package com.Project.Sportsclub.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.Project.Sportsclub.entity.Game;
import com.Project.Sportsclub.services.copy.GameServices;

@Controller
public class GameController {
	
	@Autowired
	public GameServices gameservices;

	
	@GetMapping("/addGame")
	public String addGamePage() {
		return "addGame";
	}
	
	@PostMapping("/addGame/game")
	public String addGame(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "minimum_fees", required = true) int fees,
			ModelMap gameModel) {
		
		Game game = new Game();
		game.setName(name);
		game.setMinimum_fees(fees);
		gameservices.addGame(game);
		gameModel.addAttribute("msg","Game added Sucessfully");
		//List <Game> games = ;
		System.out.println(gameservices.getGames());
		gameModel.addAttribute("games", gameservices.getGames());
	
		return "redirect:/Games";
		
	}
	
	@GetMapping("/game/{id}")
	public String getGame(@PathVariable int id, ModelMap gameModel) {
		Game game = gameservices.getGame(id);
		gameModel.addAttribute("game", game);
		return "Game";
	}
	
	
	@GetMapping("/Games")
	public String getGames(ModelMap gameModel) {
		//List <Game> games = gameservices.getGames();
		gameModel.addAttribute("games",gameservices.getGames());
		System.out.println(gameservices.getGames());
		return "Games";
	}
	
	@PostMapping("/updateGame/game")
	public String updateGame(@RequestParam int id,@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "minimum_fees", required = true) int fees,
			ModelMap gameModel) {
		
		Game game = new Game();
		game.setId((long) id);
		game.setMinimum_fees(fees);
		game.setName(name);
		gameservices.updateGame(game);
		List <Game> games = gameservices.getGames();
		gameModel.addAttribute("games",games);
		gameModel.addAttribute("id", id);
		gameModel.addAttribute("msg", "Game updated successfully");
		
		return "redirect:/Games";
		
	}
	
	@GetMapping("/updateGame/game/{id}")
	public String updatePage(@PathVariable int id, ModelMap gameModel){
		gameModel.addAttribute("id", id);
		Game game = gameservices.getGame(id);
		gameModel.addAttribute("game", game);
		return "UpdateGame";
		
	}
	
	@GetMapping("deleteGame/game/{id}")
	public String deleteGame(@PathVariable int id, ModelMap gameModel) {
		gameservices.deleteGame(id);
		List<Game> games = gameservices.getGames();
		gameModel.addAttribute("games", games);
		gameModel.addAttribute("msg", "Game deleted Successfully");
		
		return "redirect:/Games";
	}
	
}
