package controller.calculator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Calculator;
import model.service.CalculatorManager;

public class ListCalendarController implements Controller { 
	private static final Logger log = LoggerFactory.getLogger(ListItemController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	
    	
		CalculatorManager manager = CalculatorManager.getInstance();
		String cal_day = request.getParameter("cal_day");
		String userId = request.getParameter("userId");
		System.out.println("날짜랑 아이디" + cal_day + userId);
		List<Calculator> calList = manager.findActivityList(cal_day, userId);
		

		log.debug(calList + "calList");
		request.setAttribute("calList", calList);
		
		// 사용자 리스트 화면으로 이동(forwarding)
		return "/main/calList.jsp"; 		
    	
    }
}
