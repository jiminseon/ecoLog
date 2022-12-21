<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="javax.servlet.http.*"%>
<%@ page import="java.util.*" %>
<%@ page import="model.dao.mybatis.*" %>
<%@page import="model.*" %>
<%@page import="model.dao.*" %>
<%@page import="org.slf4j.Logger" %>
<%@page import="org.slf4j.LoggerFactory" %>
<%--
	String Id = (String)request.getAttribute("Id");
--%>
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
     List<Post> list = PostDAO.postListLast(map);// 1page 1~10
     // 총페이지읽기
     int totalpage = PostDAO.postTotalPage();
%> 
<html>
<head>
<link rel=stylesheet href="<c:url value='/css/calendar.css' />" type="text/css">
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
<title>메인</title>
<style>body{
        background:#6e8769;
        width:99%;
      height:100%;
   }
   header {
      height: 100px;
      text-align: center;
   }
   div.head {
      text-align: right;
   }
   div.wrap {
      margin: auto;
   }
   div.top, div.bottom {
     width: 1280px;
     height:350px;
     margin: auto;
   }
   div.tleft, div.bleft {
     width: 330px;
     float: left;
     margin-right: 10px;
     box-sizing: border-box;
     border: 5px solid #ffffff;
       border-radius: 15px;
   }
   div.tright {
     width: 930px;
     float: right;
     box-sizing: border-box;
   }
   div.bright {
     width: 650px;
     float: right;
     box-sizing: border-box;
     border: 5px solid #ffffff;
       border-radius: 25px;
   }   
   div.tleft, div.tright {
      height: 400px;
   }
   div.bleft, div.bright {
      height: 250px;
      margin-top: 10px;
   }
   div.bt{
     width: 280px;
     float: right;
     margin-right: 10px;
     box-sizing: border-box;
     border: 5px solid #ffffff;
       border-radius: 15px;
       height: 250px;
      margin-top: 10px;
   }
</style>

<script>
function goCal() {
	var now = new Date();
	var str = document.getElementById( "current-year-month" ).innerHTML;
    var day = document.getElementById( "main-date" ).innerHTML;
    var words = str.split("&nbsp;");
    
	if (monthList[now.getMonth()] == words[0] && now.getFullYear().toString() == words[4] && day == now.getDate().toString()) {
		var myFrm = document.frm2;
		window.name = "index"
		var url = "<c:url value='/cal/calulator'></c:url>"
		window.open("", "calculator", width=50, height=50);
		myFrm.action=url;
		myFrm.method="post";;
		myFrm.target="calculator";
		myFrm.submit();
	}
	else {
		alert("오늘 날짜만 입력 가능");		
	}
}

function goList() {
	var myForm = document.frm;
	var url = "<c:url value='/cal/list'></c:url>";
	window.open("","calList",width=50, height=50);
	myForm.action=url;
	myForm.method="post";;
	myForm.target="calList";
	myForm.submit();
}

window.open("<c:url value='/user/Info'></c:url>",'news','toolbar=no,location=no,status=no,menubar=no, scrollbars=no,resizable=no,width=600,height=700 top=100 left=100')
</script>
</head>
<body>
<header>
<div class="navbar-header">
			<a href="<c:url value='/post/postList'></c:url>">게시판</a>
			<a href="<c:url value='/post/join'></c:url>">가입하기(임시로 여기서 test)</a>
		</div>
	<div class="head">
	<a href="<c:url value='/user/myPage'></c:url>">마이페이지</a>
	</div>
	<p/><font size='7' color='004300' weight="bold">EcoLog</font>
</header>
<div class="wrap">
	<div class="top">
		<div class="tleft">
			<!-- 로그인 되어있을 때는 character.jsp가 뜨도록 구현해두기 -->
			 <%@ include file="/WEB-INF/main/character.jsp" %>
		</div>
		<div class="tright">
		
		   <%@ include file="/WEB-INF/main/calendar.jsp" %>
		   <form name="frm">
		   <input type="text" name="userId" value="${Id}" hidden>
		   	<input type="text" name="cal_day" id="date" hidden>
		   </form>
		</div>
	</div>
	<p/><p/><p/>
	<div class="bottom">
		<div class="bleft">
			<%@ include file="/WEB-INF/main/rank.jsp" %>
			<form name="frm2">
		   	<input type="text" name="userId" value="${Id}" hidden>
		   </form>
		</div>
		<div class="bright">
			       <%
           for(Post post : list)
           {
       
       %>
               <tr>
                 <td class="text-center" width=10%><%=post.getPostNum() %></td>
                 <td width=45%>
                  <a href="<c:url value='/post/postView' />?postNum=<%=post.getPostNum()%>"><%=post.getTitle() %></a>
                 </td>
                 <td class="text-center" width=15%><%=post.getWriter() %></td>
                  <td class="text-center" width=15%><%=post.getCategory() %></td>
                 <td class="text-center" width=20%><%=post.getWriteDate() %></td>
                 <td class="text-center" width=10%><%=post.getVisitCount() %></td>
               </tr>
               <br>
       <%
           }
       %>
		</div>
		<div class="bt">
			<%@ include file="/WEB-INF/main/ecoSites.jsp" %>
			
		</div>
	</div>
</div>
</body>
 <script type="text/javascript">
 
 var currentTitle = document.getElementById('current-year-month');
 var calendarBody = document.getElementById('calendar-body');
 var mainTodayDay = document.getElementById('main-day');
 var mainTodayDate = document.getElementById('main-date');
 var today = new Date();
 var first = new Date(today.getFullYear(), today.getMonth(),1);
 var dayList = ['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday'];
 var monthList = ['January','February','March','April','May','June','July','August','September','October','November','December'];
 var leapYear=[31,29,31,30,31,30,31,31,30,31,30,31];
 var notLeapYear=[31,28,31,30,31,30,31,31,30,31,30,31];
 var pageFirst = first;
 var pageYear;
 if(first.getFullYear() % 4 === 0){
     pageYear = leapYear;
 }else{
     pageYear = notLeapYear;
 } 

 function showCalendar(){
  currentTitle.innerHTML = monthList[first.getMonth()] + '&nbsp;&nbsp;&nbsp;&nbsp;'+ first.getFullYear();
  let monthCnt = 100;
     let cnt = 1;
     for(var i = 0; i < 6; i++){
         var $tr = document.createElement('tr');
         $tr.setAttribute('id', monthCnt);   
         for(var j = 0; j < 7; j++){
             if((i === 0 && j < first.getDay()) || cnt > pageYear[first.getMonth()]){
                 var $td = document.createElement('td');
                 $tr.appendChild($td);     
             }else{
                 var $td = document.createElement('td');
                 $td.textContent = cnt;
                 $td.setAttribute('id', cnt);                
                 $tr.appendChild($td);
                 cnt++;
             }
         }
         monthCnt++;
         calendarBody.appendChild($tr);
     }
    mainTodayDay.innerHTML = dayList[today.getDay()];
    mainTodayDate.innerHTML = today.getDate();
 }
 showCalendar();
 var clickedDate1 = document.getElementById(today.getDate());
 var tdGroup = [];
 clickedDate1.classList.add('active');
 clickStart();
 
 function removeCalendar(){
     let catchTr = 100;
     for(var i = 100; i< 106; i++){
         var $tr = document.getElementById(catchTr);
         $tr.remove();
         catchTr++;
     }
 }
 
 function prev(){
    if(pageFirst.getMonth() === 1){
        pageFirst = new Date(first.getFullYear()-1, 12, 1);
        first = pageFirst;
        if(first.getFullYear() % 4 === 0){
            pageYear = leapYear;
        }else{
            pageYear = notLeapYear;
        }
    }else{
        pageFirst = new Date(first.getFullYear(), first.getMonth()-1, 1);
        first = pageFirst;
    }
    today = new Date(today.getFullYear(), today.getMonth()-1, today.getDate());
    currentTitle.innerHTML = monthList[first.getMonth()] + '&nbsp;&nbsp;&nbsp;&nbsp;'+ first.getFullYear();
    removeCalendar();
    showCalendar();
    showMain();
    clickedDate1 = document.getElementById(today.getDate());
    clickedDate1.classList.add('active');
    clickStart();
    reshowingList();
}

function next(){
    if(pageFirst.getMonth() === 12){
        pageFirst = new Date(first.getFullYear()+1, 1, 1);
        first = pageFirst;
        if(first.getFullYear() % 4 === 0){
            pageYear = leapYear;
        }else{
            pageYear = notLeapYear;
        }
    }else{
        pageFirst = new Date(first.getFullYear(), first.getMonth()+1, 1);
        first = pageFirst;
    }
    today = new Date(today.getFullYear(), today.getMonth() + 1, today.getDate());
    currentTitle.innerHTML = monthList[first.getMonth()] + '&nbsp;&nbsp;&nbsp;&nbsp;'+ first.getFullYear();
    removeCalendar();
    showCalendar(); 
    showMain();
    clickedDate1 = document.getElementById(today.getDate());
    clickedDate1.classList.add('active');  
    clickStart();
    reshowingList();
}

var prevBtn = document.getElementById('prev');
var nextBtn = document.getElementById('next');
prevBtn.addEventListener('click',prev);
nextBtn.addEventListener('click',next);
function clickStart(){
    for(let i = 1; i <= pageYear[first.getMonth()]; i++){
        tdGroup[i] = document.getElementById(i);
        tdGroup[i].addEventListener('click',changeToday);
    }
}
function changeToday(e){
    for(let i = 1; i <= pageYear[first.getMonth()]; i++){
        if(tdGroup[i].classList.contains('active')){
            tdGroup[i].classList.remove('active');
        }
    }
    clickedDate1 = e.currentTarget;
    clickedDate1.classList.add('active');
    today = new Date(today.getFullYear(), today.getMonth(), clickedDate1.id);
    showMain();
    keyValue = today.getFullYear() + '' + today.getMonth()+ '' + today.getDate();
    reshowingList();
    document.getElementById( "date" ).value = today.getFullYear();
    document.getElementById( "date" ).value += today.getMonth() + 1;
    document.getElementById( "date" ).value += today.getDate();
    goList();
}


function showMain(){
    mainTodayDay.innerHTML = dayList[today.getDay()];
    mainTodayDate.innerHTML = today.getDate();
}

function reshowingList(){
    keyValue = today.getFullYear() + '' + today.getMonth()+ '' + today.getDate();

}

var dataCnt = 1;
var keyValue = today.getFullYear() + '' + today.getMonth()+ '' + today.getDate();
function checkList(e){
    e.currentTarget.classList.add('checked');
}

		
  </script>

</html>