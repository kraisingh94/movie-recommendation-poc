package com.infogain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infogain.entity.FollowingUserEntity;


@Repository
public interface FollowingRepository extends JpaRepository<FollowingUserEntity, Serializable>{

	FollowingUserEntity findByUserIdAndFollowingUserId(Integer userId, Integer followingUserId);
	
	List<FollowingUserEntity> findByUserId(Integer userId);
	
}
