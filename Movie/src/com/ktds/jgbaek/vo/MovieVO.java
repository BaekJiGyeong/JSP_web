package com.ktds.jgbaek.vo;

public class MovieVO extends GradeVO{ // 상속, 확장
//  하나의 클래스는 하나의 VO만 상속이 가능하다
//  C++만 다중상속이 가능하고 얘는 불가능
//  다중상속하고 싶으면 EMPLOYEE -> JOBS -> DEPARTMENTS -> LOCATION 확장한다
//  OBJECT PROGRAMMING 객체지향 프로그래밍
	
//	MOVIE_ID	NUMBER
//	TITLE	VARCHAR2(300 BYTE)
//	RATE	NUMBER
//	RUNNING_TIME	VARCHAR2(5 BYTE)
//	OPEN_DATE	DATE
//	GRADE_ID	NUMBER

	private int movieId;
	private String title;
	private double rate;
	private String runningTime;
	private String openDate;
	private int gradeId;
	
	/**
	 *  한 영화에 출연하는 영화배우의 수
	 *  쿼리의 카운터 함수를 추가한다.
	 */
	private int actorCount;
	
	
	public int getActorCount() {
		return actorCount;
	}
	public void setActorCount(int actorCount) {
		this.actorCount = actorCount;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	
	
}
