package com.ktds.jgbaek.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.jgbaek.dao.ActorDAO;
import com.ktds.jgbaek.dao.DirectorDAO;
import com.ktds.jgbaek.dao.GenreDAO;
import com.ktds.jgbaek.dao.MovieDAO;
import com.ktds.jgbaek.vo.ActorVO;
import com.ktds.jgbaek.vo.DirectorVO;
import com.ktds.jgbaek.vo.GenreVO;
import com.ktds.jgbaek.vo.MovieVO;

/**
 * Servlet implementation class AddNewMovieActionServlet
 */
public class AddNewMovieActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MovieDAO movieDAO;
	private GenreDAO genreDAO;
	private ActorDAO actorDAO;
	private DirectorDAO directorDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewMovieActionServlet() {
        super();
        movieDAO = new MovieDAO();
        genreDAO = new GenreDAO();
        actorDAO = new ActorDAO();
        directorDAO = new DirectorDAO();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "잘못된 요청입니다.");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String movieTitle = request.getParameter("movieTitle");
		String rate = request.getParameter("rate");
		String runningTime = request.getParameter("runningTime");
		String openDate = request.getParameter("openDate");
		String grade = request.getParameter("grade");		
		List<String> directors = Arrays.asList(request.getParameter("directors"));
		List<String> actors = Arrays.asList(request.getParameter("actors"));
		List<String> genres = Arrays.asList(request.getParameter("genres"));
		
		if( movieTitle == null || movieTitle.length() ==0 ){
			response.sendRedirect("/Movie/addNewMovie?errorCode=" + MovieValidateConst.MISSING_MOVIE_TITLE);
			return;
		}
		
		if( rate == null || rate.length() ==0 ){
			response.sendRedirect("/Movie/addNewMovie?errorCode=" + MovieValidateConst.MISSING_RATE);
			return;
		}
		try {
		double ratePoint = Double.parseDouble(rate);
		}
		catch(NumberFormatException nfe){
			response.sendRedirect("/Movie/addNewMovie?errorCode=" + MovieValidateConst.MISSING_RATE);
			return;
		}

		if( runningTime == null || runningTime.length() ==0 ){
			response.sendRedirect("/Movie/addNewMovie?errorCode=" + MovieValidateConst.MISSING_RUNNING_TIME);
			return;
		}
		if( runningTime.length() >5 ){
			response.sendRedirect("/Movie/addNewMovie?errorCode=" + MovieValidateConst.MISSING_RUNNING_TIME);
			return;
		}
		Pattern p = Pattern.compile("^[0-2]{0,1}[0-9]{1}:[0-5][0-9]$");
		Matcher m = p.matcher(runningTime);		
		if ( !m.matches()){
			response.sendRedirect("/Movie/addNewMovie?errorCode=" + MovieValidateConst.MISSING_RUNNING_TIME);
			return;
		}
		
		if( openDate == null || openDate.length() ==0 ){
			response.sendRedirect("/Movie/addNewMovie?errorCode=" + MovieValidateConst.MISSING_OPEN_DATE);
			return;
		}
		
		if( grade == null || grade.length() ==0 ){
			response.sendRedirect("/Movie/addNewMovie?errorCode=" + MovieValidateConst.MISSING_GRADE);
			return;
		}
		
		if( directors == null || directors.size() ==0 ){
			response.sendRedirect("/Movie/addNewMovie?errorCode=" + MovieValidateConst.MISSING_DIRECTORS);
			return;
		}
		
		if( actors == null || actors.size() ==0 ){
			response.sendRedirect("/Movie/addNewMovie?errorCode=" + MovieValidateConst.MISSING_ACTORS);
			return;
		}
		
		if( genres == null || genres.size() ==0 ){
			response.sendRedirect("/Movie/addNewMovie?errorCode=" + MovieValidateConst.MISSING_GENRES);
			return;
		}
				
		MovieVO movie = new MovieVO();
		movie.setTitle( movieTitle );
		movie.setRate(Double.parseDouble( rate ));
		movie.setRunningTime( runningTime );
		movie.setOpenDate( openDate );
		movie.setGradeId(Integer.parseInt( grade ));		
		
		int newMovieId = movieDAO.insertNewMovie(movie);
		
		if ( newMovieId > 0){
			
			GenreVO genre = new GenreVO();
			genre.setMovieId(newMovieId);
			for( String selectedGenre : genres ) {
				genre.setGenreId(Integer.parseInt(selectedGenre));
				genreDAO.insertNewGenreOfNewMovie(genre);
			}
			
			ActorVO actor = new ActorVO();
			actor.setMovieId(newMovieId);
			for( String selectedActor : actors ) {
				actor.setActorId(Integer.parseInt(selectedActor));
			}
			
			DirectorVO director = new DirectorVO();		
			director.setMovieId(newMovieId);
			for( String selectedDirector : directors ) {
				director.setDirectorId(Integer.parseInt(selectedDirector));
				directorDAO.insertNewDirectorOfNewMovie(director);
			}
		}
		
		response.sendRedirect("/Movie/movie");		
		return;
	}		
}
