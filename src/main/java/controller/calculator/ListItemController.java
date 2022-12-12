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

		request.setAttribute("itemList", itemList);
		request.setAttribute("point", itemList.get(0).getItemPoint());
		
		return "/main/calculator.jsp"; 
    }
}
