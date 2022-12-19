package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.post.BookMarkController;
import model.MyMeeting;
import model.service.UserManager;

public class createMyMeetingController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(BookMarkController.class);
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	// POST request (회원정보가 parameter로 전송됨)
    	HttpSession session = request.getSession();
       	MyMeeting mymt = new MyMeeting(
			"meeting2",(String)session.getAttribute("Id"));
       	log.debug("userId" + (String)session.getAttribute("Id"));		
		
		try {
			UserManager manager = UserManager.getInstance();
			manager.createMyMeeting(mymt);
			return "redirect:/user/MyMeeting";        	// 성공 시 사용자 리스트 화면으로 redirect
	        
		} catch (Exception e) {
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("bm", mymt);
			return "redirect:/user/MyMeeting";        
		}
    }
}
