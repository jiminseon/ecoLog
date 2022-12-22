package controller.post;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Post;
import model.dao.mybatis.PostDAO;
import model.service.UserManager;

public class CreatePostController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(UpdatePostController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String category = request.getParameter("category");

		Post post = new Post(title, writer, category, content);
		
		PostDAO dao = new PostDAO();
		int succ = dao.postInsert(post);
		
		response.setContentType("text/html; charset = utf-8"); //MIME 설정
		PrintWriter out =response.getWriter(); 
		if(succ > 0) {
			out.println("<script> alert('등록 완료되었습니다.');");
			out.println("location.href = '<c:url value='/post/postList' />';</script>");
		} else {
			out.println("<script> alert('등록 실패했습니다.');");
			out.println("location.href = '<c:url value='/post/postList' />';</script>");
		}
		return "redirect:/post/postList"; 
					
	}
}