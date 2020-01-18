package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem; 


public class MovieItemDaoSqlImpl implements MovieItemDao {

	@Override
	public List<MovieItem> getMovieItemListAdmin(){
		List<MovieItem> MovieItemList = new ArrayList<>();
		Connection con=ConnectionHandler.getConnection();
		try {
			try {
				String sql="select * from movie_item";
				PreparedStatement ps=con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					MovieItem m=new MovieItem(); 
					m.setId(rs.getInt(1));  
					m.setTitle(rs.getString(2));
					m.setBoxoffice(rs.getLong(3));
					m.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
					m.setDateofLaunch(rs.getDate(5));
					m.setGenre(rs.getString(6)); 
					m.setHasTeaser(rs.getString(7).equalsIgnoreCase("Yes"));
					MovieItemList.add(m);
				}
				}catch(Exception e) { 
					e.printStackTrace();
					
				}finally { 
					con.close();  
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return MovieItemList;// TODO Auto-generated method stub// TODO Auto-generated method stub
	}

	@Override
	public List<MovieItem> getMovieItemListCustomer() {
		List<MovieItem> CustList=new ArrayList<>();
		Connection con=ConnectionHandler.getConnection();
		try {
			String sql="select * from movie_item where  m_Active=? AND m_dateofLaunch<=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, "Yes");
			ps.setDate(2, new java.sql.Date(System.currentTimeMillis()));
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				MovieItem m=new MovieItem(); 
				m.setId(rs.getInt(1));
				m.setTitle(rs.getString(2));  
				m.setBoxoffice(rs.getLong(3));
				m.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
				m.setDateofLaunch(rs.getDate(5));
				m.setGenre(rs.getString(6)); 
				m.setHasTeaser(rs.getString(7).equalsIgnoreCase("Yes"));
				CustList.add(m);
			}
			}catch(Exception e) {
				e.printStackTrace();
				
			}finally {
				try { 
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				}
			}
		return CustList;
	}

	@Override
	public void modifyMovieItem(MovieItem movieItem) {
		Connection con=ConnectionHandler.getConnection();
		try {
			String sql="update movie_item set  m_Title=?,m_Boxoffice=?,m_Active=?,m_dateofLaunch=?,m_Genre=?,m_HasTeaser=? where m_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1,movieItem.getTitle());
			ps.setDouble(2,movieItem.getBoxoffice());
			ps.setString(3, movieItem.isActive()?"Yes":"No");
			ps.setDate(4,new java.sql.Date(movieItem.getDateofLaunch().getTime()));
			ps.setString(5,movieItem.getGenre());
			ps.setString(6, movieItem.isHasTeaser()?"Yes":"No");
			ps.setLong(7, movieItem.getId());
			int count=ps.executeUpdate();
			
			}catch(Exception e) { 
			e.printStackTrace();
			}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}// TODO Auto-generated method stub
		
	}

	@Override
	public MovieItem getMovieItem(long movieItemId) {
		MovieItem movieItem=new MovieItem();
		Connection con=ConnectionHandler.getConnection();
		try {
			String sql="select * from movie_item";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				MovieItem m=new MovieItem();
				m.setId(rs.getLong(1));
				m.setTitle(rs.getString(2)); 
				m.setBoxoffice(rs.getLong(3));
				m.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
				m.setDateofLaunch(rs.getDate(5));
				m.setGenre(rs.getString(6)); 
				m.setHasTeaser(rs.getString(7).equalsIgnoreCase("Yes"));
				
		} 
		}catch(Exception e) {
			e.printStackTrace();  
			
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
			}
		}
		return movieItem;
	}

}
