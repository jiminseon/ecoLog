//package controller.post;
//
//import java.util.List;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import controller.Controller;
//import model.Post;
//import model.service.PostManager;
// 
//public class ListPostController implements Controller {
//
//	PostManager manager = PostManager.getInstance();
//	List<Post> postList = manager.findPostList();
//
//	@Override
//	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {	  
//		//게시글 리스트 화면으로 이동(forwarding)
//		return "/post/list.jsp";
//	}
//
//}
