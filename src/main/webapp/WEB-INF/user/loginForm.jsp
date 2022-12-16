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

.t1 {
	border: 3px Black;
	margin-left: 50px;
	margin-top: 50px;
}
.t2 {
	border: 3px Black;
	margin-left: 50px;
}
.t3 {
	border: 3px Black;
	margin-left: 80px;
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
		<table style="width: 70%" class="t3">
			<tr>
				<td width="20"></td>
				<td><b>에코로그</b><br> <br>
					
					<table style="background-color: YellowGreen" class="t1">
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
					<table style="width: 100%" class="t2">
						<tr>
							<td>
							<input type="button" value="로그인" onClick="login()"> &nbsp; 
							<input type="button" value="회원가입" onClick="userCreate(
								'<c:url value='/user/register'/>')">
							</td>
						</tr>
					</table>
			</tr>
		</table>
	</form>
</body>
</html>