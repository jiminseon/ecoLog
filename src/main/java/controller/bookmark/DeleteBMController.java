//package controller.bookmark;
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
//import model.BookMark;
//import model.service.BMManager;
//
//public class DeleteBMController  implements Controller {
//	private static final Logger log = LoggerFactory.getLogger(DeleteBMController.class);
//	@Override
//	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		BookMark bm = new BookMark(request.getParameter("postNo"));
//		
//		String postNo = request.getParameter("postNo");	
//    	log.debug("Delete BookMark : {}", bm);
//
//		BMManager manager = BMManager.getInstance();		
//		manager.delete(postNo);	
//		 
//    	return "/post/list.jsp";
//	}
//}
