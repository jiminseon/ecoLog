package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.post.BookMarkController;
import model.MyMeeting;
import model.dao.MyMeetingDAO;
import model.dao.bookMarkDAO;
import model.service.UserManager;

public class MyMeetingController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(MyMeetingController.class);
	 @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		 HttpSession session = request.getSession();
	      
		 //post 방식
		 UserManager manager = UserManager.getInstance();
		// String id = request.getParameter("Id");
		 String id = (String)session.getAttribute("Id");
			List<MyMeeting> meetingList = manager.getMyMeeting(id);
			log.debug("meetingList22" + meetingList);		
			request.setAttribute("meetingList", meetingList);			
			MyMeetingDAO myMeetingDao = new MyMeetingDAO();
			int cnt = myMeetingDao.getNumberOfMyMt(id);
			request.setAttribute("cnt", cnt);	
			
			return "/user/myMeeting.jsp";        
	    }
}
