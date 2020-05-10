package com.infogain.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.infogain.dto.MovieDTO;
import com.infogain.entity.MovieEntity;
import com.infogain.exception.MovieNotFoundException;
import com.infogain.repository.MovieRepository;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

	@Mock
	private MovieRepository movieRepository;

	@InjectMocks
	private MovieServiceImpl movieService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

	}

	private MovieDTO dummyMovieDto() {
		MovieDTO movieDTO = new MovieDTO();
		movieDTO.setMovieId(101L);
		movieDTO.setName("KGF-2");
		return movieDTO;
	}

	private List<MovieEntity> getMovieList() {
		List<MovieEntity> movieList = new ArrayList<>();
		movieList.add(movieEntity());
		return movieList;
	}

	private MovieEntity movieEntity() {
		MovieEntity movieEntity = new MovieEntity();
		movieEntity.setId(101L);
		movieEntity.setName("KGF-2");
		return movieEntity;
	}

	@Test
	public void testCreateMovie() {
		Mockito.when(movieRepository.saveAndFlush(ArgumentMatchers.any(MovieEntity.class))).thenReturn(movieEntity());
		MovieDTO movieDTO = movieService.createMovie(dummyMovieDto());
		assertEquals(Long.valueOf(movieDTO.getMovieId()), Long.valueOf(101L));
	}
	
	@Test
	public void testGetAllMovies() {
		Mockito.when(movieRepository.findAll()).thenReturn(getMovieList());
		Collection<MovieDTO> movieList = movieService.getAllMovies();
		assertEquals(movieList.size(), getMovieList().size());
	}

	@Test
	public void testGetMoviesById() {
		List<Long> ids = new ArrayList<>();
		ids.add(101L);
		Optional<MovieEntity> movieEntityOpt = Optional.of(movieEntity());
		Mockito.when(movieRepository.findById(Mockito.anyLong())).thenReturn(movieEntityOpt);
		Mockito.when(this.movieRepository.getOne(Mockito.anyLong())).thenReturn(movieEntity());
		Collection<MovieDTO> movieList = movieService.getMoviesById(ids);
		assertEquals(movieList.size(), ids.size());
	}
	
	@Test(expected = MovieNotFoundException.class)
	public void testGetMoviesByIdThrowsMovieNotFoundException() {
		List<Long> ids = new ArrayList<>();
		ids.add(101L);
		Optional<MovieEntity> movieEntityOpt = Optional.empty();
		Mockito.when(movieRepository.findById(Mockito.anyLong())).thenReturn(movieEntityOpt);
		Mockito.when(this.movieRepository.getOne(Mockito.anyLong())).thenReturn(movieEntity());
		movieService.getMoviesById(ids);
	}

	@Test
	public void testFindMovieById() {
		Optional<MovieEntity> movieEntityOpt = Optional.of(movieEntity());
		Mockito.when(movieRepository.findById(Mockito.anyLong())).thenReturn(movieEntityOpt);
		MovieDTO movieDTO = movieService.findMovieById(101L);
		assertEquals(Long.valueOf(movieEntity().getId()), Long.valueOf(movieDTO.getMovieId()));
	}

}
