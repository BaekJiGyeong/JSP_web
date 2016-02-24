package com.ktds.jgbaek.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.jgbaek.dao.LocationsDAO;
import com.ktds.jgbaek.vo.LocationsVO;

/**
 * Servlet implementation class LocationsServlet
 */
public class LocationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LocationsDAO locationsDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationsServlet() {
        super();
        locationsDAO = new LocationsDAO();
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
		
		List <LocationsVO>locations = locationsDAO.getAllLocations();
		request.setAttribute("allLocations", locations);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/loc.jsp");
		rd.forward(request, response);
		
	}

}
