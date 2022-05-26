package com.ferry.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferry.dsmovie.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
