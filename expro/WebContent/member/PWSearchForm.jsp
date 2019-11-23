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
		<h3>비밀번호 찾기</h3>
		<form action="/expro/PasswdFind.do" method="post">
			<div>
				<div>
					<p>비밀번호를 찾을 계정의 아이디와 등록했던 이메일을 입력하세요.</p>
					<div>
						<input type="text" id="id" name="id" placeholder="아이디" class="w3-input w3-border" required />
					</div>
					<div>
						<input type="text" id="email" name="email" placeholder="이메일" class="w3-input w3-border" required />
					</div>
					<input type="submit" value="찾기" class="w3-button w3-white w3-text-black">
					<input type="button" value="로그인 하러 가기" onclick="location.href='/expro/member/loginForm.jsp'" class="w3-button w3-white w3-text-black">
				</div>
			</div>
		</form>
	</div>
</body>
</html>