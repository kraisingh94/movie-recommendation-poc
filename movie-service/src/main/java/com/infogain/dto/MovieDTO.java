package com.infogain.dto;

import javax.validation.constraints.NotBlank;

import com.infogain.entity.MovieEntity;

public class MovieDTO {
    
    private Long movieId;
    @NotBlank
    private String name;

    public MovieDTO() {
    }
    
    public MovieDTO(MovieEntity movie){
        this.movieId = movie.getId();
        this.name = movie.getName();
    }
    
    public Long getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
