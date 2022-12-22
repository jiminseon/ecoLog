<%@page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.*, model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
User user = (User) request.getAttribute("user");
%>
<html>
<head>
<title>마이페이지</title>
<link rel=stylesheet href="<c:url value='/css/user.css' />"
   type="text/css">
<script>
function userList(targetUri) {
   form.action = targetUri;
   form.submit();
}
function userRemove() {
   return confirm("정말 삭제하시겠습니까?");
}

function checkPW() {
   if (form.password.value == "") {
      alert("비밀번호를 입력하십시오.");
      return false;
   }else if(form.password.value != <%=user.getPassword()%>) {
      alert("비밀번호가 틀렸습니다.");
      return false;
   }else{
      return true;
   }
}

</script>
<style>

table {
   border: 3px Black;
   border-radius: 10px;
}

td {
   border: 1px light Green;
   border-radius: 10px;
}

#title {
   background-color: Green
}
</style>
</head>
<body>
<div><div>
   <font size='20' color='004300' weight="bold"><h1>MY PAGE</h1></font>
   <table style="float: left; width: 100%; background-color: beige">
      <tr style="background-color: yellowgreen; width: 20%; , height: 50%">
         <td width="500" align="left">
            <h1>
               <%=user.getNickname()%>님, 환영합니다.
            </h1>
            <h5>
               <%=user.getNickname()%>님의 마이페이지 입니다.
            </h5>
         </td>
         <td width="800" align="right" bgcolor=beige> <a
            href="<c:url value='/user/MyPost'>
                 <c:param name='userId' value='<%=user.getId()%>'/>
             </c:url>">내가 쓴 글 보기</a> &nbsp;</td>
      </tr>
   </table>
   <br />
   <br />
   <table
      style="float: left; background-color: beige; width: 10%; height: 50%">
      <tr style="background-color: beige">
         <td width="120" align="left">
            <h3>My Page</h3>
         </td>
      <tr style="background-color: beige">
         <td width="120" align="left"><a
            href="<c:url value='/user/update'>
                       <c:param name='userId' value='<%=user.getId()%>'/>
                    </c:url>" target="right1">개인정보 수정</a></td>
      <tr style="background-color: beige">
         <td width="120" align="left"><a
            href="<c:url value='/user/BookMark'>
                       <c:param name='userId' value='<%=user.getId()%>'/>
                    </c:url>"  target="right1">즐겨찾기 목록</a></td>
      <tr style="background-color: beige">
         <td width="120" align="left"><a
            href="<c:url value='/user/MyMeeting'>
                       <c:param name='userId' value='<%=user.getId()%>'/>
                    </c:url>"  target="right1">나의 모임</a></td>
      <tr style="background-color: beige">
         <td width="120" align="left"><a
            href="<c:url value='/user/delete'>
                     <c:param name='userId' value='<%=user.getId()%>'/>
                    </c:url>"  target="right1"
            onclick="return userRemove();">계정 삭제</a></td>
      </tr>
   </table>
</div><div>
   <iframe width="89%" height="50%" name="right1" frameboarder="5" scrolling="yes"  align="right" >rezsetfA</iframe>
</div></div>
</body>
</html>