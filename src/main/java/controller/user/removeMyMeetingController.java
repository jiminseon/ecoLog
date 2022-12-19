package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.UserManager;

public class removeMyMeetingController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		String postNum = request.getParameter("postNum");

		UserManager manager = UserManager.getInstance();	
	
			manager.removeMyMeeting(postNum);				
			return "redirect:/user/myMeetings";	
	}
}

