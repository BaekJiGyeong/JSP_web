package com.ktds.jgbaek.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddNewActorServlet
 */
public class AddNewActorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewActorServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 배우명 등록시 발생된 에러가 있다면, 적절한 조치를 취한다.
		// addNewActor라는 페이지를 처음 열었을 떄 에러코드가 없음
		String errorCode = request.getParameter("errorCode");
		
		if ( errorCode != null && errorCode.equals("1")){
			request.setAttribute("ErrorMessage", "배우명을 등록하세요");
		}
		if ( errorCode != null && errorCode.equals("2")){
			request.setAttribute("ErrorMessage", "등록에 실패했습니다.");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/addNewActor.jsp");
		
		rd.forward(request, response);
		
		
	}

}
