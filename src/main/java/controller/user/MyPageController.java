package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.User;
import model.service.UserManager;
import model.service.UserNotFoundException;

public class MyPageController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		// 로그인 여부 확인

		HttpSession session = request.getSession();
        //System.out.println("세션 id : "+session.getAttribute("Id"));
        
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
        	System.out.println("로그인 실패");
            return "redirect:/user/login/form";		// login form 요청으로 redirect
        }
    	
    	System.out.println("마이페이지/ 로그인 성공");
		UserManager manager = UserManager.getInstance();
		String Id = (String)session.getAttribute("Id");
		System.out.println("지금 ID는 ? "+Id);
		
		User user = null;
		try {
		user = manager.findUser(Id);
		}catch (UserNotFoundException e) {
			System.out.println("실패!");
			return "redirect:/main";
		}
		
		request.setAttribute("user", user);	
		System.out.println("myPage jsp로 출발");
		return "/user/myPage.jsp";        
    }
}
