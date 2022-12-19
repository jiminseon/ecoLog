package controller.calculator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Item;
import model.User;
import model.service.CalculatorManager;
import model.service.UserManager;

public class RankController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(RankController.class);
	
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			

    	HttpSession session = request.getSession();

    	UserManager manager = UserManager.getInstance();
    	List<User> rankList = manager.rankList();
    	
    	String Id = (String)session.getAttribute("Id");
    	log.debug("userId" + (String)session.getAttribute("Id"));
    	request.setAttribute("Id", Id);	
    	request.setAttribute("rankList", rankList);	
    	
    	

    	return "/main/main.jsp";
    	
    	
    }
}