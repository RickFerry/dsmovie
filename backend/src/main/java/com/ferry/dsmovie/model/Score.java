package com.ferry.dsmovie.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_score")
public class Score {

	@EmbeddedId
	private ScorePK id = new ScorePK();

	private Double value;

	public void setMovie(Movie movie) {
		id.setMovie(movie);
	}

	public void setUser(User user) {
		id.setUser(user);
	}
}
