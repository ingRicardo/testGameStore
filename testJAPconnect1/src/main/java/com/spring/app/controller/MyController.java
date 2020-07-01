/**
 * 
 */
package com.spring.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.spring.app.model.Game;
import com.spring.app.service.GameService;


/**
 * @author SRT
 *
 */
@Controller
public class MyController {

	
    @Autowired
    private GameService gameService;

    @RequestMapping("/index")
    public String index(Model model) {

        return "index";
    }
    

    @RequestMapping("/games")
    public ModelAndView showCities() {

        List<Game> games = gameService.findAll();
        System.out.println("games ==> "+ games.size());
        Map<String, Object> params = new HashMap<>();
        params.put("games", games);

        return new ModelAndView("showGames", params);
    
    }
    @RequestMapping("/insertGame")
    public String InsertGame(Model model)
    {
       // AjaxResponseBody result = new AjaxResponseBody();
    	System.out.println("add");
    	 model.addAttribute("add", true);
    	return "insertGame";
    	
    }
    @GetMapping(value = {"/games/{gameId}/edit"})
    public String showEditGame(Model model, @PathVariable int gameId) {
    	

    		Optional<Game> game = gameService.findById(gameId);
    		if (game.isPresent()){
    		     
    		    System.out.println("GETMAPPPING game ID =====> "+game.get().getId());
    		   // processing with foo ...
    		}
    		else{
    		   // alternative processing....
    		}
    		

    	   model.addAttribute("add", false);

    	   model.addAttribute("game", game);
    	
		return "insertGame"; 
    }
    
    
    

    @PostMapping(value = {"/games/{gameId}/edit"})
    public String updateGame(Model model, @PathVariable int gameId,
            @ModelAttribute("game") Optional<Game> game) {

        try {

        	
        	System.out.println("postMapping -- name xxxxx -> "+ game.get().getName());
        	
        	game = gameService.findById(gameId);
        	
        	if (game.isPresent()){
   		     
    		    System.out.println("Found  game ID =====> "+game.get().getId());
    		   // processing with foo ...
    		    System.out.println("Found name ===>  "+ game.get().getName());
    		    Game gam = new Game(game.get().getId(),game.get().getName(), game.get().getCost(), game.get().getCategory());
    	        gameService.save(gam);
    		}
    		else{
    		   // alternative processing....
    		}
            //noteService.update(note);
            // need to find the record with the ID
          
            return "redirect:/"  ;

        } catch (Exception ex) {

            // log exception first, 

            // then show error

            String errorMessage = ex.getMessage();            

            model.addAttribute("errorMessage", errorMessage);

            model.addAttribute("add", false);

            return "insertGame";

        }
    }
    
    
}
