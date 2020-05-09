package com.infogain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recommend_metadata")
public class RecommendEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "movie_id")
	private Integer movieId;
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "is_movie_liked")
	private Boolean isLiked;
	@Column(name = "is_movie_disliked")
	private Boolean isDisliked;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Boolean getIsLiked() {
		return isLiked;
	}

	public void setIsLiked(Boolean isLiked) {
		this.isLiked = isLiked;
	}

	public Boolean getIsDisliked() {
		return isDisliked;
	}

	public void setIsDisliked(Boolean isDisliked) {
		this.isDisliked = isDisliked;
	}

}
