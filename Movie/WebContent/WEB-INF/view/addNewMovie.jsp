<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="20kb"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="<c:url value="/resource/js/jquery-1.12.1.js"/>"></script>
<script type="text/javascript">

	$(document).ready(function() {
		
		/*$("#addNewMovieForm").hide();
		$("#addNewMovieForm").slideDown(5000);
		$("#addNewMovieForm").slideUp(5000);
		$("#addNewMovieForm").fadeIn();
		$("#addNewMovieForm").fadeOut();*/
		
		$("#directors").click(function() {
			var selectedDirectors="";
			$("#directors option:selected").each(function(index, data) {
				selectedDirectors += data.text;
				selectedDirectors += ", ";
			});
				$("#directorsName").text(selectedDirectors);
		});
		
		$("#addNewMovie").click(function() {
			
			// Validation Check
			// input tag는 val을 쓴다.
			var movieTitle = $("#movieTitle").val();
			
			// 이절을 쓰면 사이드에 있는 공백을 지워준다.
			movieTitle = $.trim( movieTitle );			
			if( movieTitle == "" ) {
				alert("영화명을 입력하세요!");
				$("#movieTitle").focus();
				return;
			}			
			
			var rate = $("#rate").val();
			rate = $.trim( rate );			
			if( rate == "" ) {
				alert("평점을 입력하세요!");
				$("#rate").focus();
				return;
			}			
			
			// == 데이터가 같냐
			// === 타입까지 같냐 short와 int는 false가 나옴
			// NaN = not a number
			// 숫자인지 확인하는 구문
			if ( isNaN(rate) ) {
				alert("평점을 올바르게 입력하세여!\n평점은 소수점을 포함한 숫자로 적을 수 있습니다.");
			}
			
			
			
			var runningTime = $("#runningTime").val();
			runningTime = $.trim( runningTime );			
			if( runningTime == "" ) {
				alert("상영 시간을 입력하세요!");
				$("#runningTime").focus();
				return;
			}			
		
			
			var regExp = new RegExp("^[0-2]{0,1}[0-9]{1}:[0-5][0-9]$");
			var isValidrunningTime = regExp.test(runningTime);
			if ( isValidrunningTime == false ) {
				alert("상영시간을 올바르게 입력하세요!");
				return;
			}			
			
			
			
			var openDate = $(".openDate").val();
			//openDate = $.trim( openDate );	
			if( openDate == "" ) {
				alert("상영일을 선택하세요!");
				$("#openDate").focus();
				return;
			}		
			
			
			// .grade : 클래스가 grade인것
			var grade = $(".grade:checked").val();
			grade = $.trim( grade );	
			if( grade == "" ) {
				alert("등급을 선택하세요!");
				$(".grade").fadeOut().fadeIn().fadeOut.fadeIn();
				return;
			}		
			
			// each 각 무엇을 선택했는지 알 수 있음
			var directors = $("#directors option:selected").val();
			directors = $.trim( directors );
			if( directors == "" ) {
				alert("감독을 선택하세요!");
				$("#directors").fadeOut().fadeIn().fadeOut.fadeIn();
				return;
			}
			
			
			var actors = $("#actors option:selected").val();
			actors = $.trim( actors );
			if( actors == "" ) {
				alert("출연진을을 선택하세요!");
				return;
			}
			
			
			var genres = $(".genres:checked").val();
			genres = $.trim( genres );
			if( genres == "" ) {
				alert("장르를 선택하세요!");
				return;
			}		
			
			
			var form = $("#addNewMovieForm");
			form.attr("method", "post");
			form.attr("action", "<c:url value="/addNewMovieAction" />");
			form.submit();
		});
	});

</script>
</head>

<body>
	<h1>영화 등록</h1>
	<hr/>
	
	<span class="errorCode">${ errorCode }</span>
	
	
	<form id = "addNewMovieForm">
		영화명 : <input type="text" id="movieTitle" name="movieTitle"><br/>
		평점 : <input type="text" id="rate" name="rate"><br/>
		상영시간 : <input type="text" id="runningTime" name="runningTime"><br/>
		개봉일 : <input type="date" id="openDate" name="openDate"><br/>
		상영등급 : 
		<c:forEach items="${gradeList}" var ="grade">
			<input type="radio" class="grade" name="grade" value="${grade.gradeId}"/>${grade.gradeTitle} 
		</c:forEach>
		<br/>		
		감독 :
		<select id="directors" name ="directors" multiple="multiple">
			<c:forEach items="${directorList}" var ="directors">
				<option value="${directors.directorId}">${directors.directorName}
				</option>
			</c:forEach>
		</select>
		<span id="directorsName"></span>
		
		<br/>
		출연진 :
		<select id="actors" name ="actors" multiple="multiple">
		<c:forEach items="${actorList}" var ="actor">
			<option value="${actor.actorId}">"${actor.actorName}
			</option>
		</c:forEach>
		</select>
		<br/>
		장르 :
		<c:forEach items="${genreList}" var ="genre">
		<input type="checkbox" class="genres" name="genres" value="${genre.genreId}"/>${genre.genreTitle}
		</c:forEach>
		<br/>
		
		<input type="button" id="addNewMovie" value="영화 등록"/>			
	</form>
</body>
</html>