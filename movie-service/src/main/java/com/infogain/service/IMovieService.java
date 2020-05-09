package com.infogain.service;

import java.util.Collection;
import java.util.List;

import com.infogain.dto.MovieDTO;

public interface IMovieService {

	MovieDTO createMovie(MovieDTO movieDto);
	
	Collection<MovieDTO> getAllMovies();
	
	Collection<MovieDTO> getMoviesById(List<Long> ids);
	
	MovieDTO findMovieById(Long movieId);
	
	void insertDummyData();
}
