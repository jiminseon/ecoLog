<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="javax.servlet.http.*"%>
<%@page import="model.*" %>
<%@page import="model.dao.*" %>
<%@page import="org.slf4j.Logger" %>
<%@page import="org.slf4j.LoggerFactory" %>
<%-- <%@page import="java.util.*, model.*" %> --%>
<html>
<head>
<title>에코로그</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script>
function userList(targetUri) {
	form.action = targetUri;
	form.submit();
}
</script>
<%
	String postNum = (String)request.getAttribute("postNum");
%>
</head>
<body>

<!-- Update Form  -->
<form name="form" method="POST" action="<c:url value='/post/join'><c:param name='postNum' value='${postNum}'/> </c:url>">
  <table style="width: 100%">
	<tr>
	  <td width="20"></td>
	  <td>
	    <table>
		  <tr>
			<td class="title">&nbsp;&nbsp;<b>가입하기</b>&nbsp;&nbsp;</td>
		  </tr>
	    </table>
	    <br>	  
	    <table style="background-color: YellowGreen">
		  </tr>
		  <tr height="40">
			<td width="150" align="center" bgcolor="E6ECDE">이름</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="text" style="width: 240" name="name" value="${user.name}">
			</td>
		  </tr>
		  <tr height="40">
			<td width="150" align="center" bgcolor="E6ECDE">생년월일</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="text" style="width: 240" name="birth" value="${user.birth}">
			</td>
		  </tr> 
		  <tr height="40">
			<td width="150" align="center" bgcolor="E6ECDE">이메일 주소</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="text" style="width: 240" name="email" value="${user.email}">
			</td>
		  </tr>	
		  <tr height="40">
			<td width="150" align="center" bgcolor="E6ECDE">전화번호</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="text" style="width: 240" name="phoneNumber" value="${user.phoneNumber}">
			</td>
		  </tr>	
		  <tr>
                <td>활동명 :</td>
                <td><input type="text" name="meetName" value="${postNum}"></td>
            </tr>
            <tr>
                <td>동기 :</td>
                <td><input type="text" name="motive"></td>
            </tr>
              <tr>
                <td align="center" colspan=2><input type="submit" value="입력">
                    <input type="reset" value="취소"></td>
                    </tr>
	    </table>
	    <br>
	  </td>
	</tr>
  </table>  
</form>
</body>
</html>