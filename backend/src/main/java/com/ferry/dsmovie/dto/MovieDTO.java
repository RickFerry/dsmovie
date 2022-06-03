package com.ferry.dsmovie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

	private Long id;
	private String title;
	private Double score;
	private Integer count;
	private String image;

}
