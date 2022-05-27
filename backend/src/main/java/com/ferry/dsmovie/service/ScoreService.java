package com.ferry.dsmovie.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.ferry.dsmovie.dto.MovieDTO;
import com.ferry.dsmovie.dto.ScoreDTO;
import com.ferry.dsmovie.model.Movie;
import com.ferry.dsmovie.model.Score;
import com.ferry.dsmovie.model.User;
import com.ferry.dsmovie.repository.MovieRepository;
import com.ferry.dsmovie.repository.ScoreRepository;
import com.ferry.dsmovie.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ScoreService {

	private MovieRepository movieRepository;
	private UserRepository userRepository;
	private ScoreRepository scoreRepository;

	private ModelMapper modelMapper;

	@Transactional
	public MovieDTO saveScore(ScoreDTO form) throws NotFoundException {

		User user = userRepository.findByEmail(form.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(form.getEmail());
			user = userRepository.saveAndFlush(user);
		}

		Movie movie = movieRepository.findById(form.getMovieId())
				.orElseThrow(NotFoundException::new);

		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(form.getScore());
		scoreRepository.saveAndFlush(score);

		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}
		double avg = sum / movie.getScores().size();

		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		movie = movieRepository.save(movie);

		return modelMapper.map(movie, MovieDTO.class);
	}
}
