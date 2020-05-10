package com.infogain.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.infogain.entity.FollowingUserEntity;
import com.infogain.entity.RecommendEntity;
import com.infogain.repository.FollowingRepository;
import com.infogain.repository.RecommendRepository;
import com.infogain.request.FollowRequest;
import com.infogain.request.LikeRequest;

@ExtendWith(MockitoExtension.class)
public class RecommendationServiceTest {

	@Mock
	private RecommendRepository recommendRepository;
	
	@Mock
	private FollowingRepository followingRepository;
	
	@InjectMocks
	private RecommendationServiceImpl recommendationService;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

	}
	
	private RecommendEntity recommentEntity() {
		RecommendEntity recommendEntity = new RecommendEntity();
		recommendEntity.setId(1);
		recommendEntity.setMovieId(101L);
		recommendEntity.setUserId(1001L);
		recommendEntity.setIsLiked(false);
		recommendEntity.setIsDisliked(true);
		return recommendEntity;
	}
	
	private FollowingUserEntity followEntity() {
		FollowingUserEntity followEntity = new FollowingUserEntity();
		followEntity.setFollowingUserId(1001L);
		followEntity.setUserId(1002L);
		return followEntity;
	}
	
	private LikeRequest likeRequest() {
		LikeRequest likeRequest = new LikeRequest();
		likeRequest.setMovieId(101L);
		likeRequest.setUserId(1001L);
		return likeRequest;
	}
	
	private FollowRequest followRequest() {
		FollowRequest followRequest = new FollowRequest();
		followRequest.setFollowingUserid(1001L);
		followRequest.setFollowerId(1002L);
		return followRequest;
	}
	
	@Test
	public void testUpdateUserLikedMovie_WithExistingData() {
		RecommendEntity recommendEntity = recommentEntity();
		Mockito.when(recommendRepository.findByUserIdAndMovieId(Mockito.anyLong(), Mockito.anyLong())).thenReturn(recommendEntity);
		recommendEntity.setIsLiked(true);
		recommendEntity.setIsDisliked(false);
		Mockito.when(recommendRepository.save(recommendEntity)).thenReturn(recommendEntity);
		recommendEntity = recommendationService.updateUserLikedMovie(likeRequest(), true);
		assertEquals(recommendEntity.getIsLiked(), new Boolean(true));
	}
	
	@Test
	public void testUpdateUserLikedMovie_WithNewData() {
		Mockito.when(recommendRepository.findByUserIdAndMovieId(Mockito.anyLong(), Mockito.anyLong())).thenReturn(null);
		RecommendEntity recommendEntity = recommentEntity();
		recommendEntity.setIsLiked(true);
		recommendEntity.setIsDisliked(false);
		Mockito.when(recommendRepository.save(Mockito.any(RecommendEntity.class))).thenReturn(recommendEntity);
		recommendEntity = recommendationService.updateUserLikedMovie(likeRequest(), false);
		assertEquals(recommendEntity.getIsLiked(), new Boolean(true));
	}
	
	@Test
	public void testUpdateFollowRequest() {
		Mockito.when(followingRepository.findByUserIdAndFollowingUserId(Mockito.anyLong(), Mockito.anyLong())).thenReturn(null);
		Mockito.when(followingRepository.saveAndFlush(Mockito.any(FollowingUserEntity.class))).thenReturn(followEntity());
		FollowingUserEntity userEntity = recommendationService.updateFollowRequest(followRequest());
		assertNotNull(userEntity);
	}
	
	@Test
	public void testUpdateUnfollowRequest() {
		Mockito.when(followingRepository.findByUserIdAndFollowingUserId(Mockito.anyLong(), Mockito.anyLong())).thenReturn(followEntity());
		boolean isUnfollowed = recommendationService.updateUnfollowRequest(followRequest());
		assertEquals(isUnfollowed, true);
	}
	
}
