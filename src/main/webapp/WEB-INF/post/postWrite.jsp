<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="row">
   <h1 class="text-center">글쓰기</h1>
   <form method="post" action="<c:url value='/post/create' />">
   <table class="table table-hover">
     <tr>
       <th class="danger text-right" width=15%>작성자</th>
       <td width=85%>
         <input type=text name=writer size=15 class="input-sm">
       </td>
     </tr>
     <tr>
       <th class="danger text-right" width=15%>제목</th>
       <td width=85%>
         <input type=text name=title size=45 class="input-sm">
       </td>
     </tr>
     <tr>
       <th class="danger text-right" width=15%>내용</th>
       <td width=85%>
         <textarea rows="10" cols="50" name=contents></textarea>
       </td>
     </tr>
     <tr>
       <th class="danger text-right" width=10%>유형</th>
       <td width=85%>
              <select name="category" class="input-sm">
                <option value="volunteer">봉사</option>
                <option value="donate">기부</option>
                <option value="campaign">캠페인</option>
              </select>
       </td>
     </tr>
     <tr>
       <td colspan="2" class="text-center">
         <input type=submit value=작성 class="btn btn-sm btn-primary">
         <input type=button value=취소 class="btn btn-sm btn-primary"
           onclick="javascript:history.back()">
       </td>
     </tr>
   </table>
   </form>
  </div>
</body>
</html>