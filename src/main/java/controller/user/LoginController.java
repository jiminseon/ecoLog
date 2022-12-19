package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.User;
import model.service.UserManager;

public class LoginController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	if (request.getMethod().equals("GET")) {	
//    		// GET request: 회원정보 등록 form 요청	
    		
			return "/user/loginForm.jsp";  
	    }	
    	String Id = request.getParameter("Id");
		String password = request.getParameter("password");
		System.out.println("id : "+Id+" PW :"+password);
		try {
			// 모델에 로그인 처리를 위임
			UserManager manager = UserManager.getInstance();
			System.out.println("로그인 비교 시작");
			manager.login(Id, password);
			if(manager.login(Id, password)) 
				System.out.println("True");
			// 세션에 사용자 이이디 저장
			HttpSession session = request.getSession();
            session.setAttribute(UserSessionUtils.USER_SESSION_KEY, Id);
    		
            return "redirect:/user/allow";			
		} catch (Exception e) {
			/* UserNotFoundException이나 PasswordMismatchException 발생 시
			 * 다시 login form을 사용자에게 전송하고 오류 메세지도 출력
			 */
            request.setAttribute("loginFailed", true);
			request.setAttribute("exception", e);
            return "/user/loginForm.jsp";			
		}	
    }
}
