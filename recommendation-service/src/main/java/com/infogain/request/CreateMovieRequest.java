package com.infogain.request;

import javax.validation.constraints.NotBlank;

public class CreateMovieRequest {

	@NotBlank
	private String name;
}
