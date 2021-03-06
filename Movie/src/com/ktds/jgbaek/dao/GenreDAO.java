package com.ktds.jgbaek.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.jgbaek.util.xml.XML;
import com.ktds.jgbaek.vo.GenreVO;
import com.ktds.jgbaek.vo.MovieVO;

public class GenreDAO {
	
	public List<GenreVO> getAllGenre() {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<GenreVO> genres = new ArrayList<GenreVO>();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","MOVIE", "MOVIE");
			String query = XML.getNodeString("//query/genre/getAllGenre/text()");
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			GenreVO genre = null;
			while( rs.next() ) {
				genre = new GenreVO();
				genre.setGenreId(rs.getInt("GENRE_ID"));
				genre.setGenreTitle(rs.getString("GENRE_TITLE"));
				genres.add(genre);
				
			}
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			
			closeDB(conn, stmt, rs);
		}
		
		return genres;
	}
	
	
	public List<GenreVO> getGenresByMovieId ( int movieId) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<GenreVO> genres = new ArrayList<GenreVO>();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","MOVIE", "MOVIE");
			String query = XML.getNodeString("//query/genre/getGenresByMovieId/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, movieId);
			rs = stmt.executeQuery();
			
			GenreVO genre = null;
			while( rs.next() ) {
				genre = new GenreVO();

				genre.setGenreTitle(rs.getString("GENRE_TITLE"));
				genres.add(genre);
				
			}
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			
			closeDB(conn, stmt, rs);
		}
		
		return genres;
	}
	
	public int insertNewGenreOfNewMovie ( GenreVO genre ){
		
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "MOVIE", "MOVIE");
			String query = XML.getNodeString("//query/genre/insertNewGenreList/text()");
			stmt = conn.prepareStatement(query);
			
			//SQL Parameter Mapping
			//몇번째 물음표를 어디파라미터에 넣을 것인가?
			stmt.setInt(1, genre.getGenreId());
			stmt.setInt(2, genre.getMovieId());
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			closeDB(conn, stmt, null);
		}
		
		return 0;
	}


	private void closeDB(Connection conn, PreparedStatement stmt, ResultSet rs) {
		if( rs != null ) {
			try {
				rs.close();
			} catch (SQLException e) {}
		}
		if( stmt != null ) {
			try {
				stmt.close();
			} catch (SQLException e) {}
		}
		if( conn != null ) {
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}
	
	private void loadOracleDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	

}
