package com.ferry.dsmovie.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ferry.dsmovie.dto.MovieDTO;
import com.ferry.dsmovie.model.Movie;
import com.ferry.dsmovie.repository.MovieRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MovieService {

	private MovieRepository movieRepository;

	private ModelMapper modelMapper;

	@Transactional
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> result = movieRepository.findAll(pageable);
		return result.map(x -> modelMapper.map(x, MovieDTO.class));
	}
	
	@Transactional
	public MovieDTO findOne(Long id) throws NotFoundException {
		Movie movie = movieRepository.findById(id).orElseThrow(
				NotFoundException::new);
		return modelMapper.map(movie, MovieDTO.class);
	}
}
