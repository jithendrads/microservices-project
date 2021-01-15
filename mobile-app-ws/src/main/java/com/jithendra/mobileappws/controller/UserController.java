package com.jithendra.mobileappws.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jithendra.mobileappws.model.User;
import com.jithendra.mobileappws.model.UserDetailsRequestModel;

@RestController
@RequestMapping("/users")
public class UserController {
	@GetMapping()
	public String getUser(@RequestParam(value="page", defaultValue="1") int page,@RequestParam(value="limit", defaultValue="50") int limit )
	{
		return "get user was called with page = "+page+" and limit "+limit;
	}
	
	@GetMapping(path="/{userId}", produces= { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<User> getUser(@PathVariable int userId)
	{
		User user=new User();
		user.setEmail("abc@gmail.com");
		user.setFirstName("jithu");
		user.setLastName("endra");
		user.setUserId("1");
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	@PostMapping(
		consumes= 
			{ MediaType.APPLICATION_XML_VALUE,
			  MediaType.APPLICATION_JSON_VALUE
			},
		produces= 
			{ MediaType.APPLICATION_XML_VALUE,
			  MediaType.APPLICATION_JSON_VALUE
			})
	public ResponseEntity<User> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails)
	{
		User user=new User();
		user.setEmail(userDetails.getEmail());
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@PutMapping
	public String updateUser()
	{
		return "update user was called";
	}
	
	@DeleteMapping
	public String deleteUser()
	{
		return "delete user was called";
	}

}
