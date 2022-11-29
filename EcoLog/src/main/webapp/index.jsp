<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel=stylesheet href="<c:url value='/css/calendar.css' />" type="text/css">
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
<title>메인</title>
<style>
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
	  width: 1100px;
	  margin: auto;
	}
	div.tleft, div.bleft {
	  width: 240px;
	  float: left;
	  margin-right: 10px;
	  box-sizing: border-box;
	  border: 1px solid #003458;
	}
	div.tright {
	  width: 850px;
	  float: right;
	  box-sizing: border-box;
	}
	div.bright {
	  width: 850px;
	  float: right;
	  box-sizing: border-box;
	  border: 1px solid #003458;
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
function login() {
	if (form.userId.value == "") {
		alert("사용자 ID를 입력하십시오.");
		form.userId.focus();
		return false;
	} 
	if (form.password.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.password.focus();
		return false;
	}		
	form.submit();
}

function userCreate(targetUri) {
	form.action = targetUri;
	form.method="GET";		// register form 요청
	form.submit();
}

</script>
</head>
<body>
<header>
	<div class="head">
	<a href="loginForm.jsp">로그인</a>
	<a href="registerForm.jsp">회원가입</a>
	<a href="myPage.jsp">마이페이지</a>
	</div>
	<p/><font size='7' color='004300' weight="bold">EcoLog</font>
</header>
<div class="wrap">
	<div class="top">
		<div class="tleft">
			<!-- 로그인 되어있을 때는 character.jsp가 뜨도록 구현해두기 -->
		</div>
		<div class="tright">
		   <%@ include file="main.jsp" %>
		</div>
	</div>
	<p/><p/><p/>
	<div class="bottom">
		<div class="bleft">
			<%@ include file="rank.jsp" %>
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

var clickedDate1 = document.getElementById(today.getDate());
clickedDate1.classList.add('active');
var prevBtn = document.getElementById('prev');
var nextBtn = document.getElementById('next');
prevBtn.addEventListener('click',prev);
nextBtn.addEventListener('click',next);
var tdGroup = [];
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

function new_window() {
    window.open(
      "calculator.jsp",
      "Child",
      "width=400, height=300, top=50, left=50"
    );
  }
		
  </script>
</html>