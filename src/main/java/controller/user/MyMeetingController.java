package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.MyMeeting;
import model.service.UserManager;

public class MyMeetingController implements Controller {
	 @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
			
		 //post 방식
		 UserManager manager = UserManager.getInstance();
		 String userId = request.getParameter("userId");
			List<MyMeeting> meetingList = manager.getMyMeeting(userId);
			
			request.setAttribute("meetingList", meetingList);				
			
			return "/user/myMeeting.jsp";        
	    }
}
