package com.infogain.clients;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.infogain.dto.MovieDTO;
import com.infogain.request.CreateMovieRequest;

//@FeignClient(value = "movieclient", url = "http://localhost:9090/movie")
@FeignClient(name = "MOVIE-SERVICE")
public interface MovieClient {
	
	@PostMapping("/movie/")
	MovieDTO createMovie(@RequestBody @Valid CreateMovieRequest request);

	 @GetMapping("/movie/")
	 List<MovieDTO> getAllMovies();
	 
	 @GetMapping("/movie/{movieId}")
	 MovieDTO getMovieById(@PathVariable Integer movieId);
	 
	 @GetMapping("/movie/list")
	 List<MovieDTO> getMoviesById(@RequestParam List<Integer> ids);
}
