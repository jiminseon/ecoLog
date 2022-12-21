package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.UserManager;

public class DeletePostController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int postNum = Integer.parseInt(request.getParameter("postNum"));
		
		UserManager manager = UserManager.getInstance();
		manager.postDelete(postNum);
		
		return "redirect:/post/postList";
	}

}
