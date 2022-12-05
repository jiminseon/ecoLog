package controller.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.BookMark;
import model.dao.bookMarkDAO;
import model.service.UserManager;

public class BookMarkController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(BookMarkController.class);
	 @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
			
		 //post 방식
		 UserManager manager = UserManager.getInstance();
		 //String userId = request.getParameter("userId");
		 String id = "tt";
		List<BookMark> bmList = manager.getBookMark(id);
		log.debug("bmList22" + bmList);		
			request.setAttribute("bmList", bmList);	
			
			bookMarkDAO bookMarkDao = new bookMarkDAO();
			int cnt = bookMarkDao.getNumberOfBookMark(id);
			request.setAttribute("cnt", cnt);	
			
			return "/user/bookMarkList.jsp";        
	    }
}

