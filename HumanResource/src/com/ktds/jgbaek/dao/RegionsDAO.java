package com.ktds.jgbaek.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.jgbaek.vo.RegionsVO;

public class RegionsDAO {
	
	public List<RegionsVO> getAllRegion() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<RegionsVO> regions = new ArrayList<RegionsVO>();
		
		try {
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			String query = "SELECT * FROM REGIONS";
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			RegionsVO region = null;
			
			while ( rs.next() ){
				region = new RegionsVO();
				region.setRegionId(rs.getInt("REGION_ID"));
				region.setRegionName(rs.getString("REGION_NAME"));
				regions.add(region);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			if ( rs != null ) {
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			if ( stmt != null ) {
				try {
					stmt.close();
				} catch (SQLException e) {}
			}
			if ( conn != null ) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
		return regions;
		
	}

}
