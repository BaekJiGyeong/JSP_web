package com.ktds.jgbaek.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.jgbaek.member.biz.MemberBiz;
import com.ktds.jgbaek.util.Root;

/**
 * Servlet implementation class DoModifyMemberServlet
 */
public class DoModifyMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberBiz memberBiz;
   
    public DoModifyMemberServlet() {
        super();
        memberBiz = new MemberBiz();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int memberId = Integer.parseInt(request.getParameter("memberId"));

		try {
			memberBiz.modifyMember(request);
			response.sendRedirect(Root.get(this)+"/memberManage");
			
		} catch (RuntimeException re) {
			System.out.println(re.getMessage());
			response.sendRedirect(Root.get(this)+"/detialMember?memberId=" + memberId);
		}
	}

}
