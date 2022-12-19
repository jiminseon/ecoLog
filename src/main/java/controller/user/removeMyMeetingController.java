package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.post.BookMarkController;
import model.service.UserManager;

public class removeMyMeetingController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(removeMyMeetingController.class);
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		String postNum = request.getParameter("postNum");

		UserManager manager = UserManager.getInstance();	

       	log.debug("postNum---" + postNum);
			manager.removeMyMeeting(postNum);				
			return "redirect:/user/MyMeeting";	
	}
}

