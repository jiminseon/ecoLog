/*
 * package controller.post;
 * 
 * import java.util.List; import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory;
 * 
 * import controller.Controller; import controller.user.*; import model.Post;
 * import model.service.UserManager; import controller.*;
 * 
 * public class CreatePostController implements Controller { private static
 * final Logger log = LoggerFactory.getLogger(CreatePostController.class);
 * 
 * @Override public String execute(HttpServletRequest request,
 * HttpServletResponse response) throws Exception { // POST request (회원정보가
 * parameter로 전송됨) Post post = new Post( request.getParameter("postNum"),
 * request.getParameter("userId"));
 * 
 * try { UserManager manager = UserManager.getInstance();
 * manager.createMyMeeting(post); return "/post/postView.jsp"; // 성공 시 사용자 리스트
 * 화면으로 redirect
 * 
 * } catch (Exception e) { request.setAttribute("registerFailed", true);
 * request.setAttribute("exception", e); request.setAttribute("bm", mymt);
 * return "/post/postView.jsp"; } } }
 * 
 * }
 */