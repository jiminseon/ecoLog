<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*" %>
<%@ page import="model.dao.mybatis.*" %>
<%@ page import="model.*" %>
<%
     String strPage=request.getParameter("page");
     if(strPage == null) // 페이지를 보내지 않을 경우 (맨처음에는 페이지를 보낼 수 없다)
         strPage = "1";// 시작페이지를 설정해 준다 
     int curpage = Integer.parseInt(strPage);
     // start:1 , end:10
     Map map = new HashMap();
     int rowSize = 10;
     int start = (curpage * rowSize) - (rowSize - 1);
     int end = curpage * rowSize;
     // map에 저장 => map 저장하는 공간 => 키,값을 설정 할 수 있다 
     map.put("start",start);
     map.put("end",end);
     List<Post> list = PostDAO.postListData(map);// 1page 1~10
     // 총페이지읽기
     int totalpage = PostDAO.postTotalPage();
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="/css/custom.css"> -->
<title>게시판</title>
<!-- <style type="text/css">
	a, a:hover {
		color: #000000;
		text-decoration: none;
	}
</style> -->
<script type="text/javascript">
function send()
{
    var f = document.frm;
    if(f.ss.value == ""){
        f.ss.focus();
        return;
    }
    f.submit();
}
</script>
</head>
<body>
   <div class="row">
     <h1 class="text-center">게시판</h1>
     <table class="table">
       <tr>
         <td>
           <a href="<c:url value='/post/postWrite' />" class="btn btn-sm btn-success">글쓰기</a>
         </td>
       </tr>
     </table>
     <table class="table table-striped">
       <tr class="warning">
         <th class="text-center" width=10%>번호</th>
         <th class="text-center" width=30%>제목</th>
         <th class="text-center" width=10%>작성자</th>
         <th class="text-center" width=10%>유형</th>
         <th class="text-center" width=20%>작성일</th>
         <th class="text-center" width=10%>조회수</th>
       </tr>
       <%
           for(Post post : list)
           {
       
       %>
               <tr>
                 <td class="text-center" width=10%><%=post.getPostNum() %></td>
                 <td width=45%>
                  <a href="/main/main.jsp&postNum=<%=post.getPostNum()%>"><%=post.getTitle() %></a>
                 </td>
                 <td class="text-center" width=15%><%=post.getWriter() %></td>
                  <td class="text-center" width=15%><%=post.getCategory() %></td>
                 <td class="text-center" width=20%><%=post.getWriteDate() %></td>
                 <td class="text-center" width=10%><%=post.getVisitCount() %></td>
               </tr>
       <%
           }
       %>
     </table>
     <table class="table">
       <tr>
         <td class="text-left">
          <form method="post" action="/main/main.jsp" name=frm>
              Search:
              <select name="fd" class="input-sm">
                <option value="name">작성자</option>
                <option value="subject">제목</option>
                <option value="content">내용</option>
                 <option value="category">유형</option>
              </select>
              <%-- 검색어 입력 --%>
              <input type=text name=ss class="input-sm">
              <input type=hidden name=mode value=4>
              <%-- 검색버튼 --%>
              <input type=button value=검색 class="btn btn-sm btn-danger"
                onclick="send()">
          </form>
         </td>
         <td class="text-right">
          <a href="#" class="btn btn-sm btn-primary">이전</a>
           <%=curpage %> page / <%=totalpage %> pages
          <a href="#" class="btn btn-sm btn-primary">다음</a>
         </td>
       </tr>
     </table>
   </div>
</body>
</html>