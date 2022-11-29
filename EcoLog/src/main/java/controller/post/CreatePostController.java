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
//import model.Post;
//import model.service.ExistingPostException;
//import model.service.PostManager;
// 
//public class CreatePostController implements Controller {
//	 private static final Logger log = LoggerFactory.getLogger(CreatePostController.class);
//	@Override
//    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
//		// 로그인 여부 확인
//    	if (!UserSessionUtils.hasLogined(request.getSession())) {
//            return "redirect:/user/registerForm";		// login form 요청으로 redirect
//        }
//
//    	HttpSession session = request.getSession();	
//    	
//    	// userList 객체와 현재 로그인한 사용자 ID를 request에 저장하여 전달
//    	request.setAttribute("userList", session);		 		
//    	request.setAttribute("curUserId", UserSessionUtils.getLoginUserId(request.getSession()));	
//
//    	Post post = new Post(
//				request.getParameter("category"),
//				request.getParameter("title"),
//				request.getParameter("text"));
//
//    	log.debug("Create Post : {}", post);
//
//    	try {
//			PostManager manager = PostManager.getInstance();
//			manager.create(post);
//	        return "redirect:/post/list";		// 성공 시 게시글 리스트 화면으로 redirect
//
//		} catch (ExistingPostException e) {		// 예외 발생 시 회원가입 form으로 forwarding
//            request.setAttribute("registerFailed", true);
//			request.setAttribute("exception", e);
//			request.setAttribute("post", post);
//			return "/user/registerForm.jsp";		
//		}
//	}
//}