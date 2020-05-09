package com.infogain.dto;

import java.util.ArrayList;
import java.util.List;

public class RecommendationDTO {
    
    private UserDTO user;
    private List<MovieDTO> movies;

    public RecommendationDTO() {
        this.movies = new ArrayList<>();
    }

    public RecommendationDTO(UserDTO user, List<MovieDTO> movies) {
        this.user = user;
        this.movies = movies;
    }

    public List<MovieDTO> getMovies() {
        return movies;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setMovies(List<MovieDTO> movies) {
        this.movies = movies;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
    
}
