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
</script>
</head>
<body>
  <br>
  	<table style="width: 100%">
		<tr>
			<td width="100" align="center"></td>
	    </tr>
			<h1>MY PAGE </h1>
			<h2> <%=user.getNickname()%>님, 환영합니다. </h2>
			<h5> 가입일 : <%=user.getRegDate()%> </h5>
			<h5> <%=user.getNickname()%>님의 마이페이지 입니다. </h5>
	    </table>  
		<table>
			<br>
			
		<a href="<c:url value='/post'>
	     		   <c:param name='userId' value='<%=user.getId()%>'/>
			 	 </c:url>">내가 쓴 글 보기</a> &nbsp;
	    <a href="<c:url value='/user/update'>
	     		   <c:param name='userId' value='<%=user.getId()%>'/>
			 	 </c:url>">개인정보 수정</a> &nbsp;
		<a href="<c:url value='/user/BookMark'>
	     		   <c:param name='userId' value='<%=user.getId()%>'/>
			 	 </c:url>">즐겨찾기 관리</a> &nbsp;
		<a href="<c:url value='/user/MyMeeting'>
	     		   <c:param name='userId' value='<%=user.getId()%>'/>
			 	 </c:url>">모임 관리</a> &nbsp;
 	    <a href="<c:url value='/user/delete'>
				   <c:param name='userId' value='<%=user.getId()%>'/>
			 	 </c:url>" onclick="return userRemove();">계정 삭제</a> &nbsp;
 	    <a href="<c:url value='/' />">홈 화면</a> 	    
 	    <br><br>
		</table>
</body>
</html>