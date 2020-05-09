package com.infogain.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.infogain.dto.MovieDTO;
import com.infogain.fallbacks.RecommendationClientHystrixFallback;

@FeignClient(name = "MOVIE-RECOMMENDATION-SERVICE", fallback = RecommendationClientHystrixFallback.class)
public interface RecommendationClient {

	@GetMapping("/recommend/recommendation/{userId}")
	List<MovieDTO> getRecommendedMovies(@PathVariable Long userId);
}
