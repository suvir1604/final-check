package com.cognizant.moviecruiser.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieItemDaoSqlImplTest { 

	public static void main(String[] args) throws ParseException, SQLException {
		System.out.println("Admin List");
		testMovieItemListAdmin();
		System.out.println("Customer List");
		testMovieItemListCustomer();
		testmodifyMovieItem();
		System.out.println("After modifying");
		testMovieItemListAdmin();

	}

	public static void testMovieItemListAdmin() throws ParseException, SQLException{
		MovieItemDao movieItemDao = new MovieItemDaoSqlImpl();
		List<MovieItem> movieItemList = movieItemDao.getMovieItemListAdmin();
		for (MovieItem x : movieItemList) {
			System.out.println(x);
		}
	}

	public static void testMovieItemListCustomer() throws ParseException, SQLException {
		MovieItemDao movieItemDao = new MovieItemDaoSqlImpl(); 
		List<MovieItem> movieItemList = movieItemDao.getMovieItemListCustomer();
		for (MovieItem x : movieItemList) {
			System.out.println(x);
		}
	}

	private static void testmodifyMovieItem() throws ParseException {
		MovieItem m = new MovieItem(2, "HeartStrings", 1518812974, true, DateUtil.convertToDate("23/12/2017"), "Romance",
				true);
		MovieItemDao movieItemDao = new MovieItemDaoSqlImpl();
		movieItemDao.modifyMovieItem(m);
		MovieItem modifyMovieItem = movieItemDao.getMovieItem(m.getId()); 
	}

}

