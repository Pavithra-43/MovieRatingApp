package com.cg.rate.dto;


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
public class Movie {

		private Integer movieId;
		private String movieName;
		private String language;
		private Integer releaseYear;
		private String genre;
		private String director;
		private Double rating;
		
	}
