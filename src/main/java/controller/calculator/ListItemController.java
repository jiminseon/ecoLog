package controller.calculator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Calculator;
import model.Item;
import model.service.CalculatorManager;

public class ListItemController implements Controller { 
	private static final Logger log = LoggerFactory.getLogger(ListItemController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			

    	
		CalculatorManager manager = CalculatorManager.getInstance();
		List<Item> itemList = manager.findItemList();
		String cal_day = request.getParameter("20221204");
		System.out.println("날짜request" + cal_day);
		List<Calculator> calList = manager.findActivityList("20221204");
		

		log.debug(calList + "calList");
		// userList 객체와 현재 로그인한 사용자 ID를 request에 저장하여 전달
		request.setAttribute("itemList", itemList);
		request.setAttribute("point", itemList.get(0).getItemPoint());
		request.setAttribute("calList", calList);
		
		// 사용자 리스트 화면으로 이동(forwarding)
		return "/main/calculator.jsp"; 
    }
}
