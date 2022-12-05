<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="model.*" %>
<%@page import="model.dao.*" %>
<%@ page import="java.io.PrintWriter" %>
<jsp:useBean id="post" class="model.Post" scope="page" />
<jsp:setProperty name="post" property="title" />
<jsp:setProperty name="post" property="content" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판</title>
</head>
<body>
  <%
	String userID = null;
  	if (session.getAttribute("userID") != null) {
  		userID = (String) session.getAttribute("userID");
  	}
  	
  	if (userID == null) {
  		PrintWriter script = response.getWriter();
  		script.println("<script>");
  		script.println("alert('로그인을 하세요.')");
  		script.println("location.href = 'login.jsp'");
  		script.println("history.back()");
  		script.println("</script>");
  	} else {
  		if (post.getTitle() == null || post.getContent() == null || post.getCategory() == null) {
  				PrintWriter script = response.getWriter();
  				script.println("<script>");
  				script.println("alert('입력이 안된 사항이 있습니다.')");
  				script.println("history.back()");
  				script.println("</script>");
  			} else {
  				postDAO postDAO = new postDAO();
  				int result = postDAO.write(post.getTitle(), userID, post.getContent(), post.getCategory());
  				if (result == -1) {
  					PrintWriter script = response.getWriter();
  					script.println("<script>");
  					script.println("alert('글쓰기에 실패 했습니다.')");
  					script.println("history.back()");
  					script.println("</script>");
  				} else {
  					PrintWriter script = response.getWriter();
  					script.println("<script>");
  					script.println("location.href = 'postList.jsp'");
  					script.println("</script>");
  				}
  			}
	}		
  %>
</body>
</html>