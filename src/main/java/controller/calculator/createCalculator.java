package controller.calculator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

import model.Calculator;
import model.service.CalculatorManager;



public class createCalculator implements Controller {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	// POST request (회원정보가 parameter로 전송됨)
    	
    	int point = (int)Integer.parseInt(request.getParameter("cal_point"));
    	int customerid = (int)Integer.parseInt(request.getParameter("userid"));
    	
    	
       	Calculator cal = new Calculator(
			request.getParameter("cal_day"),
			request.getParameter("cal_content"),
			point,
			request.getParameter("color"),
       			customerid);
		
		try {
			CalculatorManager manager = CalculatorManager.getInstance();
			manager.create(cal);
			return "/";        	// 성공 시 사용자 리스트 화면으로 redirect
	        
		} catch (Exception e) {
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			return "/user/login/form";        
		}
    }
}
