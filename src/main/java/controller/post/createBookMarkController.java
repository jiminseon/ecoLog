package controller.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.BookMark;
import model.User;
import model.service.ExistingUserException;
import model.service.UserManager;

public class createBookMarkController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	// POST request (회원정보가 parameter로 전송됨)
       	BookMark bm = new BookMark(
			request.getParameter("postNum"),
			request.getParameter("userId"));
		
		try {
			UserManager manager = UserManager.getInstance();
			manager.createBookMark(bm);
			return "/post/post.jsp";        	// 성공 시 사용자 리스트 화면으로 redirect
	        
		} catch (Exception e) {
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("bm", bm);
			return "/post/post.jsp";        
		}
    }
}
