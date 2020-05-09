package com.infogain.service;

import java.util.List;

import com.infogain.dto.MovieDTO;
import com.infogain.entity.FollowingUserEntity;
import com.infogain.entity.RecommendEntity;
import com.infogain.request.FollowRequest;
import com.infogain.request.LikeRequest;

public interface IRecommendService {

	RecommendEntity updateUserLikedMovie(LikeRequest request, boolean isLiked);
	
	FollowingUserEntity updateFollowRequest(FollowRequest request);

	boolean updateUnfollowRequest(FollowRequest request);
	
	List<MovieDTO> getRecommendationForUser(Integer userId);
}
