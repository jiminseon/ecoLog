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
	width: 61%;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

table {
        border-radius: 15px;
	border: 3px Black;
}

td {
	border: 1px #adc0de;
    border-radius: 15px;
}

#title {
	background-color: White
}

      input:focus{
            background-color:#fcffcc;
          }
          
          
table:hover{
         background: #aad162;
        }
</style>
</head>
<body>
	<br>
	<!-- login form  -->
	<form name="form" method="POST" action="<c:url value='/user/login' />">
		<table style="width: 60%">
			<tr>
				<td width="20"></td>
				<td><b>에코로그</b><br> <br>
					<table>
						<tr>
							<td class="title">&nbsp;&nbsp;에코로그 - 로그인&nbsp;&nbsp;</td>
						</tr>
					</table> 
					<br>
					<table style="background-color: #5988d4">
						<tr height="40">
							<td width="1100" align="center" bgcolor="adc0de"><b>사용자 ID</b></td>
							<td width="1100" bgcolor="ffffff" style="padding-left: 10">
								<input type="text" style="width: 240" name="Id">
							</td>
						</tr>
						<tr height="40">
							<td width="1100" align="center" bgcolor="adc0de"><b>비밀번호</b></td>
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
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>