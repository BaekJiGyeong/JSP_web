package com.ktds.jgbaek.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.jgbaek.util.xml.XML;
import com.ktds.jgbaek.vo.ActorVO;
import com.ktds.jgbaek.vo.GenreVO;


public class ActorDAO {
	
	public List<ActorVO> getAllActor() {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<ActorVO> actors = new ArrayList<ActorVO>();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","MOVIE", "MOVIE");
			String query = XML.getNodeString("//query/actor/getAllActor/text()");
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			ActorVO actor = null;
			while( rs.next() ) {
				actor = new ActorVO();
				actor.setActorId(rs.getInt("ACTOR_ID"));
				actor.setActorName(rs.getString("ACTOR_NAME"));
				actors.add(actor);				
			}
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			
			closeDB(conn, stmt, rs);
		}
		
		return actors;
	}
	
	
	public List<ActorVO> getActorsByMovieId ( int movieId) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<ActorVO> actors = new ArrayList<ActorVO>();
		
		ActorVO actor = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","MOVIE", "MOVIE");
			String query = XML.getNodeString("//query/actor/getActorsByMovieId/text()");
			
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, movieId);
			
			rs = stmt.executeQuery();
			
			
			while( rs.next() ) {
				actor = new ActorVO();
				actor.setActorName(rs.getString("ACTOR_NAME"));
				actors.add(actor);
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			
			closeDB(conn, stmt, rs);
		}
		
		return actors;
	}
	

	public boolean addNewActor ( String actorName ) {
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","MOVIE", "MOVIE");
			
			String query = XML.getNodeString("//query/actor/insertNewActor/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1,  actorName);
			
			int insertCount = stmt.executeUpdate();
			
			return insertCount>0;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);			
		}
		finally {
			closeDB(conn, stmt, null);
		}
	}
	
	public int insertNewActorOfNewMovie ( ActorVO actor ){
		
		int insertCount = 0;
		
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "MOVIE", "MOVIE");
			String query = XML.getNodeString("//query/actor/insertNewActorOfNewMovie/text()");
			stmt = conn.prepareStatement(query);
			
			//SQL Parameter Mapping
			//몇번째 물음표를 어디파라미터에 넣을 것인가?
			stmt.setInt(1, actor.getActorId());
			stmt.setInt(2, actor.getMovieId());
			
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
