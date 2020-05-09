package com.infogain.entity;

import java.io.Serializable;

public class FollowingUserId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private Integer followingUserId;
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
