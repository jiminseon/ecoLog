<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>에코로그 - 회원 가입</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/user.css' />"
	type="text/css">
<script>
function userCreate() {
	
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
	if (form.password.value != form.password2.value) {
		alert("비밀번호가 일치하지 않습니다.");
		form.name.focus();
		return false;
	}
	if (form.name.value == "") {
		alert("이름을 입력하십시오.");
		form.name.focus();
		return false;
	}
	if(form.phoneNumber.value =="") {
		alert("전화번호를 입력하십시오.");
		form.phoneNumber.focus();
		return false;
	}
	var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	if(emailExp.test(form.email.value)==false) {
		alert("이메일 형식이 올바르지 않습니다.");
		form.email.focus();
		return false;
	}
	if (form.address.value == "") {
		alert("주소를 입력하십시오.");
		form.nickName.focus();
		return false;
	}
	if (form.birth.value == "") {
		alert("생년월일을 입력하십시오.");
		form.birth.focus();
		return false;
	}
	if (form.nickName.value == "") {
		alert("닉네임을 입력하십시오.");
		form.nickName.focus();
		return false;
	}
	form.submit();
}
function userList(targetUri) {
	form.action = targetUri;
	form.submit();
}
</script>
</head>
<body>
	<br>
	<!-- registration form  -->
	<form name="form" method="POST"
		action="<c:url value='/user/register' />">
		<table style="width: 100%">
			<tr>
				<td width="100" align="center"></td>
				<td>
					<table>
						<tr>
							<td class="title">&nbsp;&nbsp;<b>에코로그 - 회원 가입</b>&nbsp;&nbsp;
							</td>
						</tr>
					</table> <!-- 회원가입이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 --> <c:if
						test="${registerFailed}">
						<font color="red"><c:out value="${exception.getMessage()}" /></font>
					</c:if> <br>
					<table style="background-color: YellowGreen">
						<tr height="40">
							<td width="700" align="center" bgcolor="E6ECDE">사용자 ID</td>
							<td width="700" bgcolor="ffffff" style="padding-left: 10"><input
								type="text" style="width: 240;" name="Id"></td>
						</tr>
						<tr height="40">
							<td width="700" align="center" bgcolor="E6ECDE">비밀번호</td>
							<td width="700" bgcolor="ffffff" style="padding-left: 10"><input
								type="password" style="width: 240" name="password"></td>
						</tr>
						<tr height="40">
							<td width="700" align="center" bgcolor="E6ECDE">비밀번호 확인</td>
							<td width="700" bgcolor="ffffff" style="padding-left: 10"><input
								type="password" style="width: 240" name="password2"></td>
						</tr>
						<tr height="40">
							<td width="700" align="center" bgcolor="E6ECDE">이름</td>
							<td width="700" bgcolor="ffffff" style="padding-left: 10"><input
								type="text" style="width: 240" name="name">
							</td>
						</tr>
						<tr height="40">
							<td width="700" align="center" bgcolor="E6ECDE">닉네임</td>
							<td width="700" bgcolor="ffffff" style="padding-left: 10"><input
								type="text" style="width: 240" name="nickName">
							</td>
						</tr>
						<tr height="40">
							<td width="700" align="center" bgcolor="E6ECDE">생년월일</td>
							<td width="700" bgcolor="ffffff" style="padding-left: 10">
							<input type="text" name="birth" maxlength="8" placeholder="ex)19990101"
							size="6"> 
							</td>
						</tr>
						<tr height="40">
							<td width="700" align="center" bgcolor="E6ECDE">이메일 주소</td>
							<td width="700" bgcolor="ffffff" style="padding-left: 10"><input
								type="text" style="width: 240" name="email">
							</td>
						</tr>
						<tr height="40">
							<td width="700" align="center" bgcolor="E6ECDE">전화번호</td>
							<td width="700" bgcolor="ffffff" style="padding-left: 10"><input
								type="text" style="width: 240" name="phoneNumber">
							</td>
						</tr>
						<tr height="40">
							<td width="700" align="center" bgcolor="E6ECDE">주소</td>
							<td width="700" bgcolor="ffffff" style="padding-left: 10"><input
								type="text" style="width: 240" name="address">
							</td>
						</tr>
					</table> <br>
					<table style="width: 100%">
						<tr>
							<td align="left"><input type="button" value="회원 가입"
								onClick="userCreate()"> &nbsp; <input type="button"
								value="로그인 화면"
								onClick="userList('<c:url value='/user/login' />')"></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>