package com.cg.rate.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.rate.dto.Movie;

@FeignClient(url="http://localhost:8088/movie",name="MOVIE-CLIENT")
public interface MovieClient {
	
	@PutMapping("/Update")
	Movie updateMovie(@RequestBody Movie movie);
	
	@GetMapping("/getName/{movieName}")
	Movie getMovie(@PathVariable String movieName);
	

}
