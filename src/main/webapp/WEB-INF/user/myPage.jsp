<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*, model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	User user = (User)request.getAttribute("user");
%>
<html>
<head>
<title>마이페이지</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
<script>
function userList(targetUri) {
	form.action = targetUri;
	form.submit();
}
function userRemove() {
	return confirm("정말 삭제하시겠습니까?");
}
function checkPW() {
	if (form.password.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.password.focus();
		return false;
	}else if{form.password.value == user.getPassword())
		return true;
	}else{
		return false;
	}
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
	background-color: Green
}</style>
</head>
<body>
  	<table style="width: 100%"> 
  	<tr style="background-color : beige">
  		<td width="500" align="left" >
			<h1>MY PAGE</h1></td>
		<td width="500" align="right">
  			<a href="<c:url value='/main' />">홈 화면</a>&nbsp; 
			<a href="<c:url value='/user/logout'>
	     		   <c:param name='logout' value='<%=user.getId()%>'/>
			 	 </c:url>">로그아웃</a> &nbsp;
  		</td>
	</tr>
	
	</table>  
	<table> 
	<tr style = "float:left; background-color : yellowgreen; width: 100%">
		<td width="1000" align="left">
			<h2> <%=user.getNickname()%>님, 환영합니다. </h2>
			<h5> 가입일 : <%=user.getRegDate()%> </h5>
			<h5> <%=user.getNickname()%>님의 마이페이지 입니다. </h5>
		</td>
		<td width="1000" align="right">
		<a href="<c:url value='/post'>
			     	<c:param name='userId' value='<%=user.getId()%>'/>
				 </c:url>">내 캐릭터</a> &nbsp;
		<a href="<c:url value='/post'>
			     	<c:param name='userId' value='<%=user.getId()%>'/>
				 </c:url>">내가 쓴 글 보기</a> &nbsp;
	</td></tr>
	</table>  
	
		<table style = "float:left; background-color : beige; width: 100%">
		<tr style="background-color : beige">
			<td width="120" align="left">	
			    <h3>My Page</h3>
			</td>
		<tr style="background-color : beige">
			<td width="120" align="left">	
			    <a href="<c:url value='/user/update'>
			     		   <c:param name='userId' value='<%=user.getId()%>'/>
					 	 </c:url>">개인정보 수정</a> 
			</td>
		<tr style="background-color : beige">
			<td width="120" align="left">	
				<a href="<c:url value='/user/BookMark'>
			     		   <c:param name='userId' value='<%=user.getId()%>'/>
					 	 </c:url>">즐겨찾기 관리</a> 
			</td>
		<tr style="background-color : beige">
			<td width="120" align="left">	
				<a href="<c:url value='/user/MyMeeting'>
			     		   <c:param name='userId' value='<%=user.getId()%>'/>
					 	 </c:url>">모임 관리</a>
			</td>
		<tr style="background-color : beige">
			<td width="120" align="left">	
		 	    <a href="<c:url value='/user/delete'>
						   <c:param name='userId' value='<%=user.getId()%>'/>
					 	 </c:url>" onclick="return userRemove();">계정 삭제</a>
 	  		</td>
 	  	</tr>
		</table>
		
		<form name="form">
		<table style="background-color: YellowGreen">
		<tr height="40">
			<td width="500" align="center" bgcolor=beige>비밀번호 확인</td>
				<td width="1100" bgcolor="ffffff" style="padding-left: 10">
					<input type="password" style="width: 240" name="password">
				</td>
		</tr>
		<tr>
			<td align=left>
			<input type="button" value="확인" onClick="checkPW()"> &nbsp;/>
		</tr>
		</table>
		</form>
</body>
</html>