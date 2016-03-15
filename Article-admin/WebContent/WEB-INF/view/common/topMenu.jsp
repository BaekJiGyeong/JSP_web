<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">

$(document).ready(function(){
	
	$("#manageMember").click(function(){
		location.href = "<c:url value="/memberManage"/>";
	});
	
});
</script>
    
<div id="topNavi">
	<ul id="topMenu">
		<li>Home</li>
		<li>게시글 관리</li>
		<li id="manageMember">회원 관리</li>
	</ul>
</div>