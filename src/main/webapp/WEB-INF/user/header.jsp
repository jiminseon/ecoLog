<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#header {
	height: 80px;
}

td {
	border: 1px solid black;
	text-align: center;
	width: 200px;
}
</style>
</head>
<body>
	<table>
		<c:if test="${empty loginUser }">
			<!-- if loginUser is empyty -->
			<tr>
				<td></td>
				<td></td>
				<td>Login</td>
				<td>Enroll<br> <span style="color: red;">(Only Admin)</span></td>
				<td>Mypage<br> <span style="color: red;">(After login)</span></td>
			</tr>
		</c:if>

		<c:if test="${!empty loginUser }">
			<tr>
				<td>Welcome ${loginUser.name }</td>
				<td>LEV: ${loginUser.lev }</td>
				<td><a href="LogoutServlet">Logout</a></td>
				<td><c:choose>
						<c:when test="${loginUser.lev=='A'}">
							<a href="EmpAddServlet">Enroll</a>
						</c:when>
						<c:when test="${loginUser.lev=='B'}">
				Enroll<br>
							<span style="color: red;">(Only Admin)</span>
						</c:when>
					</c:choose></td>
				<td><a href="MypageServlet">Mypage</a></td>
			</tr>
		</c:if>
	</table>
</body>
</html>