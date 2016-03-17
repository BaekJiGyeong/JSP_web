package com.ktds.jgbaek.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.jgbaek.member.biz.MemberBiz;
import com.ktds.jgbaek.member.vo.MemberVO;
import com.ktds.jgbaek.util.Root;

/**
 * Servlet implementation class MemberDeleteServlet
 */
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberBiz memberBiz; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteServlet() {
        super();
        memberBiz = new MemberBiz();
        // TODO Auto-generated constructor stub
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
		String[] deleteMemberIds = request.getParameterValues("deleteMemberIds");
		for (String string : deleteMemberIds) {
			System.out.println(string);
		}
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		memberBiz.deleteMembers(deleteMemberIds, member);
		response.sendRedirect(Root.get(this)+"/memberManage");
	}

}
