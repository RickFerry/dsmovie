package com.ferry.dsmovie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieDTO {

	private Long id;
	private String title;
	private Double score;
	private Integer count;
	private String image;

}
