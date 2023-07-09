package com.cg.rate.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class RateDto {
	
	
	private Integer ratingId;
	@NotBlank(message = "movie cannot be blank")
	@NotNull(message = "movie cannot be null")
	private String movieName;
	
	@NotBlank(message = "username cannot be blank")
	@NotNull(message = "username cannot be null")
	private String username;
	
	@NotBlank(message = "rating cannot be blank")
	@NotNull(message = "rating cannot be null")
	private Double rating;

}
