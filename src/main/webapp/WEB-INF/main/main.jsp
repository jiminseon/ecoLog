<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*, model.User, controller.user.*" %>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<link rel=stylesheet href="<c:url value='/css/calendar.css' />" type="text/css">
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
<title>메인</title>
<style>
body{
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
     width: 1250px;
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
     width: 900px;
     float: right;
     box-sizing: border-box;
   }
   div.bright {
     width: 900px;
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

</style>

<script>
function goCal() {
	var now = new Date();
	var str = document.getElementById( "current-year-month" ).innerHTML;
    var day = document.getElementById( "main-date" ).innerHTML;
    var words = str.split("&nbsp;");
    
	if (monthList[now.getMonth()] == words[0] && now.getFullYear().toString() == words[4] && day == now.getDate().toString()) {
		window.name = "index";
		var url = "<c:url value='/cal/calulator'></c:url>"
		window.open(url,width=50, height=50);
	}
	else {
		alert("오늘 날짜만 입력 가능");		
	}
}

function goList() {
	window.name = "index";
	var url = "<c:url value='/cal/list'></c:url>"
	window.open(url,width=50, height=50);
}
</script>
</head>
<body>
<header>
	<div class="head">
	<a href="<c:url value='/user/myPage'></c:url>">마이페이지</a>
	</div>
	<p/><font size='7' color='004300' weight="bold">EcoLog</font>
</header>
<div class="wrap">
	<div class="top">
		<div class="tleft">
			<!-- 로그인 되어있을 때는 character.jsp가 뜨도록 구현해두기 -->
		</div>
		<div class="tright">
		   <%@ include file="/WEB-INF/main/calendar.jsp" %>
		</div>
	</div>
	<p/><p/><p/>
	<div class="bottom">
		<div class="bleft">
			<%@ include file="/WEB-INF/main/rank.jsp" %>
		</div>
		<div class="bright">
			게시판 jsp 연결
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