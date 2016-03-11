<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resource/js/jquery-1.12.1.js"></script>
<script type="text/javascript">


	$(document).ready( function() {		
		
		$(".hide").hide();
		
		$("#list").click( function() {
			location.href = "/list";
		} );		
		$("#btnRecommends").click(function(){
	         var form = $("#btnRecommendsForm");
	         
	         form.attr("method", "POST");
	         form.attr("action", "/recommends?articleId=${articles.articleId }");
	         
	         form.submit();
	      });
	      
	      $("#writeReplyBtn").click(function(){
	         var form = $("#writeReplyForm");
	         
	         form.attr("method", "POST");
	         form.attr("action", "/doWriteReply");
	         
	         form.submit();
	      });
	} );
</script>
</head>


<body>
<div id="list" align="center">
<table border="1">
	<tr>
		<th>ARTICLE_ID</th>
		<th>MEMBER_ID</th>
		<th>NICK_NAME</th>
		<th>HITS</th>
		<th>RECOMMENDS</th>
	</tr>	
	<tr>
		<td>${ article.articleId }</td>
		<td>${ article.memberId }</td>
		<td>${ article.nickName }</td>
		<td>${ article.hits }</td>
		<td>${ article.recommends }</td>
	</tr>
		<th>제목</th>
		<td colspan="5">${ article.title }</td>
	<tr>
		<th>내용</th>
		<td colspan="5">${ article.descript }</td>
	</tr>
	
	<tr>
		<c:forEach items ="${article.fileList}" var="file">
			<td colspan="6">
				<a href = "/download?fileId=${file.fileId}&articleId=${article.articleId}">
					${file.fileName}
				</a>
			</td>
		</c:forEach>
	</tr>
</table>

<input type = "button" id="list" value= "목록" />
<input type = "button" id="recommend" value= "추천하기" />

<br/>

${ sessionScope._MEMBER_.memberId }
${ sessionScope._MEMBER_.nickName }
${ sessionScope._MEMBER_.password }
${ sessionScope._MEMBER_.email }



<form id="writeReplyForm">
	<input type="hidden" id="articleId" name="articleId" value="${article.articleId }"/>
	<input type="hidden" id="depth" name="depth" value="0"/>
	<input type="hidden" id="parentReplyId" name="parentReplyId" value="0"/>
	<input type="hidden" id="groupId" name="groupId" value="0"/>
	<input type="hidden" id="orderNo" name="orderNo" value="0"/>
	<textarea id="description" name="description"></textarea>
	<input type="button" id="writeReplyBtn"value="댓글 등록"/>
	
</form>

<div>
<c:forEach items="${article.replyList}" var="reply">
	<table border="1">
		<tr>
			<th>작성자</th>
			<th>댓글</th>
		</tr>
		<tr>
			<td>${reply.nickName}</td>
			<td>${reply.description}<br/>
				<a href="#">댓글달기</a>
			</td>
		</tr>
		<tr class="hide">
			<td class="groupId">${reply.groupId}</td>
			<td calss="parentReplyId">${reply.parentReplyId}</td>
		</tr>
		<tr class="hide">
			<td class="depth">${reply.depth}</td>
			<td calss="orderNo">${reply.orderNo}</td>
		</tr>
	</table>
</c:forEach>

<c:set var="loginId" value="${ sessionScope._MEMBER_.memberId }"/>
<c:if test="${ loginId eq article.memberId }">
<a href="/delete?articleId=${article.articleId }">삭제</a>
<a href="/modify?articleId=${article.articleId }">수정</a>
</c:if>
</div>
</body>
</html>

<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>