<%@page import="model.*" %>
<%@page import="model.dao.*" %>
<%@page import="model.dao.postDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html; charset=utf-8" %>
<%-- <%@page import="java.util.*, model.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	@SuppressWarnings("unchecked") 
	List<BookMark> bmList = (List<BookMark>)request.getAttribute("bmList");
	List<Post> pList = (List<Post>)request.getAttribute("pList");
	String cnt = (String)request.getAttribute("cnt");
	out.print(bmList + "bbb" + cnt);
--%>
<html>
<head>
<title>즐겨찾기 목록</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/BookMark.css' />" type="text/css">
</head>
<body>
<br>
<table style="width:100%">

  <tr>
	<td width="20"></td>
	<td>
	  <table>
		<tr>
		  <td class="title">&nbsp;&nbsp;<b>즐겨찾기 목록</b>&nbsp;&nbsp;</td>
		  <td></td>
		</tr>
	  </table>  
				<div>내 모임 즐겨찾기 갯수: ${cnt} </div>
	  <br>		  
	  <table style="background-color: YellowGreen">
		<tr>
		   <td width="200" align="center" bgcolor="E6ECDE">포스트 이름</td>
		   <td>삭제</td>
		</tr>
<%-- 
	if (bmList != null) {	
	  Iterator<BookMark> BookMarkIter = bmList.iterator();
	  Iterator<Post> postIter = pList.iterator();
	  //사용자 리스트를 클라이언트에게 보여주기 위하여 출력.
	  while ( BookMarkIter.hasNext() ) {
		BookMark bookMark = (BookMark)BookMarkIter.next();
		Post post = (Post)postIter.next();
		String title = post.getTitle();
--%>	  	
	 
		<c:forEach var="post" items="${pList}"> 
		  <tr> 	
		  <td width="200" bgcolor="ffffff" style="padding-left: 10">
			<a href="<c:url value='/post/postView'>
					   <c:param name='Id' value='${post.getTitle()}'/>
			 		 </c:url>">${post.getTitle()}</a>	
		  </td>
	  	  <td>	  	
		  <a href="<c:url value='/user/removeMymt'>
                       <c:param name='postNum' value='${post.getPostNum()}'/>
                    </c:url>">모임 탈퇴</a></td>
		  
		</tr>
	  </c:forEach> 
<%--
	  }
	}
--%>	 
	  </table>	  	 
	  <br>   
	<a href="<c:url value='/post/postList' />" target="_parent">게시판 이동</a>
     <br>   
	</td>
  </tr>
</table>  
</body>
</html>