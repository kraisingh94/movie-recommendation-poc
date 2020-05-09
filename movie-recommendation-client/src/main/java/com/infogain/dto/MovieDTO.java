package com.infogain.dto;

public class MovieDTO {
    
    private Long movieId;
    
    private String name;
    
    private Integer likes;

    public MovieDTO() {
    }

    public MovieDTO(Long movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }

    public MovieDTO(Long movieId, String name, Integer likes) {
        this.movieId = movieId;
        this.name = name;
        this.likes = likes;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
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
