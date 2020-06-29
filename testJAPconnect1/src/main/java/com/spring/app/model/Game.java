/**
 * 
 */
package com.spring.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author SRT
 *
 */
@Entity
@Table(name = "game")
public class Game {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
	private int id;
    @Column(name = "name")
	private String name;
    @Column(name = "cost")
	private int cost;
    @Column(name = "category")
	private String category;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
    
    
	
	
	
	
}
