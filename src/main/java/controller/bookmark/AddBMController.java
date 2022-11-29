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
//public class AddBMController implements Controller {
//	private static final Logger log = LoggerFactory.getLogger(AddBMController.class);
//	@Override
//	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		
//		BookMark bm = new BookMark(request.getParameter("postNo"));
//
//    	log.debug("Add BookMark : {}", bm);
//    	 
//    	return "/post/list.jsp ";
//	}
//}
