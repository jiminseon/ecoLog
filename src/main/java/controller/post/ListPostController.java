package controller.post;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.MyMeeting;
import model.Post;
import model.dao.MyMeetingDAO;
import model.dao.mybatis.PostDAO;
import model.service.*;


public class ListPostController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(ListPostController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		 UserManager manager = UserManager.getInstance();
		 List<Post> postList = manager.getPostList();
			log.debug("PostList" + postList);		
			request.setAttribute("postList", postList);			
			PostDAO postDAO = new PostDAO();
			int page = postDAO.postTotalPage();
			request.setAttribute("page", page);	
			
			return "/post/postList.jsp";    
	}
}
