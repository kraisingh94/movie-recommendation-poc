package com.infogain.request;

import javax.validation.constraints.NotNull;

public class FollowRequest {

	@NotNull(message = "followerId can not be null or empty")
	private Long followerId;
	@NotNull(message = "followingUserId can not be null or empty")
	private Long followingUserid;
	public Long getFollowerId() {
		return followerId;
	}
	public void setFollowerId(Long followerId) {
		this.followerId = followerId;
	}
	public Long getFollowingUserid() {
		return followingUserid;
	}
	public void setFollowingUserid(Long followingUserid) {
		this.followingUserid = followingUserid;
	}
	
	
}
