package com.ferry.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferry.dsmovie.model.Score;
import com.ferry.dsmovie.model.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
