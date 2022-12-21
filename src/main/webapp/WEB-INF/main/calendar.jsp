<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <div class="content-wrap">
      <div class="content-left">
        <div class="main-wrap">
          <div id="main-day" class="main-day"></div>
          <div id="main-date" class="main-date" ></div>
			<button class="w-btn-outline w-btn-green-outline" type="button" onclick="goCal()">활동SAVE</button>
        </div>
        <div class="todo-wrap">
          <div class="todo-title"></div>
          <div class="calculator">
		    <p/>
        	
        </div>
      </div>
      </div>
      <div class="content-right">
      
        <table id="calendar" align="center">
          <thead>
            <tr class="btn-wrap clearfix">
              <td>
                <label id="prev">
                    &#60;
                </label>
              </td>
              <td align="center" id="current-year-month" colspan="5"></td>
              <td>
                <label id="next">
                    &#62;
                </label>
              </td>
            </tr>
            <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
            <tr>
                <td class = "sun" align="center">Sun</td>
                <td align="center">Mon</td>
                <td align="center">Tue</td>
                <td align="center">Wed</td>
                <td align="center">Thu</td>
                <td align="center">Fri</td>
                <td class= "sat" align="center">Sat</td>
              </tr>
          </thead>
          <tbody id="calendar-body" class="calendar-body"></tbody>
        </table>
      </div>
    </div>
