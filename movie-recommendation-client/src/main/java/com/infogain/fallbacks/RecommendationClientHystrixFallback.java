package com.infogain.fallbacks;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.infogain.clients.RecommendationClient;
import com.infogain.dto.MovieDTO;

@Component
public class RecommendationClientHystrixFallback implements RecommendationClient{

	@Override
	public List<MovieDTO> getRecommendedMovies(Long userId) {
		List<MovieDTO> movies = new ArrayList<>();
        movies.add(new MovieDTO(10L, "The Lord of the Rings: The Fellowship of the Ring"));
        movies.add(new MovieDTO(14L, "One Flew Over the Cuckoo's Nest"));
        movies.add(new MovieDTO(4L, "12 Angry Men"));
        movies.add(new MovieDTO(9L, "Fight Club"));
        movies.add(new MovieDTO(6L, "Pulp Fiction"));
        return movies;
	}

	
}
