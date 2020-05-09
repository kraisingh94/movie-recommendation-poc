package com.infogain.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieExceptionController {

	@ExceptionHandler(value = MovieNotFoundException.class)
	public ResponseEntity<Object> exception() {
		Map<String, Object> map = new HashMap<>();
		map.put("code", HttpStatus.NOT_FOUND.value());
		map.put("message", "Invalid movieId");
		 return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
	 }
}
