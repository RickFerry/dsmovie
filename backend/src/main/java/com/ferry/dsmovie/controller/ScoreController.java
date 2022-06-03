package com.ferry.dsmovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferry.dsmovie.dto.MovieDTO;
import com.ferry.dsmovie.dto.ScoreDTO;
import com.ferry.dsmovie.service.ScoreService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/scores")
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;

	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO form) throws NotFoundException {
		return scoreService.saveScore(form);
	}
}
