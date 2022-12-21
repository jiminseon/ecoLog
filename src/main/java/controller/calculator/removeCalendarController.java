package controller.calculator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.CalculatorManager;

public class removeCalendarController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(removeCalendarController.class);
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		String calNum = request.getParameter("calNum");

		CalculatorManager manager = CalculatorManager.getInstance();	

       	log.debug("calNum---" + calNum);
			manager.removeCalList(calNum);				
			return "redirect:/cal/list";	
	}
}
