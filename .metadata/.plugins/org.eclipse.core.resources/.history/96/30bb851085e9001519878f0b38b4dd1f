package com.ktds.jgbaek.reply.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.jgbaek.member.vo.MemberVO;
import com.ktds.jgbaek.reply.biz.ReplyBiz;
import com.ktds.jgbaek.reply.vo.ReplyVO;

/**
 * Servlet implementation class DoWriteReplyServlet
 */
public class DoWriteReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReplyBiz replyBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoWriteReplyServlet() {
        super();
        replyBiz = new ReplyBiz();
        // TODO Auto-generated constructor stub
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
		
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		int depth = Integer.parseInt(request.getParameter("depth"));
		int parentReplyId = Integer.parseInt(request.getParameter("parentReplyId"));
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
		String reply = request.getParameter("description");
		
		
		System.out.println("값"+reply);
		ReplyVO replyInfo = new ReplyVO();
		
		replyInfo.setArticleId(articleId);
		replyInfo.setDepth(depth);
		replyInfo.setParentReplyId(parentReplyId);
		replyInfo.setGroupId(groupId);
		replyInfo.setOrderNo(orderNo);
		replyInfo.setDescription(reply);
		
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_MEMBER_");
		
		if ( member != null ) {
			replyInfo.setMemberId(member.getMemberId());
			
		}
		
		replyBiz.addNewReplyDepthOne(replyInfo);
		response.sendRedirect("/detail?articleId=" +articleId);
		
		
	}

}
