<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%-- <%@page import="java.util.*, model.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
private static final Logger log = LoggerFactory.getLogger(ListItemController.class);

   List<Item> itemList = (List<Item>)request.getAttribute("itemList");
   String Id = (String)request.getAttribute("Id");
   
      log.debug(itemList + "itemList2");
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
      td {
         align:center;
      }
      h2{
         width:200px;
         height:40px;
         background:#abc7a1;
         
         transition: background;
         transition-duration: 5s;
       }
      table{
              border: 6px solid black;
             border-radius: 25px;
      }
      td {
        border-radius: 15px;
      }
      h2:hover{
         background: purple;
        }
    .t1:hover{
         background: #abc7a1;
        }
      input:focus{
            background-color:#fcffcc;
          }
          
      input {
  height: 32px;
  font-size: 15px;
  border: 1px;
  border-radius: 15px;
  outline: none;
  padding-left: 10px;
  background-color: rgb(233, 233, 233);
}
   </style>
<script>
function calSave() {
    form.target = opener.name; // 타켓을 부모창으로 설정

    form.submit();
    if (opener != null) {
       opener.insert = null;
   
       self.close();
    }


}

function resizeWindow(win) {
	var wid = 500;
	var hei = 600;
	win.resizeTo(wid,hei);
}

</script>
</head>
<body onload='resizeWindow(this)'>
    <center><h2>계산기</h2></center>
    <input type="text" value="id" hidden>
        <form name="form" method="POST" action="<c:url value='/cal/create' />" target="index">
      <table  border="10" cellspacing="4" cellpadding="10" width="90%" height="450px" align="center" color="black" bgcolor="white" class="t1">
      <tr height="50px"><td align="center"><div>
      <input type="text" name="userId" value="${Id}" hidden>
         <input type="text" name="cal_day" id="year" class="cal" placeholder="날짜" style="width:80%" readonly> </div><div><br/>
         <input type="text" name="cal_point" id="level1" style="width:80%; height:60px;" readonly> </div>
      </td></tr>
      <tr height="50px"><td align="center">
	      <select name="cal_content" style="width:150px;"  >
      		<c:forEach var="testList" items="${itemList}" varStatus="i">
         		<option value="${testList.activity}">${testList.activity}</option>
      		</c:forEach>
  		 </select>
           <input type="button" class="btn btn-primary" value="+" onClick="calSave()"></td></tr>
     </table>
    </form>
    <script>
      var str = window.opener.document.getElementById( "current-year-month" ).innerHTML;
      var day = window.opener.document.getElementById( "main-date" ).innerHTML;
      
      var words = str.split("&nbsp;");
      if (words[0] == ("December")) {
    	  words[0] = "12";
      }

      document.getElementById( "year" ).value = words[4];
      document.getElementById( "year" ).value += words[0];
      document.getElementById( "year" ).value += day;
      </script>
</body>
</html>