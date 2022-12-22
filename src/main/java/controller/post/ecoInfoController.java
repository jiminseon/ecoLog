package controller.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.BookMark;
import model.dao.bookMarkDAO;
import model.service.UserManager;

public class ecoInfoController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(ecoInfoController.class);
	 @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
			HttpSession session = request.getSession();
			log.debug("hii22");		
		
			return "/ecoInfo/ecoInfo1.jsp";        
	    }
}