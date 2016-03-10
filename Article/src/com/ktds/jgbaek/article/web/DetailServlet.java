package com.ktds.jgbaek.article.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.jgbaek.article.biz.ArticleBiz;
import com.ktds.jgbaek.article.vo.ArticleVO;
import com.ktds.jgbaek.file.biz.FileBiz;

public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleBiz articleBiz;
	private FileBiz fileBiz;

    public DetailServlet() {
        super();
        articleBiz = new ArticleBiz();
        fileBiz = new FileBiz();       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		
		ArticleVO article = articleBiz.getOneArticleByArticleId( articleId );
		request.setAttribute("article", article);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/article/detail.jsp");
		rd.forward(request, response);
	}

}
