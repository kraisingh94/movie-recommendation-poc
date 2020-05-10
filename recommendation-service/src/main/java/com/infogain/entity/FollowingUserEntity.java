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
	private Long userId;
	@Id
	@Column(name = "following_user_id")
	private Long followingUserId;
	
	public FollowingUserEntity() {}
	
	public FollowingUserEntity(Long userId, Long followingUserId) {
		this.userId = userId;
		this.followingUserId = followingUserId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getFollowingUserId() {
		return followingUserId;
	}
	public void setFollowingUserId(Long followingUserId) {
		this.followingUserId = followingUserId;
	}
	
	

}
