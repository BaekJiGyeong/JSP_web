package com.ktds.jgbaek.favo.vo;

import com.ktds.jgbaek.article.vo.ArticleVO;

public class FavoVO extends ArticleVO{

	private int favoriteId;
	// articleId 는 상속받아 사용
	private String createdDate;
	
	public int getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
}
