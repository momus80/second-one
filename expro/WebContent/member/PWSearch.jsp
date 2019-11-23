<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>패스워드 찾기</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
	<div>
		<%@ include file="/home/sidebar.jsp" %>
	</div>
	<div class="w3-padding-large" style="margin-left:300px;margin-right:70px">
		<h3>PWD 확인</h3>
		<form action="/expro/PasswdFind.do" method="post">
			<div>
			<c:choose>
				<c:when test = "${pwd == null }">
				<div>
					<p>해당 계정은 존재하지 않습니다.</p>
					<div>
						<input class="w3-button w3-text-black w3-white" type="button" value="ID 찾기" onclick="location.href='./member/IDSearchForm.jsp'">
						<input type="button" value="돌아가기" onclick="location.href='/expro/member/loginForm.jsp'" class="w3-button w3-white w3-text-black">
					</div>
				</div>
				</c:when>
				<c:otherwise>
					<div>
						<p>비밀번호를 확인하세요.</p>
						<div>
							<input type="text" id="pwd" name="pwd" value=${pwd } class="w3-input w3-border" required />
						</div>
						<input type="button" value="로그인 하러 가기" onclick="location.href='/expro/member/loginForm.jsp'" class="w3-button w3-white w3-text-black">
					</div>
				</c:otherwise>
			</c:choose>
			</div>
		</form>
	</div>
</body>
</html>