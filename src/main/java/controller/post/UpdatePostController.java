package controller.post;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.*;	
import model.service.*;

public class UpdatePostController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(UpdatePostController.class);
 
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		if (request.getMethod().equals("GET")) {	
			String updatePost = request.getParameter("postNo");

			HttpSession session = request.getSession();
			
			log.debug("Post Update : {}", session);

			UserManager manager = UserManager.getInstance();
			Post post = manager.findPost(updatePost);	// 수정하려는 게시글 검색
			request.setAttribute("user", session);			

			if (/*userSession같은 postSession만든 후 / post의 writer인 경우*/)
			{
				return "/post/list.jsp";       
			}    
			//반대로 아닌경우 else 타인이 쓴 글은 수정할 수 없습니다 
		}

		//POST방식 | 업데이트한 게시물 정보 전송
		Post post = new Post(
				request.getParameter("title"),
				request.getParameter("content"));

		log.debug("Post Update : {}", session);
		UserManager manager = UserManager.getInstance();
		manager.postUpdate(post);

		return "redirect:/post/list";
	}
}