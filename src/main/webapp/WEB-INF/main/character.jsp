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
<c:choose> 
	<c:when test="${user.point < 100}">
	<td align="center"><img src="<c:url value='/images/1단계.png' />"
		width="200" height="300" /></td>
	</c:when>
	
	<c:when test="${user.point > 100 and user.point < 200}">
	<td align="center"><img src="<c:url value='/images/2단계.png' />"
		width="200" height="300" /></td>
	</c:when>
	
	 <c:when test="${user.point > 200 and user.point < 300}">
	<td align="center"><img src="<c:url value='/images/3단계.png' />"
		width="200" height="300" /></td>
	</c:when>
	
	<c:when test="${user.point > 300 and user.point < 400}">
	<td align="center"><img src="<c:url value='/images/4단계.png' />"
		width="200" height="300" /></td>
	</c:when>
	<c:when test="${user.point > 400 and user.point < 500}">
	<td align="center"><img src="<c:url value='/images/5단계.png' />"
		width="200" height="300" /></td>
	</c:when>
	
	<c:when test="${user.point > 500 and user.point < 600}">
	<td align="center"><img src="<c:url value='/images/6단계.png' />"
		width="200" height="300" /></td>
	</c:when>
	
	<c:when test="${user.point > 600 and user.point < 700}">
	<td align="center"><img src="<c:url value='/images/7단계.png' />"
		width="200" height="300" /></td>
	</c:when>
	
	<c:when test="${user.point > 700}">
	<td align="center"><img src="<c:url value='/images/8단계.png' />"
		width="200" height="300" /></td>
	</c:when>
</c:choose>

	<table>
		<tr>
			<td align=left>
				<table style="background-color: YellowGreen">
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