/**
 * 
 */
package com.spring.app.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    
}
