package com.cg.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cg.user.dto.UserDto;
import com.cg.user.mapper.UserMapper;
import com.cg.user.repository.UserRepository;
import com.cg.user.service.IUserService;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository myUserService;

	@Autowired
	UserMapper mapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto userDto=mapper.entityToDto(myUserService.findByUsername(username));
		CustomUserDetails credentials=new CustomUserDetails(userDto);
		return credentials;
		
	}

}
