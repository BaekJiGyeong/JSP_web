package com.ktds.jgbaek.article.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.jgbaek.article.biz.ArticleBiz;
import com.ktds.jgbaek.article.vo.ArticleVO;
import com.ktds.jgbaek.file.biz.FileBiz;
import com.ktds.jgbaek.member.vo.MemberVO;
import com.ktds.jgbaek.util.MultipartHttpServletRequest;
import com.ktds.jgbaek.util.Root;
import com.ktds.jgbaek.util.MultipartHttpServletRequest.MultipartFile;

public class DoWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleBiz articleBiz;
	private FileBiz fileBiz;

	public DoWriteServlet() {
		super();
		articleBiz = new ArticleBiz();
		fileBiz = new FileBiz();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MultipartHttpServletRequest multipartRequest = new MultipartHttpServletRequest(request);

		String title = multipartRequest.getParameter("title");
		String description = multipartRequest.getParameter("description");
		MultipartFile file = multipartRequest.getFile("file");

		HttpSession session = request.getSession();
		MemberVO loginMember = (MemberVO) session.getAttribute("_MEMBER_");

		ArticleVO writeArticle = new ArticleVO();
		writeArticle.setMemberId(loginMember.getMemberId());
		writeArticle.setTitle(title);
		writeArticle.setDescript(description);

		int articleId = articleBiz.write(writeArticle);

		if (file != null && file.getFileName().length() >0) {
			// file이 null이면 파일을 업로드 안한것
			File upFile = file.write("D:\\" + file.getFileName());
			fileBiz.uploadFile(articleId, upFile);
		}

		response.sendRedirect(Root.get(this)+"/list");
	}

}
