package com.infogain.request;

import javax.validation.constraints.NotNull;

public class FollowRequest {

	@NotNull(message = "followerId can not be null or empty")
	private Integer followerId;
	@NotNull(message = "followingUserId can not be null or empty")
	private Integer followingUserid;
	public Integer getFollowerId() {
		return followerId;
	}
	public void setFollowerId(Integer followerId) {
		this.followerId = followerId;
	}
	public Integer getFollowingUserid() {
		return followingUserid;
	}
	public void setFollowingUserid(Integer followingUserid) {
		this.followingUserid = followingUserid;
	}
	
	
}
