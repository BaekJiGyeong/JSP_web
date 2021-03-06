package com.ktds.jgbaek.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.jgbaek.vo.EmployeesVO;

public class EmployeesDAO {
	//data access os
	
	public List<EmployeesVO> getAllEmployees() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		Connection conn = null; //열었으면 닫아야됨
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<EmployeesVO> employees = new ArrayList<EmployeesVO>();
		
		try {
			//DB에 연결함
			conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);
			// conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "MOVIE", "MOVIE");
			
			String query = " SELECT * FROM EMPLOYEES ";
			// Query를 실행할 준비를 함
			stmt = conn.prepareStatement(query);
			
			// Query의 실행 결과를 가져온다.
			// Select 쿼리 일때만 사용한다.
			rs = stmt.executeQuery(); //select에만 쓰임
			
			// 싱글 row는 if쓰고 multi row는 while로 방아와 list인스턴스에 넣는다.
			EmployeesVO employee = null;
			while ( rs.next() ) {
				employee = new EmployeesVO();
				employee.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				employee.setFirstName(rs.getString("FIRST_NAME"));
				employee.setLastName(rs.getString("LAST_NAME"));
				employee.setEmail(rs.getString("EMAIL"));
				employee.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				employee.setHireDate(rs.getString("HIRE_DATE"));
				employee.setJobId(rs.getString("JOB_ID"));
				employee.setSalary(rs.getInt("SALARY"));
				employee.setCommissionPct(rs.getDouble("COMMISSION_PCT"));
				employee.setManagerId(rs.getInt("MANAGER_ID"));
				employee.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
				
				employees.add(employee);	
			}	
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		finally {
			// 역방향으로 닫아준다.
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
		return employees;	
	}
}
