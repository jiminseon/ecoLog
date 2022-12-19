package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.post.BookMarkController;


public class ForwardController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(ForwardController.class);
    private String forwardUrl;

    public ForwardController(String forwardUrl) {
        if (forwardUrl == null) {
            throw new NullPointerException("forwardUrl is null. 이동할 URL을 입력하세요.");
        }
        this.forwardUrl = forwardUrl;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    	HttpSession session = req.getSession();
    	
    	String Id = (String)session.getAttribute("Id");
    	log.debug("userId" + (String)session.getAttribute("Id"));
    	req.setAttribute("Id", Id);	
        return forwardUrl;
    }
}
