package com.cg.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.user.dto.AuthRequest;
import com.cg.user.dto.UserDto;
import com.cg.user.service.IUserService;
import com.cg.user.util.JwtService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	IUserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> signUp(@RequestBody @Valid UserDto userDto){
		return new ResponseEntity<UserDto>(userService.signUp(userDto),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<UserDto> updateUser(@RequestBody @Valid UserDto userDto){
		return new ResponseEntity<UserDto>(userService.update(userDto),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<List<UserDto>> getAllUser(){
		return new ResponseEntity<List<UserDto>>(userService.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/username/{username}")
	public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username){
		return new ResponseEntity<UserDto>(userService.getUserByUserName(username),HttpStatus.OK);
	}
	
	@GetMapping("/id/{userId}")
	public ResponseEntity<UserDto> getUserByUserId(@PathVariable Integer userId){
		return new ResponseEntity<UserDto>(userService.getUserByUserId(userId),HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/id/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer userId){
		return new ResponseEntity<String>(userService.deleteUser(userId),HttpStatus.OK);
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<String> loginUser(@RequestBody AuthRequest authRequest){
		Authentication authentication=authManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if (authentication.isAuthenticated()) {
            return new ResponseEntity<String>(jwtService.generateToken(authRequest.getUsername()),HttpStatus.OK);
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
	}
	
	@GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        jwtService.validateToken(token);
        return "Token is valid";
    }
	
	

}
