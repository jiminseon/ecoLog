//package controller.post;
//
//import java.util.List;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import controller.Controller;
//import controller.user.UserSessionUtils;
//import model.User;	
//import model.service.UserManager;
//import model.Post;
//import model.service.PostManager;
// 
//public class DeletePostController  implements Controller {
//	private static final Logger log = LoggerFactory.getLogger(DeletePostController.class);
//
//	@Override
//	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
//		String postNo = request.getParameter("postNo");
//		log.debug("Delete Post : {}", postNo);
//
//		PostManager pmanager = PostManager.getInstance();		
//		UserManager umanager = UserManager.getInstance();	
//		HttpSession session = request.getSession();
//
//		if ((UserSessionUtils.isLoginUser("admin", session) 	// 로그인한 사용자가 관리자이고 	
//				|| 												// 또는 
//				(!UserSessionUtils.isLoginUser("admin", session) // &&  // 로그인한 사용자가 관리자가 아니고 
//						)) { //post ??? { // 본인이 쓴 글인 경우 -->어떻게 구현?
//			pmanager.delete(postNo);				// 게시글 삭제
//
//			return "/post/list.jsp";
//		} 
//
//		/* 삭제가 불가능한 경우 */
//		Post post = pmanager.findPost(postNo);	// 게시글 검색
//		request.setAttribute("writer", session);						
//		request.setAttribute("deleteFailed", true);
//		String msg = "내가 쓴 글이 아닙니다.";				
//
//		request.setAttribute("exception", new IllegalStateException(msg));            
//		return "/post/deletePost.jsp";		// 삭제 화면으로 이동 (forwarding)	
//	}
//}
