package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieItemDaoCollectionImpl implements MovieItemDao {
	private static List<MovieItem> MovieItemList;

	public MovieItemDaoCollectionImpl() throws ParseException {
		super();
		if (MovieItemList == null) {
			MovieItemList = new ArrayList<>();
			MovieItemList.add(new MovieItem(1, "Avatar", 278796508l, true, DateUtil.convertToDate("15/03/2017"),
					"Science Fiction", true));
			MovieItemList.add(new MovieItem(2, "The Avengers", 1518812988l, true, DateUtil.convertToDate("23/12/2017"),
					"Super Hero", false));
			MovieItemList.add(new MovieItem(3, "Titanic", 218746394l, true, DateUtil.convertToDate("21/08/2017"),
					"Romance", false));
			MovieItemList.add(new MovieItem(4, "Jurassic World", 1671713208l, false,
					DateUtil.convertToDate("02/07/2017"), "Science Fiction", true));
			MovieItemList.add(new MovieItem(5, "Avengers:end game", 278285677l, true,
					DateUtil.convertToDate("02/11/2022"), "Super Hero", true));

		}
	}

	@Override
	public List<MovieItem> getMovieItemListAdmin() {
		// TODO Auto-generated method stub
		return MovieItemList;
	}

	@Override
	public List<MovieItem> getMovieItemListCustomer() {
		List<MovieItem> CustList = new ArrayList();
		Date today = new Date();
		for (MovieItem x : MovieItemList) {
			if ((x.getDateofLaunch().before(today))) {
				CustList.add(x);

			}
		}

		// TODO Auto-generated method stub
		return CustList;
	}

	@Override
	public void modifyMovieItem(MovieItem movieItem) {
		MovieItem x = getMovieItem(movieItem.getId());
		x.setTitle(movieItem.getTitle());
		x.setBoxoffice(movieItem.getBoxoffice());
		x.isActive();
		x.setDateofLaunch(movieItem.getDateofLaunch());
		x.setGenre(movieItem.getGenre());
		x.isHasTeaser();

	}

	@Override
	public MovieItem getMovieItem(long movieItemId) {
		MovieItem m = null;
		for (MovieItem x : MovieItemList) {
			if (x.getId() == movieItemId) {
				m = x;
				break;
			}
		}
		return m;
	}

}
