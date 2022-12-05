//package controller.post;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import model.Post;
//import model.service.*;
//
//public class ListPostController {
//	@Override
//    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
//		
//    	PostManager manager = PostManager.getInstance();
//		List<Post> postList = manager.findPostList();
//
//		request.setAttribute("postList", postList);				
//		return "/post/postList.jsp";        	
//    }	
//
//}
