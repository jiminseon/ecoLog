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
        width:99%;
      height:30%;
      margin:0px 0px 0px 260px;	
   }
   table{
      text-align: center;
   	border: 10px #adc0de;
    border-radius: 15px;
     margin:200px 200px 0px 0px;	
   }
   .k{
   	text-align: center;
   	border: 10px #adc0de;
    border-radius: 15px;
     background: #aad162;
   }
div{
   	text-align: center;
background: #ffffff;
	border: 5px black;
    border-radius: 15px;
        width:30%;
      height:100%;
   }

</style>
</head>
<body>
<header>
<div class="head"><center><table width="200px" height="100px"><tr><td class="k"><a href="<c:url value='/user/login/form'></c:url>" target="right"s> 로그인</a></td></tr><tr><td class="k">
	<a href="<c:url value='/user/register'></c:url>" target="right">회원가입</a></td></tr></table></center>
</div>
</header>
</body>