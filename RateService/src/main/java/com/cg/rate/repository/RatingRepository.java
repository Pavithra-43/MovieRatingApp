package com.cg.rate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.rate.entity.RateEntity;

@Repository
public interface RatingRepository extends JpaRepository<RateEntity, Integer>{
	
	List<RateEntity> findByMovieNameIgnoreCase(String movieName);
	List<RateEntity> findByUsernameIgnoreCase(String username);
    RateEntity findByUsernameAndMovieName(String movieName, String username);
}
