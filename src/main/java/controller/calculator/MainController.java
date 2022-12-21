package controller.calculator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Item;
import model.Post;
import model.User;
import model.service.CalculatorManager;
import model.service.UserManager;

public class MainController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			

    	HttpSession session = request.getSession();

    	UserManager manager = UserManager.getInstance();
    	String Id = (String)session.getAttribute("Id");
    			
		User user = manager.findUser(Id);	// 수정하려는 사용자 정보 검색
		request.setAttribute("user", user);
    	
    	List<User> rankList = manager.rankList();
    	
    	List<Post> postList = manager.getPostListLast();
		log.debug("PostList" + postList);		
		request.setAttribute("postList", postList);	
    	
    	;
    	log.debug("userId" + (String)session.getAttribute("Id"));
    	request.setAttribute("Id", Id);	
    	request.setAttribute("rankList", rankList);	
    	
    	

    	return "/main/main.jsp";
    	
    	
    }
}