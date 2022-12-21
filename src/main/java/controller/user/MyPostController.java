package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.MyMeeting;
import model.Post;
import model.User;
import model.dao.MyMeetingDAO;
import model.service.UserManager;

public class MyPostController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(MyPostController.class);
	 @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		 HttpSession session = request.getSession();
	      
		 //post 방식
		 UserManager manager = UserManager.getInstance();

		 String id = (String)session.getAttribute("Id");
		 User user = manager.findUser(id);	
		 
		List<Post> myPostList = manager.myPostList(user.getName());

		
		request.setAttribute("myPostList", myPostList);			
		MyMeetingDAO myMeetingDao = new MyMeetingDAO();
		int cnt = myMeetingDao.getNumberOfMyMt(id);
		request.setAttribute("cnt", cnt);	
		
		return "/user/myPost.jsp";        
    }
}
