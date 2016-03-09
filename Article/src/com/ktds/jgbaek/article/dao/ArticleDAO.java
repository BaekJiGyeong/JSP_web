package com.ktds.jgbaek.article.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.jgbaek.article.vo.ArticleVO;
import com.ktds.jgbaek.util.xml.XML;

public class ArticleDAO {
	public List<ArticleVO> getAllArticle() {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<ArticleVO> articles = new ArrayList<ArticleVO>();

		try

		{
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "ARTICLE");

			String query = XML.getNodeString("//query/article/getAllArticle/text()");
			stmt = conn.prepareStatement(query);
			// stmt.setString(1, memberId);

			rs = stmt.executeQuery();

			ArticleVO article = null;

			while (rs.next()) {
				article = new ArticleVO();
				article.setArticleId(rs.getInt("ARTICLE_ID"));
				article.setTitle(rs.getString("TITLE"));
				article.setNickName(rs.getString("NICK_NAME"));
				article.setHits(rs.getInt("HITS"));
				article.setRecommends(rs.getInt("RECOMMENDS"));

				articles.add(article);
			}
		} catch (

		SQLException e)

		{
			throw new RuntimeException(e.getMessage(), e);
		} finally

		{
			closeDB(conn, stmt, rs);
		}
		return articles;

	}

	public ArticleVO getOneArticleByArticleId(int articleId) {

		// 1. DriverLoading
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArticleVO article = new ArticleVO();
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "ARTICLE");
			String query = XML.getNodeString("//query/article/getOneArticleByArticleId/text()");
			stmt = conn.prepareStatement(query);

			// SQL Parameter Mapping
			// 몇번째 물음표를 어디파라미터에 넣을 것인가?
			stmt.setInt(1, articleId);

			rs = stmt.executeQuery();
			if (rs.next()) {
				article.setArticleId(rs.getInt("ARTICLE_ID"));
				article.setMemberId(rs.getString("MEMBER_ID"));
				article.setTitle(rs.getString("TITLE"));
				article.setNickName(rs.getString("NICK_NAME"));
				article.setDescript(rs.getString("DESCRIPT"));
				article.setHits(rs.getInt("HITS"));
				article.setRecommends(rs.getInt("RECOMMENDS"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}

		return article;
	}
	
	public void hitArticle(int articleId) {

		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArticleVO article = new ArticleVO();
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "ARTICLE");
			String query = XML.getNodeString("//query/article/hitArticle/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, articleId);
			rs = stmt.executeQuery();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}
	
	public void recommendArticle(int articleId) {

		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArticleVO article = new ArticleVO();
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "ARTICLE");
			String query = XML.getNodeString("//query/article/recommendArticle/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, articleId);
			rs = stmt.executeQuery();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}
	
	public void deleteArticle(int articleId) {

		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArticleVO article = new ArticleVO();
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "ARTICLE");
			String query = XML.getNodeString("//query/article/deleteArticle/text()");
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, articleId);
			rs = stmt.executeQuery();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}
	public void writeArticle(ArticleVO article) {
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "ARTICLE");
			String query = XML.getNodeString("//query/article/writeArticle/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, article.getMemberId());
			stmt.setString(2, article.getTitle());
			stmt.setString(3, article.getDescript());
			
			rs = stmt.executeQuery();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}
	
	
	
	
	
	public void modifyTitle(ArticleVO article) {
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "ARTICLE");
			String query = XML.getNodeString("//query/article/writeArticle/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, article.getMemberId());
			stmt.setString(2, article.getTitle());
			stmt.setString(3, article.getDescript());
			
			rs = stmt.executeQuery();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}
	public void modifyDesctipt(ArticleVO article) {
		loadOracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTICLE", "ARTICLE");
			String query = XML.getNodeString("//query/article/writeArticle/text()");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, article.getMemberId());
			stmt.setString(2, article.getTitle());
			stmt.setString(3, article.getDescript());
			
			rs = stmt.executeQuery();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeDB(conn, stmt, rs);
		}
	}

	private void closeDB(Connection conn, PreparedStatement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	private void loadOracleDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public int updateArticle(ArticleVO changeArticle) {
		
		return 0;
	}

}
