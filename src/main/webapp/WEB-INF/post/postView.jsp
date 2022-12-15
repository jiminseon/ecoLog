<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.dao.mybatis.*"%>
<%@page import="model.*" %>

<%
    String postNum = request.getParameter("postNum");
    Post post = PostDAO.postDetailData(Integer.parseInt(postNum));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
   <div class="row">
     <h1 class="text-center">내용보기</h1>
     <table class="table table-striped">
       <tr>
         <th class="text-center danger" width=20%>번호</th>
         <td class="text-center" width=30%><%=post.getPostNum() %></td>
         <th class="text-center danger" width=20%>작성일</th>
         <td class="text-center" width=30%><%=post.getRegdate() %></td>
       </tr>
       <tr>
         <th class="text-center danger" width=20%>작성자</th>
         <td class="text-center" width=30%><%=post.getWriter() %></td>
         <th class="text-center danger" width=20%>조회수</th>
         <td class="text-center" width=30%><%=post.getVisitCount() %></td>
       </tr>
       <tr>
         <th class="text-center danger" width=20%>제목</th>
         <td colspan="3"><%=post.getTitle() %></td>
       </tr>
       <tr>
         <td colspan="4" class="text-left" valign="top" height=200>
          <pre style="white-space: pre-wrap;background-color:white;border:none"><%=post.getContent() %></pre>
         </td>
       </tr>
       <tr>
         <td colspan="4" class="text-right">
           <a href="../main/main.jsp?mode=6&postNum=<%=post.getPostNum() %>" class="btn btn-xs btn-primary">수정</a>
           <a href="../main/main.jsp?mode=5&postNum=<%=post.getPostNum() %>" class="btn btn-xs btn-success">삭제</a>
           <a href="../main/main.jsp?mode=1" class="btn btn-xs btn-danger">목록</a>
         </td>
       </tr>
     </table>
   </div>
</body>
</html>