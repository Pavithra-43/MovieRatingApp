package com.cg.movie.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieDto {

		private Integer movieId;

		@NotNull (message = "Movie name cannot be null ")
		@NotBlank(message = "Movie name cannot be blank")
		private String movieName;
		private String language;
		@Min(value = 1990, message = "Release year should be after 1990")
		@Max(value = 2023, message = "Release year should be before 2023")
		private Integer releaseYear;
		private String genre;
		private String director;
		private Double rating;
		
	}
