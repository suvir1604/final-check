package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorite;
import com.cognizant.moviecruiser.model.MovieItem;

public class FavoriteDaoCollectionImpl implements FavoriteDao {
	private static HashMap<Long, Favorite> userFavorite;

	public FavoriteDaoCollectionImpl() {
		super();
		if (userFavorite == null) {
			userFavorite = new HashMap();
			userFavorite.put(1l, new Favorite());

		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addFavorite(long userId, long movieItemId) {
		try {
			MovieItemDao movieItemDao = new MovieItemDaoCollectionImpl();
			MovieItem movieItem = movieItemDao.getMovieItem(movieItemId);
			if (userFavorite.containsKey(userId)) {
				Favorite favorite = userFavorite.get(userId);
				favorite.getMovieItemList().add(movieItem);
			} else {
				Favorite favorite = new Favorite();
				favorite.getMovieItemList().add(movieItem);
				userFavorite.put(userId, favorite);
			}
		} catch (ParseException e) {
			e.printStackTrace();

		}

	}

	@Override
	public List<MovieItem> getAllFavorite(long userId) {
		List<MovieItem> movieItemList = userFavorite.get(userId).getMovieItemList();
		Favorite favorite = userFavorite.get(userId);
		long noOffFavorite = 0;
		if (((favorite == null)) || (movieItemList.isEmpty())) {
			try {
				throw new FavoriteEmptyException();
			} catch (FavoriteEmptyException e) {
				e.printStackTrace();
			}
		} else {
			for (MovieItem x : movieItemList) {
				noOffFavorite = noOffFavorite+x.getBoxoffice();
			}
		}

		return movieItemList;
	}

	@Override
	public void removeFavorite(long userId, long movieItemId) {
		List<MovieItem> movieItemList = userFavorite.get(userId).getMovieItemList();
		for (MovieItem s : movieItemList) {
			if (s.getId() == movieItemId) {
				movieItemList.remove(s);
			}
			break;

		}

		// TODO Auto-generated method stub

	}

}
