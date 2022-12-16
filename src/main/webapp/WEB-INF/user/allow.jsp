<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*, model.User, controller.user.*" %>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
div{
        background:#3fffaf;
        width:150px;
      height:50px;
      margin:350px 0px 0px 150px;
   }
</style>
</head>
<body>
<div>
<a href="<c:url value='/main'></c:url>" target="_top">사이트 접속하기</a>
</div>
</body>
</html>