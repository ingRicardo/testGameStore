/**
 * 
 */
package com.spring.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.app.model.Game;
import com.spring.app.service.GameService;

/**
 * @author SRT
 *
 */
@RestController
public class ControllerRest {

	@Autowired
	private GameService gameService;
	   
    @PostMapping("/addGame")
	@ResponseBody
	public /*AjaxResponseBody*/ void insertMethod(@RequestBody Map<?, ?> params) {
		
	//	AjaxResponseBody result = new AjaxResponseBody();
	//	 UsuarioDAO dao = new UsuarioDAO();
    	
    	String name = (String) params.get("name");
    	String cost = (String) params.get("cost");
    	String catego =(String) params.get("category");
		System.out.println("param NAME: "+name);
		System.out.println("param COST :"+ cost);
		System.out.println("param CATEGORY :"+catego);
		
		Game game= new Game(name,Integer.parseInt(cost) ,catego);
		
		gameService.save(game);
		
		//boolean exists = dao.isUserExists(params.get("user").toString(), params.get("pass").toString());
		//System.out.println(exists);
		
	/*	if (exists) {
			result.setMsg("exists");
			id = dao.getUserId(params.get("user").toString(), params.get("pass").toString());
			System.out.println("id ->>> "+ id);
		}else
			result.setMsg("error");
	*/
			//result.setError("");
			//result.setObj(params);
			//result.setMsg("OK");
			//result.setStatus("completed");
		
		
		
	//	return result;
		
	}
}
