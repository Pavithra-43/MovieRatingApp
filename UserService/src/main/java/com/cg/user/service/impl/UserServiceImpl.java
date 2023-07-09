package com.cg.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.user.dto.UserDto;
import com.cg.user.entity.UserEntity;
import com.cg.user.exception.UserException;
import com.cg.user.mapper.UserMapper;
import com.cg.user.repository.UserRepository;
import com.cg.user.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDto signUp(UserDto userDto) {
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		userDto.setRoles("ROLE_USER");
		UserEntity resultEntity=userRepository.save(userMapper.dtoToEntity(userDto));
		if(resultEntity==null || resultEntity.getUserId()==null) {
			throw new UserException("Sign up error");
		}
		return userMapper.entityToDto(resultEntity);
	}

	@Override
	public UserDto update(UserDto userDto) {
		UserEntity entity;
		entity=userRepository.findById(userDto.getUserId()).get();
		if(entity==null || entity.getUserId()==null) {
			throw new UserException("User not found, please sign up!!");
		}
		entity=userRepository.save(userMapper.dtoToEntity(userDto));
		return userMapper.entityToDto(entity);
		
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<UserDto> result=userMapper.listOfEntityToDto(userRepository.findAll());
		if(result==null || result.isEmpty()) {
			throw new UserException("Users not found");
		}
		return result;
			
	}

	@Override
	public UserDto getUserByUserName(String username) {
		UserDto result=userMapper.entityToDto(userRepository.findByUsername(username));
		if(result==null || result.getUserId()==null) {
			throw new UserException("Users not found for given username: "+username);
		}
		return result;
	}

	@Override
	public String deleteUser(Integer userId) {
		UserEntity entity;
		entity=userRepository.findById(userId).get();
		if(entity==null || entity.getUserId()==null) {
			throw new UserException("Users not found for given user id: "+userId);
		}
		userRepository.deleteById(entity.getUserId());
		
		return "User details deleted successfully!!";
		
	}

	@Override
	public UserDto getUserByUserId(Integer userId) {
		UserDto result=userMapper.entityToDto(userRepository.findById(userId).get());
		if(result==null || result.getUserId()==null) {
			throw new UserException("Users not found for given user id: "+userId);
		}
		return result;
	}

}
