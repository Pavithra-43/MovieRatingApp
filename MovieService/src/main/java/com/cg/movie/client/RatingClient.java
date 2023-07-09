package com.cg.movie.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="http://localhost:8086/rate",name="RATE-CLIENT")
public interface RatingClient {

	@GetMapping("/getRating/{movieName}")
	public Double getRating(@PathVariable String movieName);
	
}
