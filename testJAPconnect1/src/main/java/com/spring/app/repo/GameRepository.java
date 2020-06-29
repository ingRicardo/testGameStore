/**
 * 
 */
package com.spring.app.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.app.model.Game;

/**
 * @author SRT
 *
 */
@Repository
public interface GameRepository  extends CrudRepository<Game, Long>{

}
