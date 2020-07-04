/**
 * 
 */
package com.spring.app.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.app.model.Game;
import com.spring.app.service.GameService;

/**
 * @author SRT
 *
 */
@RestController
@RequestMapping("/api")
public class GroupController {

	/**
	 * 
	 */
	
    @Autowired
    private GameService gameService;
	
    @GetMapping("/games")
    List<Game> groups() {
        return gameService.findAll();
    }
    @GetMapping("/game/{id}")
    ResponseEntity<Game> getGame(@PathVariable Integer id) {
        Optional<Game> game = gameService.findById(id);
        if(game.isPresent())
        	System.out.println(" game name =====> " + game.get().getName());
        else
        	System.out.println(" NO PRESENT ===");
        return game.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping("/game")
    ResponseEntity<Game> createGame( @RequestBody Game game) throws URISyntaxException {
       System.out.println("Request to create game: {}"+ game);
        Game result = gameService.save(game);
        return ResponseEntity.created(new URI("/api/game/" + result.getId()))
                .body(result);
    }
    @PostMapping("/game/{id}")
    ResponseEntity<Game> updateGame( @RequestBody Game game) {
        System.out.println("Request to update game: {}"+game);
        Game result = gameService.save(game);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping("/game/{id}")
    public ResponseEntity<?> deleteGame(@PathVariable Integer id) {
        System.out.println("Request to delete game: {}"+ id);
        gameService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
}
