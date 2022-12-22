<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<script>
function postWrite() {
	if (form.title.value == "") {
		alert("제목은 필수입력 사항입니다.");
		form.title.focus();
		return false;
	} 
	if (form.content.value == "") {
		alert("내용은 필수입력 사항입니다.");
		form.content.focus();
		return false;
	}	
	form.submit();
}
</script>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/css/bootstrap.css' />">
<link rel="stylesheet" href="<c:url value='/css/custom.css' />">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	  <div class="row">
	   <h1 class="text-center">글쓰기</h1>
	   <form name="form" method="POST" action="<c:url value='/post/postWrite' />">
	   <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
	   <thead>
					<tr>
						<th colspan="2" style="background-color: #eeeeee; text-align: center;">게시판 글쓰기 양식</th>						
					</tr>
				</thead>
		<tbody>
	     <tr>
	       <th class="danger text-right" width=15%>작성자</th> 
	       <td width=85%>
	         <input type=text name=writer size=15 class="form-control"> <!-- 작성자는 session.getUserID()로 변경 -->
	       </td>
	     </tr>
	     <tr>
	       <th class="form-control" width=15%>제목</th>
	       <td width=85%>
	         <input type=text name=title size=45 class="form-control">
	       </td>
	     </tr>
	     <tr>
	       <th class="form-control" width=15%>내용</th>
	       <td width=85%>
	         <textarea rows="10" cols="50" name=content></textarea>
	       </td>
	     </tr>
	     <tr>
	       <th class="form-control" width=10%>유형</th>
	       <td width=85%>
	              <select name="category" class="input-sm">
	                <option value="기부">기부</option>
	                <option value="봉사" selected>봉사</option>
	                <option value="캠페인">캠페인</option>
	              </select>
	       </td>
	     </tr>
	     </tbody>
	     <tr>
	       <td colspan="2" class="text-center">
	         <input type=button value=작성 class="btn btn-sm btn-primary" onClick="postWrite()">
	         <input type=button value=취소 class="btn btn-sm btn-primary" onclick="javascript:history.back()">
	       </td>
	     </tr>
	   </table>
	   </form>
	  </div>
	</div>
   	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="<c:url value='/js/bootstrap.js' />"></script>
</body>
</html>