package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieItemDao;
import com.cognizant.moviecruiser.dao.MovieItemDaoCollectionImpl;
import com.cognizant.moviecruiser.model.MovieItem;
import com.cognizant.moviecruiser.util.DateUtil;

/**
 * Servlet implementation class EditMovieListServlet
 */
@WebServlet({ "/EditMovieListServlet", "/EditMovieList" })
public class EditMovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMovieListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			long id = Long.parseLong(request.getParameter("movieItemId"));
			String title = request.getParameter("name");
			long boxoffice = Long.parseLong(request.getParameter("Gross"));
			boolean active = Boolean.parseBoolean(request.getParameter("rb"));
			String launch = request.getParameter("datelaunch");
			String genre = request.getParameter("genre");
			boolean hasTeaser = Boolean.parseBoolean(request.getParameter("check"));

			MovieItem movie = new MovieItem(id, title, boxoffice, active, DateUtil.convertToDate(launch), genre,
					hasTeaser);
			MovieItemDao movieItemDao = new MovieItemDaoCollectionImpl();
			movieItemDao.modifyMovieItem(movie);
			request.setAttribute("msg", "movie Items Modified succesfully");
			RequestDispatcher rd = request.getRequestDispatcher("edit-movie-status.jsp");
			rd.forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
