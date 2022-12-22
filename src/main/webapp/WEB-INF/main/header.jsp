<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*, model.User, controller.user.*" %>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
    header {
    	width: 100%;
      height: 100px;
      text-align: center;
     color: black;
}

    a:link, a:visited {
     background-color: #ffffff;
     color: #6e8769;
     text-decoration: none;
     display: inline-block;
}
 a:hover, a:active {
     background-color: #ffffff;
}
</style>
<body>
<header>
<p/><font size='7' color='004300' weight="bold"><a href="<c:url value='/header'></c:url>">EcoLog</a></font>
</header>
<iframe src="<c:url value='/main'></c:url>" name="ifr" width="100%" height="800px" name="right" frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling="no"  align="center">rezsetfA</iframe>

</body>
</html>