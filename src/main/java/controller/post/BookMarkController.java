package controller.post;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.BookMark;
import model.Post;
import model.dao.bookMarkDAO;
import model.dao.postDAO;
import model.service.UserManager;

public class BookMarkController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(BookMarkController.class);
	 @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
			HttpSession session = request.getSession();
			log.debug("hii");		
		 //post 방식
		 UserManager manager = UserManager.getInstance();
		 //String userId = request.getParameter("userId");
		 String id = (String)session.getAttribute("Id");
		List<BookMark> bmList = manager.getBookMark(id);

		bookMarkDAO bookMarkDao = new bookMarkDAO();
		int cnt = bookMarkDao.getNumberOfBookMark(id);
		request.setAttribute("cnt", cnt);	
		int k = 0;
		log.debug("bmList22" + bmList);		
			request.setAttribute("bmList", bmList);	
			List<Post> pList = new ArrayList<Post>();	// User들의 리스트 생성
			Iterator<BookMark> BookMarkIter = bmList.iterator();
			
			 while ( BookMarkIter.hasNext() ) {
				 BookMark bookMark = (BookMark)BookMarkIter.next();
				postDAO postDao = new postDAO();
				 Post post = postDao.postDetailData(Integer.parseInt(bookMark.getPostNum()));
				pList.add(post);
				//log.debug(post.getTitle() + " +++ post");
			}	
			 request.setAttribute("pList", pList);	
			
			return "/user/bookMarkList.jsp";        
	    }
}

