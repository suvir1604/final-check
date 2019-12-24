package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieItemDaoCollectionImplTest {

	public static void main(String[] args) throws ParseException {
		System.out.println("Admin List");
		testMovieItemListAdmin();
		System.out.println("Customer List");
		testMovieItemListCustomer();
		testmodifyMovieItem();
		System.out.println("After modifying");
		testMovieItemListAdmin();

	}

	public static void testMovieItemListAdmin() throws ParseException {
		MovieItemDao movieItemDao = new MovieItemDaoCollectionImpl();
		List<MovieItem> movieItemList = movieItemDao.getMovieItemListAdmin();
		for (MovieItem x : movieItemList) {
			System.out.println(x);
		}
	}

	public static void testMovieItemListCustomer() throws ParseException {
		MovieItemDao movieItemDao = new MovieItemDaoCollectionImpl();
		List<MovieItem> movieItemList = movieItemDao.getMovieItemListCustomer();
		for (MovieItem x : movieItemList) {
			System.out.println(x);
		}
	}

	private static void testmodifyMovieItem() throws ParseException {
		MovieItem m = new MovieItem(2, "AngryBirds", 1518812974, true, DateUtil.convertToDate("23/12/2017"), "comedy",
				true);
		MovieItemDao movieItemDao = new MovieItemDaoCollectionImpl();
		movieItemDao.modifyMovieItem(m);
		MovieItem modifyMovieItem = movieItemDao.getMovieItem(m.getId());
	}

}
