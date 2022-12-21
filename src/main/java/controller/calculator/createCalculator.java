package controller.calculator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Calculator;
import model.service.CalculatorManager;
import model.service.UserManager;



public class createCalculator implements Controller {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	// POST request (회원정보가 parameter로 전송됨)

		
		try {
			CalculatorManager manager = CalculatorManager.getInstance();
			UserManager userManager = UserManager.getInstance();
			
	    	String cal_content = request.getParameter("cal_content");
	    	int point = manager.findActivityPoint(cal_content);
	    	
	    	
	    	String userId = request.getParameter("userId");
	    	System.out.println(userId);
	    	
	    	int num = userManager.savePoint(point, userId);
	    	
	       	Calculator cal = new Calculator(
				request.getParameter("cal_day"),
				cal_content,
				point,
				userId, 0);
	       	
			manager.create(cal);
			return "redirect:/main";       
	        
		} catch (Exception e) {
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			return "/user/login/form";        
		}
    }
}
