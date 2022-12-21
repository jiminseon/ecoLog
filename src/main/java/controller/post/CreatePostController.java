package controller.post;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Post;
import model.service.UserManager;

public class CreatePostController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Date date = new Date(0,0,0);
		String postNum = request.getParameter("postNum");
		int pNum = Integer.parseInt(postNum);
		
		try {
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		    date = (Date) formatter.parse(request.getParameter("writeDate"));

		} catch (ParseException ex) {
		    ex.printStackTrace();
		}
		
		Post post = new Post(
				Integer.parseInt(request.getParameter("postNum")),
				request.getParameter("title"),
				request.getParameter("writer"),
				request.getParameter("category"),
				request.getParameter("content"),
				0, date);		
		try {
			UserManager manager = UserManager.getInstance();
			manager.postInsert(post);
			return "redirect:/post/postView.jsp?postNum=" + pNum;
		} catch(Exception e) {
			request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("post", post);
			return "/post/postList.jsp";
		}
	}
}