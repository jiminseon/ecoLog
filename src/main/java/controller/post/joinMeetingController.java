package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.user.RegisterUserController;
import controller.user.UserSessionUtils;
import model.BookMark;
import model.MyMeeting;
import model.User;
import model.service.ExistingUserException;
import model.service.UserManager;

public class joinMeetingController implements Controller{
    private static final Logger log = LoggerFactory.getLogger(joinMeetingController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
   		HttpSession session = request.getSession();
        if (request.getMethod().equals("GET")) {	
       		log.debug("HIHI");
       		
            UserManager manager = UserManager.getInstance();
			User user = manager.findUser((String)session.getAttribute("Id"));
			log.debug("findUser");
//    		// GET request: 회원정보 등록 form 요청	
			log.debug("joinnn" + user.toString());
			request.setAttribute("user", user);
			String postNum = "meeting2";
			request.setAttribute("postNum", postNum);
			return "/post/joinForm.jsp";   // 검색한 커뮤니티 리스트를 registerForm으로 전송     	
	    }	

    	String id = (String)session.getAttribute("Id");
    	String postNum = "meeting2";
       	MyMeeting mymt = new MyMeeting(
       			postNum,id);
       	log.debug("userId--" + id + "post====" + postNum);		
		
		try {
			UserManager manager = UserManager.getInstance();
			if(manager.existingMM(id, postNum) == 0) {
				log.debug("manager.existingMM(id, postNum) ----" + manager.existingMM(id, postNum));	
				manager.createMyMeeting(mymt);
			}
			return "redirect:/user/MyMeeting";  	// 성공 시 리스트로 redirect
	        
		} catch (Exception e) {	// 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("myMt", mymt);
			return "redirect:/user/MyMeeting";
		}
    }
}
