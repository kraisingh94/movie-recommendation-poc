package com.infogain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "follow_metadata")
@IdClass(FollowingUserId.class)
public class FollowingUserEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "user_id")
	private Integer userId;
	@Id
	@Column(name = "following_user_id")
	private Integer followingUserId;
	
	public FollowingUserEntity() {}
	
	public FollowingUserEntity(Integer userId, Integer followingUserId) {
		super();
		this.userId = userId;
		this.followingUserId = followingUserId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getFollowingUserId() {
		return followingUserId;
	}
	public void setFollowingUserId(Integer followingUserId) {
		this.followingUserId = followingUserId;
	}
	
	

}
