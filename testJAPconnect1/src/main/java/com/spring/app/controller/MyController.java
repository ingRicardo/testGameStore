/**
 * 
 */
package com.spring.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    
}
