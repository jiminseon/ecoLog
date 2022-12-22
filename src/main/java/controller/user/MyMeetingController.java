package controller.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.post.BookMarkController;
import model.BookMark;
import model.MyMeeting;
import model.Post;
import model.dao.MyMeetingDAO;
import model.dao.bookMarkDAO;
import model.dao.postDAO;
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
			
			List<Post> pList = new ArrayList<Post>();	// User들의 리스트 생성
			Iterator<MyMeeting> meetIter = meetingList.iterator();
			int i = 0;
			 while ( meetIter.hasNext() ) {
				 MyMeeting meet = (MyMeeting)meetIter.next();
				 postDAO postDao = new postDAO();
				 Post post = postDao.postDetailData(Integer.parseInt(meet.getPostNum()));
				 pList.add(post);
				 log.debug(post.getTitle() + " --- post" + i++);
			}	
			 request.setAttribute("pList", pList);	
			
			return "/user/myMeeting.jsp";        
	    }
}
