package com.ktds.jgbaek.member.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.jgbaek.member.biz.MemberBiz;
import com.ktds.jgbaek.member.vo.MemberVO;

/**
 * Servlet implementation class MemberManageServlet
 */
public class MemberManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberBiz memberBiz;   
    public MemberManageServlet() {
        super();
        memberBiz = new MemberBiz();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MemberVO> members = new ArrayList<MemberVO>();
		members = memberBiz.getAllMember();
		  request.setAttribute("members", members);
	      RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/member/memberList.jsp");
	      
	      rd.forward(request, response);
		
	}

}
