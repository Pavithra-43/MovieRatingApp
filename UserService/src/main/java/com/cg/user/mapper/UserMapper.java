package com.cg.user.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cg.user.dto.UserDto;
import com.cg.user.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserMapper INSTANCE=Mappers.getMapper(UserMapper.class);
	
	public UserEntity dtoToEntity(UserDto userDto);
	
	public UserDto entityToDto(UserEntity userEntity);
	
	public List<UserDto> listOfEntityToDto(List<UserEntity> list);
	
	public List<UserEntity> listOfDtoToEntity(List<UserDto> list);

}
