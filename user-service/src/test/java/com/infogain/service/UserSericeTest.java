package com.infogain.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.infogain.dto.UserDTO;
import com.infogain.entity.UserEntity;
import com.infogain.exception.UserNotFoundException;
import com.infogain.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserSericeTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImpl userService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

	}

	private UserDTO dummyUserDto() {
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail("abc@gmail.com");
		userDTO.setMobileNo(8439023834L);
		userDTO.setName("Ravi Singh");
		userDTO.setPassword("abc@123");
		return userDTO;
	}

	private List<UserEntity> getUserList() {
		List<UserEntity> movieList = new ArrayList<>();
		movieList.add(userEntity());
		return movieList;
	}

	private UserEntity userEntity() {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(1001L);
		userEntity.setEmail("abc@gmail.com");
		userEntity.setMobileNo(8439023834L);
		userEntity.setName("Ravi Singh");
		userEntity.setPassword("abc@123");
		return userEntity;
	}

	@Test
	public void testCreateUser() {
		UserEntity userEntity = userEntity();
		Mockito.when(userRepository.saveAndFlush(ArgumentMatchers.any(UserEntity.class))).thenReturn(userEntity);
		UserDTO userDTO = userService.createUser(dummyUserDto());
		assertEquals(Long.valueOf(userDTO.getId()), Long.valueOf(userEntity.getId()));
	}
	
	@Test
	public void testGetAllUsers() {
		Mockito.when(userRepository.findAll()).thenReturn(getUserList());
		Collection<UserDTO> movieList = userService.getAllUsers();
		assertEquals(movieList.size(), getUserList().size());
	}

	@Test
	public void testGetUser() {
		Optional<UserEntity> userEntityOpt = Optional.of(userEntity());
		Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(userEntityOpt);
		UserDTO userDTO = userService.getUser(Mockito.anyLong());
		assertNotNull(userDTO);
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testGetUserThrowsUserNotFoundException() {
		Optional<UserEntity> movieEntityOpt = Optional.empty();
		Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(movieEntityOpt);
		userService.getUser(Mockito.anyLong());
	}

}

