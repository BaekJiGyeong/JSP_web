package com.ktds.jgbaek.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.jgbaek.dao.RegionsDAO;
import com.ktds.jgbaek.vo.RegionsVO;

/**
 * Servlet implementation class RegionsServlet
 */
public class RegionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RegionsDAO regionsDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegionsServlet() {
        super();
        regionsDAO = new RegionsDAO();
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
		
		List<RegionsVO> regions = regionsDAO.getAllRegion();
		request.setAttribute("allRegions", regions);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/reg.jsp");
		rd.forward(request, response);
	}

}
