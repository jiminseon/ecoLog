<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>에코로그</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/user.css' />"
	type="text/css">
<script>
function login() {
	if (form.Id.value == "") {
		alert("사용자 ID를 입력하십시오.");
		form.Id.focus();
		return false;
	} 
	if (form.password.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.password.focus();
		return false;
	}		
	form.submit();
}

function userCreate(targetUri) {
	form.action = targetUri;
	form.method="GET";		// register form 요청
	form.submit();
}
</script>
<style>
#wrap {
	width: 1000px;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

table {
	border: 3px Black
}

td {
	border: 1px light Green
}

#title {
	background-color: White
}
</style>
</head>
<body>
	<br>
	<!-- login form  -->
	<form name="form" method="POST" action="<c:url value='/user/login' />">
		<table style="width: 100%">
			<tr>
				<td width="20"></td>
				<td><b>에코로그</b><br> <br>
					<table>
						<tr>
							<td class="title">&nbsp;&nbsp;에코로그 - 로그인&nbsp;&nbsp;</td>
						</tr>
					</table> 
					<br>
					<table style="background-color: YellowGreen">
						<tr height="40">
							<td width="1100" align="center" bgcolor="e6ffe6">사용자 ID</td>
							<td width="1100" bgcolor="ffffff" style="padding-left: 10">
								<input type="text" style="width: 240" name="Id">
							</td>
						</tr>
						<tr height="40">
							<td width="1100" align="center" bgcolor="e6ffe6">비밀번호</td>
							<td width="1100" bgcolor="ffffff" style="padding-left: 10">
								<input type="password" style="width: 240" name="password">
							</td>
						</tr>
					</table> <br>
					<table style="width: 100%">
						<tr>
							<td align=left>
							<input type="button" value="로그인" onClick="login()"> &nbsp; 
							<input type="button" value="회원가입" onClick="userCreate(
								'<c:url value='/user/register'/>')">
							</td>
						</tr>
					</table>
			</tr>
			<tr height="100">
				<td>&nbsp;</td>
				<td><a
					href="https://raw.githubusercontent.com/dbp-energizo/EcoLog/36373981e5a22cef77deaeefd9e85b6331c2e74a/1%EB%8B%A8%EA%B3%84.png">
						<img src="<c:url value='/images/logo.gif' />" />
				</a></td>
			</tr>
		</table>
	</form>
</body>
</html>