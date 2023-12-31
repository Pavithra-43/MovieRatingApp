package com.cg.movie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.movie.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {


	public Movie findByMovieName(String movieName);

	public List<Movie> findByDirectorName(String directorName);


}
