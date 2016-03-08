package com.ktds.jgbaek.article.biz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ktds.jgbaek.article.dao.ArticleDAO;
import com.ktds.jgbaek.article.vo.ArticleVO;

public class ArticleBiz {

	private ArticleDAO articleDAO;

	public ArticleBiz() {
		articleDAO = new ArticleDAO();
	}

	public List<ArticleVO> getAllArticle(HttpServletRequest request) {

		List<ArticleVO> articleList = articleDAO.getAllArticle();

		return articleList;

	}

	public ArticleVO getOneArticleByArticleId(int articleId) {
		// 1. article id를 가진 article의 조회수를 update 한다.
		articleDAO.hitArticle(articleId);
		// 2. article id로 vo를 받아온다.
		ArticleVO article = articleDAO.getOneArticleByArticleId(articleId);
		// 3. article 내용을 반환해준다.
		return article;
	}
	
	public ArticleVO recommendArticle(int articleId) {
		// 1. article id를 가진 article의 추천수를 update 한다.
		articleDAO.recommendArticle(articleId);
		// 2. article id로 vo를 받아온다.
		ArticleVO article = articleDAO.getOneArticleByArticleId(articleId);
		// 3. article 내용을 반환해준다.
		return article;
	

	}

}