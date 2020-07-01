/**
 * 
 */
package com.spring.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.app.model.Game;
import com.spring.app.service.GameService;

/**
 * @author SRT
 *
 */
@Controller
public class GameController {

	/**
	 * 
	 */
    @Autowired
    private GameService gameService;
	
 
	@GetMapping(value = {"/indexTu"})
	public String index(Model model) {

	    model.addAttribute("title", "GameStore");

	    return "indexTu";

	}
	@GetMapping(value = "/gamesTu")
	public String getGames(Model model,
	        @RequestParam(value = "page", defaultValue = "1") int pageNumber) {

	    List<Game> games = gameService.findAll();
	   // long count = gameService.count();
	    model.addAttribute("gamesTu", games);


	    return "game-list";

	}
	
	@GetMapping(value = "/gamesTu/{gameId}")
	public String getGameById(Model model, @PathVariable Integer gameId) {

	    Optional<Game>  game = gameService.findById(gameId);
	    System.out.println("getGameById ==== >" + game.get().getId());
		if (game.isPresent()){

	        model.addAttribute("allowDelete", false);

	    } else {

	        model.addAttribute("errorMessage", "ERROR");

	    }

	    model.addAttribute("gameTu", game);        

	    return "gameTu";

	}
	
	@GetMapping(value = {"/gamesTu/add"})

	public String showAddGame(Model model) {

	    Optional<Game> 	game = Optional.ofNullable(new Game());

	    model.addAttribute("add", true);

	    model.addAttribute("gameTu", game);

	
	    return "gameTu-edit";

	}
	
	
	@PostMapping(value = "/gamesTu/add")
	public String addGame(Model model,

	        @ModelAttribute("game") Game game) {        
	    try {

	       Game newGame = gameService.save(game);

	        return "redirect:/gamesTu/" + String.valueOf(newGame.getId());

	    } catch (Exception ex) {

	        // log exception first, 

	        // then show error

	        //String errorMessage = ex.getMessage();            

	        model.addAttribute("errorMessage", "ERROR");
	
	        model.addAttribute("add", true);

	        return "gameTu-edit";

	    }        

	}
	
	
	@GetMapping(value = {"/gamesTu/{gameId}/edit"})

	public String showEditGame(Model model, @PathVariable Integer gameId) {

	    Optional<Game> 	game = gameService.findById(gameId);

	    if (!game.isPresent())
	    {

	        model.addAttribute("errorMessage","ERROR");

	    }

	    model.addAttribute("add", false);

	    model.addAttribute("gameTu", game);

	    return "gameTu-edit";

	}
	
	@PostMapping(value = {"/gamesTu/{gameId}/edit"})
	public String updateNote(Model model,

	        @PathVariable Integer gameId,

	        @ModelAttribute("gameTu") Game game) {

	    try {

	        game.setId(gameId);

	        gameService.save(game);

	        return "redirect:/gamesTu/" + String.valueOf(game.getId());

	    } catch (Exception ex) {

	        // log exception first, 

	        // then show error

	        String errorMessage = ex.getMessage();            

	  //      logger.error(errorMessage);

	        model.addAttribute("errorMessage", errorMessage);

	 

	        model.addAttribute("add", false);

	        return "gameTu-edit";

	    }
	}
	
	@GetMapping(value = {"/gamesTu/{gameId}/delete"})
	public String showDeleteGameById(

	    Model model, @PathVariable Integer gameId) {
	    Optional<Game> game = gameService.findById(gameId);

	    if(!game.isPresent())
	    {
	        model.addAttribute("errorMessage", "ERROR");
	    }

	    model.addAttribute("allowDelete", true);
	    model.addAttribute("gameTu", game);

	    return "gameTu";

	}
	
	@PostMapping(value = {"/gamesTu/{gameId}/delete"})

	public String deleteGameeById(

	        Model model, @PathVariable Integer gameId) {

	    try {

	    	gameService.deleteById(gameId);

	        return "redirect:/gamesTu";

	    } catch (Exception ex) {

	        String errorMessage = ex.getMessage();

	   //     logger.error(errorMessage);

	        model.addAttribute("errorMessage", errorMessage);

	        return "gameTu";

	    }

	}
}
