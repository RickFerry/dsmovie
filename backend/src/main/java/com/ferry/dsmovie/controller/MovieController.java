package com.ferry.dsmovie.controller;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferry.dsmovie.dto.MovieDTO;
import com.ferry.dsmovie.service.MovieService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/")
public class MovieController {

	private MovieService movieService;
	
	@GetMapping("/movies")
	public Page<MovieDTO> findAll(Pageable pageable) {
		return movieService.findAll(pageable);
	}
	
	@GetMapping("/movie/{id}")
	public MovieDTO findOne(@PathVariable Long id) throws NotFoundException {
		return movieService.findOne(id);
	}
}
