package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorite;
import com.cognizant.moviecruiser.model.MovieItem; 


public class FavoriteDaoSqlImpl implements FavoriteDao {

	@Override
	public void addFavorite(long userId, long movieItemId) {
		Connection con=ConnectionHandler.getConnection();
        try {
             String sql="INSERT INTO favorite(fv_us_id,fv_pr_id) VALUES (?,?)";
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setLong(1, userId);
             ps.setLong(2, movieItemId);
                   int count = ps.executeUpdate(); 
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
		
	}

	@Override
	public List<MovieItem> getAllFavorite(long userId) throws FavoriteEmptyException {
		Connection con=ConnectionHandler.getConnection();
		Favorite favorite=new Favorite ();
			String sql="SELECT m_Title,m_Boxoffice,m_Active,m_dateofLaunch,m_Genre,m_HasTeaser FROM movie_item inner join favorite on fv_pr_id=m_id where fv_us_id=?"; 
			try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setLong(1, userId);
			ResultSet rs=ps.executeQuery();  
			while(rs.next()) {  
				MovieItem m=new MovieItem();
				m.setTitle(rs.getString(1));
				m.setBoxoffice(rs.getLong(2));
				m.setActive(rs.getString(3).equalsIgnoreCase("Yes"));
				m.setDateofLaunch(rs.getDate(4));
				m.setGenre(rs.getString(5)); 
				m.setHasTeaser(rs.getString(6).equalsIgnoreCase("Yes"));
				favorite.getMovieItemList().add(m);
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
			return favorite.getMovieItemList();// TODO Auto-generated method stub
	}

	@Override
	public void removeFavorite(long userId, long movieItemId) throws FavoriteEmptyException {
		Connection con = ConnectionHandler.getConnection();
        try {
             String sql="delete from favorite  where fv_us_id=? and fv_pr_id=?";
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setLong(1, userId);
             ps.setLong(2, movieItemId);
             int count = ps.executeUpdate();
        } catch (SQLException e) { 
               e.printStackTrace();
        } finally {
               try {
                     con.close(); 
               } catch (SQLException e) {
                     e.printStackTrace(); 

               }
        }
	}// TODO Auto-generated method stub
		
	}


