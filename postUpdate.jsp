<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
<%@page import="model.dao.mybatis.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String postNum = request.getParameter("postNum");
	PostDAO postDAO = new PostDAO();
    Post post = postDAO.postUpdateData(Integer.parseInt(postNum));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function postModify() {
	if (form.title.value == "") {
		alert("제목은 필수입력 사항입니다.");
		form.title.focus();
		return false;
	} 
	if (form.content.value == "") {
		alert("내용은 필수입력 사항입니다..");
		form.content.focus();
		return false;
	}	
	form.submit();
}
</script>
</head>
<body>
  <div class="row">
   <h1 class="text-center">수정</h1>
   <form method="POST" action="<c:url value='/post/postUpdate' />">
   <table class="table table-hover">
     <tr>
       <th class="danger text-right" width=15%>작성자</th>
       <td width=85%>
         <%=post.getWriter()%>
       </td>
     </tr>
     <tr>
       <th class="danger text-right" width=15%>제목</th>
       <td width=85%>
         <input type=text name=title size=45 class="input-sm" value="<%=post.getTitle()%>">
       </td>
     </tr>
     <tr>
       <th class="danger text-right" width=15%>내용</th>
       <td width=85%>
         <textarea rows="10" cols="50" name=content><%=post.getContent() %></textarea>
       </td>
     </tr>
     <tr>
       <td colspan="2" class="text-center">
         <input type="button" class="btn btn-primary" value="수정" onClick="postModify()">
         <input type=button value="취소" class="btn btn-sm btn-primary"
           onclick="javascript:history.back()"
         >
       </td>
     </tr>
   </table>
   </form>
  </div>
</body>
</html>