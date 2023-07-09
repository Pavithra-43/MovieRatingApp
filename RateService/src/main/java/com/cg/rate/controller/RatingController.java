package com.cg.rate.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rate.dto.RateDto;
import com.cg.rate.service.RateService;

@RestController
@RequestMapping("/rate")
public class RatingController {
	
	@Autowired
	RateService rateService;
	
	@PostMapping("/rateMovie")
	public ResponseEntity<RateDto> rateMovie(@RequestBody @Valid RateDto rateDto){
		return new ResponseEntity<RateDto>(rateService.rateMovie(rateDto),HttpStatus.OK);
		
	}
	
	@PutMapping("/updateRate")
	public ResponseEntity<RateDto> updateRate(@RequestBody @Valid RateDto rateDto){
		return new ResponseEntity<RateDto>(rateService.updateRate(rateDto),HttpStatus.OK);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<RateDto>> getAllRatings(){
		return new ResponseEntity<List<RateDto>>(rateService.getAllRating(),HttpStatus.OK);
		
	}
	
	@GetMapping("/getRating/{movieName}")
	public ResponseEntity<Double> getRatingByMovieName(@PathVariable String movieName){
		return new ResponseEntity<Double>(rateService.getRatingByMovieName(movieName),HttpStatus.OK);
		
	}
	
	@GetMapping("/myMovies/{username}")
	public ResponseEntity<List<RateDto>> getAllMoviesRatedByUser(@PathVariable String username){
		return new ResponseEntity<List<RateDto>>(rateService.getAllMoviesRatedByUser(username),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{ratingId}")
	public ResponseEntity<String> removeRating(@PathVariable Integer ratingId){
		return new ResponseEntity<String>(rateService.removeRating(ratingId),HttpStatus.OK);
		
	}

}
