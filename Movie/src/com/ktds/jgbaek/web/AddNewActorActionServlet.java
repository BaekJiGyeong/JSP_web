package com.ktds.jgbaek.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.jgbaek.dao.ActorDAO;

/**
 * Servlet implementation class AddNewActorActionServlet
 */
public class AddNewActorActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ActorDAO actorDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewActorActionServlet() {
        super();
        actorDAO = new ActorDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "잘못된 요청입니다.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String actorName = request.getParameter("actorName");
		
		// 이 코드가 없으면 데이터베이스에 있던 데이터가 모두 털릴수 있다.
		if ( actorName == null || actorName.length() ==0 ) {
			response.sendRedirect("/Movie/addNewActor?errorCode=1");
			return;
		}
		
		boolean insertResult = actorDAO.addNewActor(actorName);
		
		if ( insertResult ) {
			response.sendRedirect("/Movie/movie");			
		}
		else {
			response.sendRedirect("/Movie/addNewActor?errorCode=2");
		}
		
	}

}
