package com.cg.user.service;

import java.util.List;

import com.cg.user.dto.UserDto;

public interface IUserService {
	
	UserDto signUp(UserDto userDto);
	
	UserDto update(UserDto userDto);
	
	List<UserDto> getAllUsers();
	
	UserDto getUserByUserName(String username);
	
	UserDto getUserByUserId(Integer userId);
	
	String deleteUser(Integer userId);
	

}
