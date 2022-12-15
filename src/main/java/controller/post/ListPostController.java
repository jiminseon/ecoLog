package controller.post;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.BookMark;
import model.Post;
import model.dao.bookMarkDAO;
import model.service.*;

  public class ListPostController implements Controller {
	  private static final Logger log = LoggerFactory.getLogger(BookMarkController.class);
		 @Override
		    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {

				log.debug("hii");		
			 //post 방식
			 UserManager manager = UserManager.getInstance();
			 //String userId = request.getParameter("userId");
			 String id = "tt";
			
				return "/post/postIndex.jsp";        
		    }
  }
 
