/**
 * 
 */
package com.nec.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Kunwar.Dheerendra
 *
 */
@RestController
@RequestMapping(value = "/v1/")
public class Home {

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Details fetched successfully.", response = Void.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 401, message = "401 Unauthorized", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found", response = Void.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
	@GetMapping(value = "first")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> first() {
		System.out.println("Request at: " + System.currentTimeMillis());
		return new ResponseEntity<String>("Test applicaiton. Method: 1", HttpStatus.OK);
	}

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "details fetched successfully.", response = Void.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 401, message = "401 Unauthorized", response = Void.class),
			@ApiResponse(code = 404, message = "Not Found", response = Void.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
	@GetMapping(value = "second")
	@ResponseStatus(HttpStatus.OK)

	public ResponseEntity<String> second() {
		System.out.println("Request at: " + System.currentTimeMillis());
		return new ResponseEntity<String>("Test applicaiton. Method: 2", HttpStatus.OK);
	}
}
