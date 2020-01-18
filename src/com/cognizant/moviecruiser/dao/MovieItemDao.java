package com.cognizant.moviecruiser.dao;

import java.sql.SQLException;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;

public interface MovieItemDao {
	public List<MovieItem> getMovieItemListAdmin() throws SQLException;

	public List<MovieItem> getMovieItemListCustomer() throws SQLException;

	public void modifyMovieItem(MovieItem movieItem);

	public MovieItem getMovieItem(long movieItemId); 

}
