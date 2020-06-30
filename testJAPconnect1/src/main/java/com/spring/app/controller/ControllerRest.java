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
import com.spring.app.response.AjaxResponseBody;
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
	public AjaxResponseBody  insertMethod(@RequestBody Map<?, ?> params) {
		
		AjaxResponseBody result = new AjaxResponseBody();
    	double cost =0;
		System.out.println("param NAME === : "+params.get("name"));
		System.out.println("param COST ==== :"+  params.get("cost"));
		System.out.println("param CATEGORY == :"+params.get("category"));
		String cos ="";
		if(!"".equals( params.get("cost"))  )
		{
			 cos = (String) params.get("cost");
			 if((cos.matches("\\d*\\.?\\d+") || cos.matches("[0-9]+")) && cos.length() > 2)
			 {
				 cost = Double.parseDouble(cos);
			 }

		}

			
		if (params.get("name")!= null && cost!=0 && params.get("category")!=null )
		{
			String catego =(String) params.get("category");
		 
			if(  catego.matches("[0-9]+")  || "".equals(catego)  ) 
			{
				
				catego="N/A";
				result.setMsg("CATEGO_ERR");
			}
			else
			{
				System.out.println("Inserting...");
		    	String name = (String) params.get("name");    	
				System.out.println("param NAME: "+name);
				System.out.println("param COST :"+ cost);
				System.out.println("param CATEGORY :"+catego);
								
				Game game= new Game(name,cost ,catego);
				
				gameService.save(game);
				result.setMsg("OK");
								
			}
			
		}
		else
		{
			System.out.println("\n ERROR, not inserted");
			result.setMsg("error");
		}

		
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
		
		
		
	return result;
		
	}
}
