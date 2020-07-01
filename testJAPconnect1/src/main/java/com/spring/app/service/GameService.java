/**
 * 
 */
package com.spring.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
import com.spring.app.model.Game;
import com.spring.app.repo.GameRepository;

/**
 * @author SRT
 *
 */
@Service
public class GameService implements GameRepository{

 

    @Autowired
    private GameRepository 
    gameRepository;
	
	@Override
	public List<Game> findAll() {
		// TODO Auto-generated method stub
        return (List<Game>) gameRepository.findAll();

	}
/*
	@Override
	public   Game save(Game entity) {
		// TODO Auto-generated method stub
		return gameRepository.save(entity);
	}
*/
	@Override
	public <S extends Game> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Game> findById(Integer id) {
		// TODO Auto-generated method stub
		 
		return Optional.of(gameRepository.findById(id).orElse(null));
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Game> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		gameRepository.deleteById(id);
	}

	@Override
	public void delete(Game entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Game> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <S extends Game> S save(S Game) {
		// TODO Auto-generated method stub
		return gameRepository.save(Game);
		//return null;
	}

 




}
