package com.ktds.jgbaek.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.jgbaek.dao.DepartmentsDAO;
import com.ktds.jgbaek.vo.DepartmentsVO;

/**
 * Servlet implementation class DepartmentsServlet
 */
public class DepartmentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DepartmentsDAO departmentsDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentsServlet() {
        super();
        departmentsDAO = new DepartmentsDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List <DepartmentsVO>departments = departmentsDAO.getAllDepartments();
		request.setAttribute("allDepartments", departments);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/dep.jsp");
		rd.forward(request, response);
		
	}

}
