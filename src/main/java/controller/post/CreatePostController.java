package controller.post;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Post;
import model.dao.mybatis.PostDAO;
import model.service.UserManager;

public class CreatePostController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(UpdatePostController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Post post = new Post(
	    		0, request.getParameter("title"),
				request.getParameter("writer"),
				request.getParameter("category"),
				request.getParameter("content"), null, 0);
		
			try {
				UserManager manager = UserManager.getInstance();
				manager.postInsert(post);
				
		    	log.debug("Create Post : {}", post);
		        return "redirect:/post/postList";
		        
			} catch (Exception e) {	
	            request.setAttribute("creationFailed", true);
				request.setAttribute("exception", e);
				request.setAttribute("post", post);
				return "/post/postWrite.jsp";
			}
	    }
}
