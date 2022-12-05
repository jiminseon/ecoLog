package controller.calculator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Calculator;
import model.service.CalculatorManager;



public class createCalculator implements Controller {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	// POST request (회원정보가 parameter로 전송됨)
    	
    	HttpSession session = request.getSession();
    	
    	int point = 0;
    	String userid = (String)session.getAttribute("id");	
    	
    	System.out.println(userid);
       	Calculator cal = new Calculator(
			request.getParameter("cal_day"),
			request.getParameter("cal_content"),
			point,
			userid);
		
		try {
			CalculatorManager manager = CalculatorManager.getInstance();
			manager.create(cal);
			return "redirect:";       
	        
		} catch (Exception e) {
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			return "/user/login/form";        
		}
    }
}
