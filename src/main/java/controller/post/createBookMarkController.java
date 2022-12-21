package controller.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.BookMark;
import model.MyMeeting;
import model.User;
import model.service.ExistingUserException;
import model.service.UserManager;

public class createBookMarkController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(BookMarkController.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	// POST request (회원정보가 parameter로 전송됨)
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("Id");
    	String postNum = "meeting2";
       	BookMark bm = new BookMark(
       			postNum,id);

       	log.debug("userId" + (String)session.getAttribute("Id"));		
		
		try {
			UserManager manager = UserManager.getInstance();
			if(manager.existingBM(id, postNum) == 0) {
				manager.createBookMark(bm);
			}
			return "redirect:/user/BookMark";        	// 성공 시 사용자 리스트 화면으로 redirect
	        
		} catch (Exception e) {
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("bm", bm);
			return "redirect:/user/BookMark";        
		}
    }
}
