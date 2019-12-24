package com.cognizant.moviecruiser.model;

import java.util.ArrayList;
import java.util.List;

public class Favorite {
	private List<MovieItem> movieItemList;
	private long noOffFavorite;
	public Favorite() {
		super();
		movieItemList=new ArrayList<>();// TODO Auto-generated constructor stub
	}
	public Favorite(List<MovieItem> movieItemList, long noOffFavorite) {
		super();
		this.movieItemList = movieItemList;
		this.noOffFavorite = noOffFavorite;
	}
	public List<MovieItem> getMovieItemList() {
		return movieItemList;
	}
	public void setMovieItemList(List<MovieItem> movieItemList) {
		this.movieItemList = movieItemList;
	}
	public long getNoOffFavorite() {
		return noOffFavorite;
	}
	public void setNoOffFavorite(long noOffFavorite) {
		this.noOffFavorite = noOffFavorite;
	}
	
	
	
	

}
