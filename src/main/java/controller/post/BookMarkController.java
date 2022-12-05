package controller.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.BookMark;
import model.service.UserManager;

public class BookMarkController implements Controller {
	 @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
			
		 //post 방식
		 UserManager manager = UserManager.getInstance();
		 String userId = request.getParameter("userId");
		List<BookMark> bmList = manager.getBookMark(userId);
			
			request.setAttribute("bmkList", bmList);				
			
			return "/user/bookMark.jsp";        
	    }
}

