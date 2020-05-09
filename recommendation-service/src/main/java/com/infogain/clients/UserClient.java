package com.infogain.clients;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.infogain.dto.UserDTO;
import com.infogain.request.CreateUserRequest;

//@FeignClient(value = "userclient", url = "http://localhost:9091/user")
@FeignClient(name = "USER-SERVICE")
public interface UserClient {

	@PostMapping("/user/")
	UserDTO createUser(@RequestBody @Valid CreateUserRequest request);

	@GetMapping("/user/")
	public List<UserDTO> getAllUsers();

	@GetMapping("/newuser")
	void createUser();

	@GetMapping("/user/{userId}")
	UserDTO getUser(@PathVariable(name = "userId") Long userId);
}
