<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function calCreate() {
	form.submit();
}
</script>
</head>
<body>
    <h1>계산기</h1>
      <div id="year"></div>
      <div id="month"></div>
      <div id="day"></div>
      <form name="form" method="POST" action="<c:url value='/cal/create'/>">
	      
	      <input type="text" id="cal_day" name="day" class="cal" placeholder="날짜"> 
	      <input type="text" name="cal_content" class="cal" placeholder="내용"> 
	      <input type="text" name="cal_point" class="cal" placeholder="포인트"> 
	      <input type="text" name="color" class="cal" placeholder="색깔"> 
	      <input type="text" name="userid" class="cal" placeholder="사용자 ID"> 
      <input type="button" class="btn btn-primary" value="확인" onClick="calCreate()">
 	</form>
	
    <script>
      var str = window.opener.document.getElementById( "current-year-month" ).innerHTML;
      var day = window.opener.document.getElementById( "main-date" ).innerHTML;
      
      var words = str.split("&nbsp;");

      document.getElementById( "date" ).innerHTML = words[4];
      document.getElementById( "date" ).innerHTML += words[0];
      document.getElementById( "date" ).innerHTML += day;
      </script>
</body>
</html>