package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Calculator;
import model.Item;
import model.dao.calculatorDAO;



public class CalculatorManager {
	private static CalculatorManager calculatorManager = new CalculatorManager();
	private  calculatorDAO calDAO;

	public CalculatorManager() {
		try {
			calDAO = new calculatorDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static CalculatorManager getInstance() {
		return calculatorManager;
	}
	
    public int create(Calculator cal) throws SQLException, ExistingUserException {
        return calDAO.create(cal);
    }
    
	public List<Item> findItemList() throws SQLException {
		return calDAO.findItemList();
	}
	
    
	public List<Calculator> findActivityList(String cal_day, String userId) throws SQLException {
		return calDAO.findActivityList(cal_day, userId);
	}
	
	public int findActivityPoint(String cal_content) throws SQLException {
		return calDAO.findActivityPoint(cal_content);
	}
	
	public int removeCalList(String calNum) throws SQLException {
		return calDAO.remove(calNum);				
	}
}
