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

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int postNum = Integer.parseInt(request.getParameter("postNum"));
		
		if (request.getMethod().equals("GET")) {	
    		// GET request: 커뮤니티 수정 form 요청	
    		UserManager manager = UserManager.getInstance();
			Post post = manager.postFind(postNum);	// 수정하려는 post 정보 검색
			request.setAttribute("Post", post);		
				
			return "/post/postUpdate.jsp";   // 검색한 정보를 update form으로 전송     
	    }	
    	
    	// POST request (커뮤니티 정보가 parameter로 전송됨)
		int visitCnt = Integer.parseInt(request.getParameter("visitCount"));
    	Post post = new Post(
    		postNum, request.getParameter("title"),
    		request.getParameter("writer"), request.getParameter("category"), 
    		request.getParameter("content"), null, 0);

    	log.debug("Update Post : {}", post);

		UserManager manager = UserManager.getInstance();
		manager.postUpdate(post);		
        return "redirect:/post/postList";			
    }
}