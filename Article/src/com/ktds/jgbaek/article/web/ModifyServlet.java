package com.ktds.jgbaek.article.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.jgbaek.article.biz.ArticleBiz;
import com.ktds.jgbaek.article.vo.ArticleVO;
import com.ktds.jgbaek.member.vo.MemberVO;

/**
 * Servlet implementation class ModifyServlet
 */
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleBiz articleBiz;
       
    public ModifyServlet() {
        super();
        articleBiz = new ArticleBiz();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 어떤 글을 수정할 것인지 정해야 한다.
		// 1-1. 수정하고자 하는 글의 ID를 파라미터로 받아와야 한다.
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		
		// 2. 수정하고자 하는 글의 정보를 가져와야 한다.
		ArticleVO article = articleBiz.getOneArticleByArticleId(articleId);
		
		
		// 2-1. 수정하고자 하는 글의 작성자가 본인이 맞는지 확인한다.
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO)session.getAttribute("_MEMBER_");
		if (article.getMemberId().equals(member.getMemberId())){
			
			// <br/>을 \n으로 바꿔준다.
			String description = article.getDescript();
			description = description.replaceAll("<br/>", "\n");
			article.setDescript(description);
			
			request.setAttribute("article", article);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/article/write.jsp");
			rd.forward(request, response);
		}
		else {
			response.sendRedirect("/list");
		}
		
		// 3. 수정하고자 하는 글의 정보를 JSP로 보내준다.
	}

}
