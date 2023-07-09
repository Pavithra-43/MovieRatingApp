package com.cg.rate.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cg.rate.dto.RateDto;
import com.cg.rate.entity.RateEntity;

@Mapper(componentModel = "spring")
public interface RatingMapper {
	
	RatingMapper INSTANCE=Mappers.getMapper(RatingMapper.class);
	
	RateDto entityToDto(RateEntity rateEntity);
	RateEntity dtoToEntity(RateDto rateDto);
	List<RateDto> listEntityToDto(List<RateEntity> list);
	
	

}
