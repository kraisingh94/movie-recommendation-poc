package com.infogain.dto;

public class RecommendedMovieDTO {
    
    private Integer id;
    private Integer likes;

    public RecommendedMovieDTO() {
    }

    public RecommendedMovieDTO(Integer id, Integer likes) {
        this.id = id;
        this.likes = likes;
    }

    public Integer getId() {
        return id;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
    
}
