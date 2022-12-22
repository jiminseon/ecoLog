<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.dao.mybatis.*"%>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String postNum = request.getParameter("postNum");
    Post post = PostDAO.postDetailData(Integer.parseInt(postNum));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale"="1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="/css/custom.css">
<title>게시판</title>
</head>
<body>
	<div class="container">
	   <div class="row">
	     <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3" style="background-color: #eeeeee; text-align: center;">게시판 글보기</th>						
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 20%;">제목</td>
						<td colspan="2"><%= post.getTitle().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">","&gt;").replaceAll("\n", "<br>") %></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td colspan="2"><%= post.getWriter() %></td>
					</tr>
					<tr>
						<td>작성일자</td>
						<td colspan="2"><%= post.getRegdate() %></td>
					</tr>
					<tr>
						<td>내용</td>
						<td colspan="2" style="min-height: 200px; text-align: left;"><%= post.getContent().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">","&gt;").replaceAll("\n", "<br>") %></td>
					</tr>
					<tr>
						<td>유형</td>
						<td colspan="2"><%= post.getCategory() %></td>
					</tr>
					<tr>
						<td colspan="2">
						   <a href="<c:url value='/post/postUpdate' />?postNum=<%=post.getPostNum() %>" class="btn btn-sm btn-primary">수정</a>
				           <a onclick="return confirm('삭제하시겠습니까?')" href="<c:url value='/post/postDelete' />?postNum=<%=post.getPostNum() %>" class="btn btn-sm btn-danger">삭제</a>
				           <a href="<c:url value='/user/createBM' />?postNum=<%=post.getPostNum() %>&&title=<%=post.getTitle()%>" class="btn btn-sm btn-primary">즐겨찾기</a>
				           <a href="<c:url value='/post/join' />?postNum=<%=post.getPostNum() %>&&title=<%=post.getTitle()%>" class="btn btn-sm btn-primary">가입하기</a>
				           <a href="<c:url value='/post/postList' />" class="btn btn-xs btn-right">목록</a>
						</td>
						
					</tr>
				</tbody>
			</table>
	   </div>
	</div>
   	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>