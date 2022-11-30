package controller.post;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Community;
import model.Post;
import model.service.*;

public class ListPostController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		UserManager manager = UserManager.getInstance();
		List<Post> postList = manager.findPostList();
		
		// postList 객체를 request에 저장하여 커뮤니티 리스트 화면으로 이동(forwarding)
		request.setAttribute("postList", postList);				
		return "/post/postList.jsp";   
		
		return null;
	}
	
	/*
	 * private postService postService;
	 * 
	 * @GetMapping("postList") public String postList(Post post) {
	 * 
	 * ArrayList<Post> postList = postService.postList();
	 * post.addAttribute("postList", postList);
	 * 
	 * return "/postList"; }
	 */
		

}
