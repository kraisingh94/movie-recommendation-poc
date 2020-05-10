package com.infogain.request;

import javax.validation.constraints.NotNull;

public class LikeRequest {

	@NotNull(message = "movieId can not be null or empty")
	private Long movieId;
	@NotNull(message = "userId can not be null or empty")
	private Long userId;
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
