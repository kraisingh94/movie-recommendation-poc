package com.infogain.dto;

public class MovieDTO {
    
    private Integer movieId;
    private String name;
    private Long likes;
    
    public MovieDTO(Integer movieId, Long likes) {
		this.movieId = movieId;
		this.likes = likes;
	}

	public Integer getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public void setName(String name) {
        this.name = name;
    }

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}
    
}
