package com.infogain.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.clients.MovieClient;
import com.infogain.clients.RecommendationClient;
import com.infogain.clients.UserClient;
import com.infogain.dto.MovieDTO;
import com.infogain.dto.RecommendationDTO;
import com.infogain.dto.UserDTO;


@Service
public class RecommendationClientService {
    
    private static final Logger LOGGER = Logger.getLogger(RecommendationClientService.class.getName());
      
    @Autowired
    private UserClient userClient;
    
    @Autowired
    private MovieClient movieClient;
    
    @Autowired
    private RecommendationClient recommendationClient;
    
    public UserDTO getUserInfo(Long userId){
        return userClient.getUserById(userId);
    } 
    
    public CompletableFuture<UserDTO> getUserDetails(Long userId) {
        CompletableFuture<UserDTO> future = CompletableFuture.supplyAsync(()->{
                UserDTO user = userClient.getUserById(userId);
                return user;
        });
        return future;
    }

    public CompletableFuture<RecommendationDTO> getRecommendationData(Long userId){
        LOGGER.info("Requesting recommendation for user with id: " + userId.toString());
        List<MovieDTO> recommendedMovies = 
        		recommendationClient.getRecommendedMovies(userId);
        
        RecommendationDTO data = new RecommendationDTO();

        List<Long> ids = recommendedMovies.stream().map(MovieDTO::getMovieId).collect(Collectors.toList());
        LOGGER.info("movieIds : " + ids);
        CompletableFuture<RecommendationDTO> test = getUserDetails(userId).thenCombine(getMovies(ids), (user, movies)->{
            data.setUser(user);
            movies.stream().forEach((recommendation) -> {
                String name =  recommendation.getName();
                Long movieId = recommendation.getMovieId();
                Integer likes = recommendedMovies
                        .stream()
                        .filter(movie-> movie.getMovieId().intValue() == movieId.intValue())
                        .findFirst()
                        .get()
                        .getLikes();
                data.getMovies().add(new MovieDTO(movieId, name, likes));
            });
            return data;
        });
        return test;
    }
    
    public CompletableFuture<Collection<MovieDTO>> getMovies(List<Long> ids){
        LOGGER.info("Looking for movies with ids: " + ids.toString());
        CompletableFuture<Collection<MovieDTO>> future = CompletableFuture.supplyAsync(()->{
                     List<MovieDTO> movies = 
                        movieClient.getMoviesById(ids);
             return movies;
        });
        return future;
    };
    
    public List<MovieDTO> recoveryRecommendation(){
        List<MovieDTO> movies = new ArrayList<>();
        movies.add(new MovieDTO(10L, "The Lord of the Rings: The Fellowship of the Ring"));
        movies.add(new MovieDTO(14L, "One Flew Over the Cuckoo's Nest"));
        movies.add(new MovieDTO(4L, "12 Angry Men"));
        movies.add(new MovieDTO(9L, "Fight Club"));
        movies.add(new MovieDTO(6L, "Pulp Fiction"));
        return movies;
    }
    
    
}
