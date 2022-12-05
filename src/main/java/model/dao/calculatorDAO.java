package model.dao;

import java.sql.SQLException;

import model.Calculator;


public class calculatorDAO {
	private JDBCUtil jdbcUtil = null;
	
	public calculatorDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	/**
	 * 모임 추가
	 */
	public int create(Calculator cal) throws SQLException {
		String sql = "INSERT INTO calculator(cal_day, cal_content, cal_point, color, userid) VALUES (Seq_mm.nextval,?, ?)";		
		Object[] param = new Object[] {cal.getCal_day(), cal.getCal_content(), cal.getCal_point(), cal.getColor(), cal.getUserid()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
						
		try {				
			int result = jdbcUtil.executeUpdate();	// insert 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;			
	}
}
