package com.ktds.jgbaek.article.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.jgbaek.article.biz.ArticleBiz;
import com.ktds.jgbaek.article.vo.ArticleVO;
import com.ktds.jgbaek.member.vo.MemberVO;

public class DoWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleBiz articleBiz;
  
    public DoWriteServlet() {
        super();
        articleBiz = new ArticleBiz();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO loginMember = (MemberVO) session.getAttribute("_MEMBER_");
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		
		ArticleVO writeArticle = new ArticleVO();
		writeArticle.setMemberId(loginMember.getMemberId());
		writeArticle.setTitle(title);
		writeArticle.setDescript(description);
		
		boolean isWriteSuccess = articleBiz.write(writeArticle);
		
		response.sendRedirect("/list");
	}

}
