<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@page import="java.util.*, model.dao.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	@SuppressWarnings("unchecked")
		List<Calculator> calList = (List<Calculator>)request.getAttribute("calList");
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록ㄴ</title>
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
         border-style: hidden;
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
	var wid = 400;
	var hei = 500;
	win.resizeTo(wid,hei);
}

</script>
</head>
<body onload='resizeWindow(this)'>
    <center><h2>목록</h2></center>
    <input type="text" value="id" hidden>
        <form name="form" method="POST" action="<c:url value='/cal/create' />" target="index">
      <table  border="10" cellspacing="4" cellpadding="10" width="90%" height="200px" align="center" color="black" bgcolor="white" class="t1">
      <tr height="30px"><td align="center"><div>
         <input type="text" name="cal_day" id="year" class="cal" placeholder="날짜" style="width:80%" readonly> </div><br/>
      </tr>
 <%-- 
	if (calList != null) { 	
	  Iterator<calList> calListIter = calList.iterator();
	
	  //사용자 리스트를 클라이언트에게 보여주기 위하여 출력.
	  while ( calListIter.hasNext() ) {
		Calculator calList = (Calculator)calListIter.next();
--%>	
	      <c:forEach var="calList" items="${calList}">  	
	      <tr><td align="center" height="10px">
	         		${calList.cal_content}
	      		</td>
	     		  <td><a href="<c:url value='/cal/rmvCal'>
				     		   <c:param name='calNum' value='${calList.calNum}'/>
				 	 </c:url>">x</a></td></tr>
			 	 </c:forEach>
     <%--
	  }
	}
--%>	 
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