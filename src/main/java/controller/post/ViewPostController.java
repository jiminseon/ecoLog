package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.UserManager;

public class ViewPostController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int postNum = 0;
		try {
			postNum = Integer.parseInt(request.getParameter("postNum"));
		} catch (NumberFormatException e) {
			postNum = 0;
		}
		
		UserManager manager = UserManager.getInstance();
		manager.postView(postNum);
		
		return "/post/postView.jsp?postNum=" + postNum;
	}
	
}
