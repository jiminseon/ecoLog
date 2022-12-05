<%@page import="model.dao.mybatis.*, java.io.*"%>
<%@page import="model.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%    
	 int postNum = Integer.parseInt(request.getParameter("postNum"));
 	 String title = request.getParameter("title");
     String writer = request.getParameter("writer");
     String category = request.getParameter("category");
     String content = request.getParameter("content");
     int visitCount = Integer.parseInt(request.getParameter("visitCount"));
     
     // 받은 데이터들을 DAO => DAO에서 오라클에 INSERT
     Post post = new Post();
     post.setPostNum(postNum);
     post.setTitle(title);
     post.setWriter(writer);
     post.setCategory(category);
     post.setContent(content);
     post.setVisitCount(visitCount);
     
     // DAO를 호출한 다음에 INSERT요청 => 저장하는 SQL (databoard-mapper.xml)
     PostDAO.postInsert(post);
     response.sendRedirect("postList.jsp?mode=1");
 %>
