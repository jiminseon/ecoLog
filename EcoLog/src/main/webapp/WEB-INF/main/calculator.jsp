<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>계산기</h1>
      <div id="year"></div>
      <div id="month"></div>
      <div id="day"></div>
      
      <input type="text" id="activity">
    <script>
      var str = window.opener.document.getElementById( "current-year-month" ).innerHTML;
      var day = window.opener.document.getElementById( "main-date" ).innerHTML;
      
      var words = str.split("&nbsp;");

      document.getElementById( "year" ).innerHTML = words[4];
      document.getElementById( "month" ).innerHTML = words[0];
      document.getElementById( "day" ).innerHTML = day;
      </script>
</body>
</html>