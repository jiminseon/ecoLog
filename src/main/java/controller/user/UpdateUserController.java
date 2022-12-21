package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.UserManager;
import model.User;

public class UpdateUserController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(UpdateUserController.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		if (request.getMethod().equals("GET")) {	
			// GET request: 회원정보 수정 form 요청	

			HttpSession session = request.getSession();
			
			String updateId = (String)session.getAttribute("Id");
			log.debug("UpdateForm Request : {}", updateId);
			System.out.println("updateID: "+updateId);
			
			UserManager manager = UserManager.getInstance();
			User user = manager.findUser(updateId);	// 수정하려는 사용자 정보 검색
			request.setAttribute("user", user);			

			if (UserSessionUtils.isLoginUser(updateId, session) ||
					UserSessionUtils.isLoginUser("admin", session)) {

				System.out.println("updateForm jsp로 이동");
				return "/user/updateForm.jsp";   // 검색한 사용자 정보 및 커뮤니티 리스트를 updateForm으로 전송     
			}    

			// else (수정 불가능한 경우) 사용자 보기 화면으로 오류 메세지를 전달
			request.setAttribute("updateFailed", true);    
			System.out.println("실패!");
			return "/user/myPage.jsp";	// 
		}	

		// POST request (회원정보가 parameter로 전송됨)
		User updateUser = new User(
				request.getParameter("Id"),
				request.getParameter("password"),
				request.getParameter("name"),
				request.getParameter("phoneNumber"),
				request.getParameter("email"),
				request.getParameter("address"),
				request.getParameter("birth"),
				request.getParameter("nickname"));

		log.debug("Update User : {}", updateUser);

		UserManager manager = UserManager.getInstance();
		manager.update(updateUser);			
		return "redirect:/user/myPage";			
	}
}