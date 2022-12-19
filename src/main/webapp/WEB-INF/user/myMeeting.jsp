<%@page import="model.*" %>
<%@page import="model.dao.*" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html; charset=utf-8" %>
<%-- <%@page import="java.util.*, model.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	@SuppressWarnings("unchecked") 
	List<MyMeeting> meetingList = (List<MyMeeting>)request.getAttribute("meetingList");
	
	String cnt = (String)request.getAttribute("cnt");
	System.out.print(meetingList + "mmm");
--%>
<html>
<head>
<title>나의모임</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/MyMeeting.css' />" type="text/css">
</head>
<body>
<br>
<table style="width:100%">

  <tr>
	<td width="20"></td>
	<td>
	  <table>
		<tr>
		  <td class="title">&nbsp;&nbsp;<b>나의모임 목록</b>&nbsp;&nbsp;</td>
		</tr>
	  </table>  
	  		<div>내 모임 갯수: ${cnt}</div>
	  <br>		  
	  <table style="background-color: #ff9500">
		<tr>
		  <td width="190" align="center" bgcolor="ffe894" height="22">포스트 number</td>
		   <td width="200" align="center" bgcolor="ffe894">포스트 이름</td>
		  <td width="200" align="center" bgcolor="ffe894">카테고리</td>
		</tr>
<%-- 
	if (meetingList != null) {	
	  Iterator<MyMeeting> myMeetingIter = meetingList.iterator();
	
	  //사용자 리스트를 클라이언트에게 보여주기 위하여 출력.
	  while ( myMeetingIter.hasNext() ) {
		MyMeeting myMeeting = (MyMeeting)myMeetingIter.next();
--%>	  	
	  <c:forEach var="myMeeting" items="${meetingList}">  			  	
  		<tr>
		  <td width="190" align="center" bgcolor="ffffff" height="20">
		  	${myMeeting.myMtId}       <%-- <%=MyMeeting.getMyMtId()%> --%>
		  </td>
		  <td width="200" bgcolor="ffffff" style="padding-left: 10">
			<a href="<c:url value='/'>
					   <c:param name='Id' value='${myMeeting.postNum}'/>
			 		 </c:url>">
			  ${myMeeting.postNum}</a>	 <%-- <%=MyMeeting.getPostNum()%></a> --%>
		  </td>
		  <td width="200" align="center" bgcolor="ffffff" height="20">
		    ${myMeeting.userId}        <%-- <%=MyMeeting.getUserId()%> --%>
		  </td>
		</tr>
	  </c:forEach> 
<%--
	  }
	}
--%>	 
	  </table>	  	 
	  <br>   
	  <a href="<c:url value='/' />">게시판 이동</a>
	  <br>  
	</td>
  </tr>
</table>  
</body>
</html>