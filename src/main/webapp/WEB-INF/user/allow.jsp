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
div.a1{

        background:#cdd99c;
        width:300px;
      height:100px;
      margin:200px 0px 0px 160px;
      border:0px solid #85bf4b;
      text-align:center;
      padding:20px 0px 50px 0px;
     border-radius: 40px;
   }
   div.a2{padding:20px 0px 20px 0px;
   			width:200px;
      height:70px;
        background:#85bf4b;
      border:10px solid black;
      text-align:center;
     border-radius: 50px;
   }
</style>
</head>
<body>
<div class="a1"><center>
<div class="a2">
<a href="<c:url value='/header'></c:url>" target="_top">사이트 접속하기</a>
</div></center>
</div>
</body>
</html>