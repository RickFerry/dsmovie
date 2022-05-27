package com.ferry.dsmovie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScoreDTO {

	private Long movieId;
	private String email;
	private Double score;
	
	public ScoreDTO() {}
}
