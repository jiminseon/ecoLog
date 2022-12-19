package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.user.removeMyMeetingController;
import model.User;
import model.service.UserManager;

public class removeBookMarkController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(removeBookMarkController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		String postNum = request.getParameter("postNum");

       	log.debug("postNum2---" + postNum);
		UserManager manager = UserManager.getInstance();	
	
			manager.removeBookMark(postNum);				
			return "redirect:/user/BookMark";	
	}
}

