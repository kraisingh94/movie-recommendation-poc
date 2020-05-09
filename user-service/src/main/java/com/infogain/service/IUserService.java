package com.infogain.service;

import java.util.List;

import com.infogain.dto.UserDTO;

public interface IUserService {

	UserDTO createUser(UserDTO userDto);
	
	List<UserDTO> getAllUsers();
	
	UserDTO getUser(Long userId);
}
