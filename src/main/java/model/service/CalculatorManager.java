package model.service;

import java.sql.SQLException;

import model.Calculator;
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
}
