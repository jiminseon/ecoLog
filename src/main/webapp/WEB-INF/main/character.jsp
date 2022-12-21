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

	<% int point=150; %>
	<% if (point <= 100) { %>
	<td align="center"><img src="<c:url value='/images/1단계.png' />"
		width="200" height="300" /></td>
	<% } else if (point <= 200 && point > 100) { %>
	<td align="center"><img src="<c:url value='/images/2단계.png' />"
		width="200" height="300" /></td>
	<% } else if (point <= 300 && point > 200) { %>
	<td align="center"><img src="<c:url value='/images/3단계.png' />"
		width="200" height="300" /></td>
	<% } else if (point <= 400 && point > 300) { %>
	<td align="center"><img src="<c:url value='/images/4단계.png' />"
		width="200" height="300" /></td>
	<% } else if (point <= 500 && point > 400) { %>
	<td align="center"><img src="<c:url value='/images/5단계.png' />"
		width="200" height="300" /></td>
	<% } else if (point <= 600 && point > 500) { %>
	<td align="center"><img src="<c:url value='/images/6단계.png' />"
		width="200" height="300" /></td>
	<% } else if (point <= 700 && point > 600) { %>
	<td align="center"><img src="<c:url value='/images/7단계.png' />"
		width="200" height="300" /></td>
	<% } else if (point > 700) { %>
	<td align="center"><img src="<c:url value='/images/8단계.png' />"
		width="200" height="300" /></td>
	<% }  %>

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