package com.cg.rate.service;

import java.util.List;

import com.cg.rate.dto.RateDto;

public interface RateService {
	
	RateDto rateMovie(RateDto rateDto);
	RateDto updateRate(RateDto rateDto);
	Double getRatingByMovieName(String movieName);
	List<RateDto> getAllRating();
	String removeRating(Integer rateId);
	List<RateDto> getAllMoviesRatedByUser(String username);

}
