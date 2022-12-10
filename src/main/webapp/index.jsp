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
body{
        background:#6e8769;
        width:99%;
      height:100%;
   }
   table,td {
      text-align: right;
      border:5px solid black;
   }
div{
        background:#ffffff;
        width:99%;
      height:100%;
   }

</style>
</head>
<body>
<header>
<div class="head"><table width="99%" height="1000px"><tr><td>index.jsp
</td><td><a href="<c:url value='/user/login/form'></c:url>"> 로그인</a>
	<a href="<c:url value='/user/register'></c:url>">회원가입</a></td></tr></table>
</div>
</header>
</body>