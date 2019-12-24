package com.cognizant.moviecruiser.model;

import java.util.Date;

import com.cognizant.moviecruiser.util.DateUtil;

public class MovieItem {
	private long id;
	private String Title;
	private long Boxoffice;
	private boolean Active;
	private Date dateofLaunch;
	private String Genre;
	private boolean HasTeaser;
	public MovieItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieItem(long id, String title, long boxoffice, boolean active, Date dateofLaunch, String genre,
			boolean hasTeaser) {
		super();
		this.id = id;
		Title = title;
		Boxoffice = boxoffice;
		Active = active;
		this.dateofLaunch = dateofLaunch;
		Genre = genre;
		this.HasTeaser = hasTeaser;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public long getBoxoffice() {
		return Boxoffice;
	}
	public void setBoxoffice(long boxoffice) {
		Boxoffice = boxoffice;
	}
	public boolean isActive() {
		return Active;
	}
	public void setActive(boolean active) {
		Active = active;
	}
	public Date getDateofLaunch() {
		return dateofLaunch;
	}
	public void setDateofLaunch(Date dateofLaunch) {
		this.dateofLaunch = dateofLaunch;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public boolean isHasTeaser() {
		return HasTeaser;
	}
	public void setHasTeaser(boolean hasTeaser) {
		this.HasTeaser = hasTeaser;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieItem other = (MovieItem) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public String toString() {
		String details = String.format("%-20s $ %-20s %-5s %-15s %-20s %-5s delete", Title, Boxoffice, Active?"Yes":"No",
				DateUtil.convertToString(dateofLaunch), Genre, HasTeaser?"Yes":"No");
		return details;

	}
}

	