package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;

public interface FavoriteDao {
	public void addFavorite(long userId, long movieItemId);

	public List<MovieItem> getAllFavorite(long userId) throws FavoriteEmptyException;

	public void removeFavorite(long userId, long movieItemId) throws FavoriteEmptyException;
}
