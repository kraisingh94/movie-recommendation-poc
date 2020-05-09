package com.infogain.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.dto.MovieDTO;
import com.infogain.entity.MovieEntity;
import com.infogain.exception.MovieNotFoundException;
import com.infogain.repository.MovieRepository;

@Service
public class MovieServiceImpl implements IMovieService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public MovieDTO createMovie(MovieDTO movieDto) {
		MovieEntity movieEntity = new MovieEntity(movieDto.getName());
    	movieEntity = movieRepository.saveAndFlush(movieEntity);
    	movieDto.setMovieId(movieEntity.getId());
    	return movieDto;
	}

	@Override
	public Collection<MovieDTO> getAllMovies() {
		 return this.movieRepository.findAll()
	                .stream()
	                .map(MovieEntity::toDTO)
	                .collect(Collectors.toList());
	}

	@Override
	public Collection<MovieDTO> getMoviesById(List<Long> ids) {
		List<MovieDTO> retVal = new ArrayList<>();
        ids.stream()
                .forEach(id -> {
                	Optional<MovieEntity> movieEntityOpt = this.movieRepository.findById(id);
                	if(!movieEntityOpt.isPresent()) {
                		throw new MovieNotFoundException();
                	}
                	MovieDTO dto = new MovieDTO(this.movieRepository.getOne(id.longValue()));
                    retVal.add(dto);
                });
        return retVal;
	}

	@Override
	public MovieDTO findMovieById(Long movieId) {
		 Optional<MovieEntity> movieEntityOpt = movieRepository.findById(movieId);
	        if(!movieEntityOpt.isPresent()) {
	        	throw new MovieNotFoundException();
	        }
	        return new MovieDTO(movieEntityOpt.get());
	}
	

	@Override
	public void insertDummyData() {
		LOGGER.info("DUMMY DATA INSERTION");
        movieRepository.deleteAll();
        List<MovieEntity> movieList = new ArrayList<>();
        movieList.add(new MovieEntity("The Shawshank Redemption"));
        movieList.add(new MovieEntity("The Godfather"));
        movieList.add(new MovieEntity("The Dark Knight"));
        movieList.add(new MovieEntity("12 Angry Men"));
        movieList.add(new MovieEntity("Schindler's List"));
        movieList.add(new MovieEntity("Pulp Fiction"));
        movieList.add(new MovieEntity("Old boy"));
        movieRepository.saveAll(movieList);
	}

}
