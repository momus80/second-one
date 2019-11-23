<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<h3>ID 찾기</h3>
		<div class="w3-container">
			<form action="/expro/IDSearch.do" method="get">
			<p>아이디를 찾을 계정의 이메일을 입력하세요.</p>
				<input class="w3-input w3-border" style="width:50%" type="text" name="email" id="email" required placeholder="이메일">				
				<input class="w3-button w3-text-black w3-white" type="submit" value="ID 찾기">
				<input class="w3-button w3-text-black w3-white" type="button" value="PW 찾기" onclick="location.href='./PWSearchForm.jsp'">
			</form>
		</div>
	</div>
</body>
</html>