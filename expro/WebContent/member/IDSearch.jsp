<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ID/PW 찾기</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="./member/memberJoinCheck.js">
</script>
</head>
<body>
	<div>
		<%@ include file="/home/sidebar.jsp" %>
	</div>
	<div class="w3-padding-large" style="margin-left:300px;margin-right:70px">
		<h3>ID 확인</h3>
		<div class="w3-container">
		<c:choose>
			<c:when test = "${id == null }">
				<p>해당 계정은 존재하지 않습니다.</p>
				<form action="/expro/LoginAction.do" method="post">			
					<input class="w3-button w3-text-black w3-white" type="button" value="로그인 하기" onclick="location.href='./member/loginForm.jsp'">
					<input class="w3-button w3-text-black w3-white" type="button" value="PW 찾기" onclick="location.href='./member/PWSearchForm.jsp'">
				</form>
			</c:when>
			<c:otherwise>
				<p>아이디를 확인하세요.</p>
				<form action="/expro/LoginAction.do" method="post">
					<input class="w3-input w3-border" style="width:50%" type="text" name="id" id="id" required value=${id }>				
					<input class="w3-button w3-text-black w3-white" type="button" value="로그인 하기" onclick="location.href='./member/loginForm.jsp'">
					<input class="w3-button w3-text-black w3-white" type="button" value="PW 찾기" onclick="location.href='./member/PWSearchForm.jsp'">
				</form>
			</c:otherwise>
		</c:choose>
		</div>
	</div>
</body>
</html>