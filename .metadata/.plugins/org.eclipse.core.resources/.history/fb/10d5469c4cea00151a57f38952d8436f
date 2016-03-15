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

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleBiz articleBiz;

	public DeleteServlet() {
		super();
		articleBiz = new ArticleBiz();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		HttpSession session = request.getSession();
		MemberVO loginMember = (MemberVO) session.getAttribute("_MEMBER_");

		ArticleVO targetArticleInfo = articleBiz.getOneArticleByArticleId(articleId);

		// TODO 로그인한 사용자와 삭제하려는 글을 작성한 사용자가 같은지 비교한 후
		boolean isWriter = false;
		
		if (loginMember.getMemberId().equals( targetArticleInfo.getMemberId())) {
			isWriter = true;
		}
		// TODO 같다면, 글을 삭제한다.
		if (isWriter) {
			articleBiz.deleteArticle(articleId);
		} // TODO 다를 경우 삭제하지 않는다.
		else {

		}

		response.sendRedirect("/list");

	}

}
