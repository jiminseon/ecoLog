<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>캐릭터</title>
<link rel=stylesheet href="<c:url value='/css/user.css' />"
	type="text/css">
<style>
#wrap {
	width: 1000px;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

table {
	border: 3px Black;
	border-radius: 10px;
}

td {
	border: 1px light Green;
	border-radius: 10px;
}

#title {
	background-color: Green
}
</style>
</head>
<body>
<table>
<tr>
<c:choose> 
	<c:when test="${user.point < 30}">
	<td align="center"><img src="<c:url value='/images/1단계.png' />"
		width="150" height="200" /></td>
	</c:when>
	
	<c:when test="${user.point >= 30 and user.point < 70}">
	<td align="center"><img src="<c:url value='/images/2단계.png' />"
		width="150" height="200" /></td>
	</c:when>
	
	 <c:when test="${user.point >= 70 and user.point < 120}">
	<td align="center"><img src="<c:url value='/images/3단계.png' />"
		width="150" height="200" /></td>
	</c:when>
	
	<c:when test="${user.point >= 120 and user.point < 170}">
	<td align="center"><img src="<c:url value='/images/4단계.png' />"
		width="150" height="200" /></td>
	</c:when>
	<c:when test="${user.point >= 170 and user.point < 250}">
	<td align="center"><img src="<c:url value='/images/5단계.png' />"
		width="150" height="200" /></td>
	</c:when>
	
	<c:when test="${user.point >= 250 and user.point < 350}">
	<td align="center"><img src="<c:url value='/images/6단계.png' />"
		width="150" height="200" /></td>
	</c:when>
	
	<c:when test="${user.point >= 350 and user.point < 450}">
	<td align="center"><img src="<c:url value='/images/7단계.png' />"
		width="150" height="200" /></td>
	</c:when>
	
	<c:when test="${user.point >= 450}">
	<td align="center"><img src="<c:url value='/images/8단계.png' />"
		width="150" height="200" /></td>
	</c:when>
</c:choose></tr>
		<tr>
			<td align=left>
				<table style="background-color: YellowGreen">
					<tr height="40">
						<td width="150" align="center" bgcolor="E6ECDE"><a href="<c:url value='/user/myPage'></c:url>" target="_self">마이페이지</a></td>
						<td width="250" bgcolor="ffffff" style="padding-left: 10"><a href="<c:url value='/user/logout' />">로그아웃(&nbsp;${user.id}&nbsp;)</a></td>
					</tr>
					<tr height="40">
						<td width="150" align="center" bgcolor="E6ECDE">닉네임</td>
						<td width="250" bgcolor="ffffff" style="padding-left: 10">
							${user.nickname}</td>
					</tr>
					<tr height="40">
						<td width="150" align="center" bgcolor="E6ECDE">포인트</td>
						<td width="250" bgcolor="ffffff" style="padding-left: 10">
							${user.point}</td>
					</tr>	
				</table>
			</td>
		</tr>
	</table>
</body>
</html>