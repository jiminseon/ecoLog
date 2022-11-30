package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.MyMeeting;
import model.service.UserManager;

public class createMyMeetingController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	// POST request (회원정보가 parameter로 전송됨)
       	MyMeeting mymt = new MyMeeting(
			request.getParameter("postNum"),
			request.getParameter("Id"));
		
		try {
			UserManager manager = UserManager.getInstance();
			manager.createMyMeeting(mymt);
			return "/post/postView.jsp";        	// 성공 시 사용자 리스트 화면으로 redirect
	        
		} catch (Exception e) {
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("bm", mymt);
			return "/post/postView.jsp";        
		}
    }
}
