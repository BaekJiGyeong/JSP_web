package com.ktds.jgbaek.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.jgbaek.util.xml.XML;
import com.ktds.jgbaek.vo.GradeVO;

public class GradeDAO {
	
	public List<GradeVO> getAllGrade() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException (e.getMessage(), e);
		}
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<GradeVO> grades = new ArrayList<GradeVO>();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "MOVIE", "MOVIE");
			String query = XML.getNodeString("//query/grade/getAllGrade/text()");
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			
			GradeVO grade = null;
			
			while ( rs.next() ) {
				grade = new GradeVO();
				grade.setGradeId(rs.getInt("GRADE_ID"));
				grade.setGradeTitle(rs.getString("GRADE_TITLE"));
				grades.add(grade);
			}
		} catch (SQLException e) {
			throw new RuntimeException (e.getMessage(), e);
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
		return grades;
	}
	


}
