package com.cg.rate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rate.client.MovieClient;
import com.cg.rate.dto.Movie;
import com.cg.rate.dto.RateDto;
import com.cg.rate.entity.RateEntity;
import com.cg.rate.exception.RatingException;
import com.cg.rate.mapper.RatingMapper;
import com.cg.rate.repository.RatingRepository;
import com.cg.rate.service.RateService;

@Service
public class RateServiceImpl implements RateService{
	
	@Autowired
	private MovieClient client;
	
	@Autowired
	RatingRepository ratingRepository;
	
	@Autowired
	RatingMapper ratingMapper;
	

	@Override
	public RateDto rateMovie(RateDto rateDto) {
		RateEntity entity=ratingRepository.save(ratingMapper.dtoToEntity(rateDto));
		RateDto result=ratingMapper.entityToDto(entity);
		if(result == null || result.getRatingId()==null) {
			throw new RatingException("Rating Failed!!");
		}
		return result;
	}

	@Override
	public RateDto updateRate(RateDto rateDto) {
		RateEntity entity=ratingRepository.findByUsernameAndMovieName(rateDto.getUsername(), rateDto.getMovieName());
		if(entity !=null && entity.getRatingId() != null) {
			rateDto.setRatingId(entity.getRatingId());
		}
		entity=ratingRepository.save(ratingMapper.dtoToEntity(rateDto));
		
		Movie movie=client.getMovie(rateDto.getMovieName());
        System.out.println(movie.toString());
        
		movie.setRating(getRatingByMovieName(rateDto.getMovieName()));
		
		movie=client.updateMovie(movie);
		System.out.println(movie);
		
		
		if(entity==null || entity.getRating()==null) {
			throw new RatingException("Update failed!!");
		}
		return ratingMapper.entityToDto(entity);
	}

	@Override
	public Double getRatingByMovieName(String movieName) {
		List<RateDto> result=ratingMapper.listEntityToDto(ratingRepository.findByMovieNameIgnoreCase(movieName));
		if(result==null || result.isEmpty()) {
			throw new RatingException("No one rated this movie yet");
		}
		Double totalRate=result.stream().mapToDouble(i->i.getRating()).sum();
		Long noOfPeopleRated=result.stream().mapToDouble(i->i.getRating()).count();
		return totalRate/noOfPeopleRated;
	}

	@Override
	public List<RateDto> getAllRating() {
		List<RateDto> result=ratingMapper.listEntityToDto(ratingRepository.findAll());
		if(result==null || result.isEmpty()) {
			throw new RatingException("No rating details found");
		}
		return result;
	}

	@Override
	public String removeRating(Integer rateId) {
		RateEntity entity=ratingRepository.findById(rateId).get();
		if(entity==null || entity.getRatingId()==null) {
			throw new RatingException("No rating details found for given rating id: "+rateId);
		}
		ratingRepository.delete(entity);
		return "Rating details removed from the database";
	}

	@Override
	public List<RateDto> getAllMoviesRatedByUser(String username) {
		List<RateDto> result=ratingMapper.listEntityToDto(ratingRepository.findByUsernameIgnoreCase(username));
		if(result==null || result.isEmpty()) {
			throw new RatingException("No rating details found for given username: "+username);
		}
		return result;
	}

}
