<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>

</head>
<body>
	<form method="post" action="UpdateServlet" name="frm">
		<table align="center" width="1000">
		<h1>MY PAGE </h1>
		<h2>${user.nickName} 님, 환영합니다. </h2>
		<h5>가입일 : ${user.regDate} </h5>
		<h5>${user.nickName} 님의 마이페이지 입니다. </h5>
			<tr>
				<td align="left"><input type="button" value="개인정보 수정"
					onClick=" location='/user/update '" />
			<tr>
				<td align="left"><input type="button" value="즐겨찾기 관리"
					onClick=" location='/user/BookMark '" />
			</tr>
			<tr>
				<td align="left"><input type="button" value="모임 관리"
					onClick=" location='/user/MyMeeting '" /> 
			</tr>
			<tr>
				<td align="left"><input type="button" value="절약기록 관리"
					onClick=" location='/user/update '" /> 
			</tr>
			<tr>
				<td align="left"><input type="button" value="계정 삭제"
					onClick=" location='/user/delete '" /> 
			</tr>
			<tr>
				<td align="left"><input type="button" value="홈 화면"
					onClick=" location='/ '" /> 
			</tr>
		</table>
	</form>
</body>
</html>