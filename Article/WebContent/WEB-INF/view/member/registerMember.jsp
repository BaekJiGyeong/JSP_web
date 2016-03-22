<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<script type="text/javascript">

$(document).ready(function() {
	
	$("#doRegister").click(function() {
		var form = $("#registerForm");
		form.attr("method", "post");
		form.attr("action", "/addNewMember");
		form.submit();
	});		
	$("#memberId").keyup(function(event) {
		var value = new String(event.currentTarget.value);
		$('#input2').val(value);
	});	
	
	

});
	
</script>    


<form id="registerForm">
	<table>
		<tr>
			<td>memberId</td>
			<td>
				<input type="text" id="memberId" name="memberId" style="width:250px"/>
				<input type="text" id="input2" name="input2" style="width:250px"/>
			</td>
		</tr>
		<tr>
			<td>nickName</td>
			<td>
				<input type="text" id="nickName" name="nickName" style="width:250px"/>
			</td>
		</tr>
		<tr>
			<td>password</td>
			<td>
				<input type="text" id="password" name="password" style="width:250px"/>
			</td>
		</tr>
		<tr>
			<td>email</td>
			<td>
				<input type="text" id="email" name="email" style="width:250px"/>
			</td>
		</tr>
	</table>	

</form>
<input type="button" id="doRegister" value="회원가입"/></br>

<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>