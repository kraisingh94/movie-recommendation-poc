package com.infogain.service;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.infogain.request.FollowRequest;
import com.infogain.request.LikeRequest;

@FeignClient("recommendation-service")
public interface RecommendationService {
    
    @PostMapping("/recommendation/like")
    Object likeAnyMovie(@RequestBody @Valid LikeRequest request);
    
    @PostMapping("/recommendation/unlike")
    Object unlikeAnyMovie(@RequestBody @Valid LikeRequest request);
    
    @PostMapping("/recommendation/follow")
    Object followAnyUser(@RequestBody @Valid FollowRequest request);
    
    @PostMapping("/recommendation/unfollow")
    Object unfollowAnyUser(@RequestBody @Valid FollowRequest request);
    
}
