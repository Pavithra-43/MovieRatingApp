package com.cg.rate.entity;

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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RateEntity {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer ratingId;
		@Column(nullable = false)
		private String movieName;
		@Column(nullable = false)
		private String username;
		@Column(nullable = false)
		private Double rating;


}
