package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Calculator;
import model.Item;


public class calculatorDAO {
	
	private JDBCUtil jdbcUtil = null;
	
	public calculatorDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	public int create(Calculator cal) throws SQLException {
		String sql = "INSERT INTO calendar(cal_day, cal_content, cal_point, userid, calnum) VALUES (?, ?, ?, ?, cal_seq.nextval)";		
		Object[] param = new Object[] {cal.getCal_day(), cal.getCal_content(), cal.getCal_point(), cal.getUserid() };				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
		System.out.println(cal.getCal_day()+ cal.getCal_content()+ cal.getCal_point()+ cal.getUserid());
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
	
	public List<Item> findItemList() throws SQLException {
        String sql = "SELECT activity, itemPoint, itemId " 
        		   + "FROM item "
        		   + "ORDER BY itemId";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<Item> ItemList = new ArrayList<Item>();	// User들의 리스트 생성
			while (rs.next()) {
				Item item = new Item(	
					rs.getString("activity"),
					rs.getInt("itemPoint"),
					rs.getInt("itemId")
						);

				System.out.println(rs.getString("activity"));
				ItemList.add(item);				// List에 User 객체 저장
			}		
			
			return ItemList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	public List<Calculator> findActivityList(String cal_day, String userId) throws SQLException {
        String sql = "SELECT cal_day, cal_content, cal_point, userid, calnum " 
        		   + "FROM calendar "
        		   + "WHERE cal_day=? and userid=?";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {cal_day, userId});		// JDBCUtil에 query문 설정
					
		System.out.println(cal_day);
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<Calculator> calList = new ArrayList<Calculator>();	// User들의 리스트 생성
			while (rs.next()) {
				Calculator cal = new Calculator(	
					rs.getString("cal_day"),
					rs.getString("cal_content"),
					rs.getInt("cal_point"),
					rs.getString("userid"),
					rs.getInt("calnum")
						);

				System.out.println("중복" + rs.getString("cal_day"));
				calList.add(cal);				// List에 User 객체 저장
			}		
			
			return calList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	public int findActivityPoint(String cal_content) throws SQLException {
        String sql = "SELECT itempoint " 
        		   + "FROM item "
        		   + "WHERE activity=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {cal_content});		// JDBCUtil에 query문 설정
					
		System.out.println("내용은" + cal_content);
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			rs.next();
			System.out.println("포인트"+ rs.getInt("itempoint"));
			return rs.getInt("itempoint");					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return -1;
	}
	
	public int remove(String calNum) throws SQLException {
		String sql = "DELETE FROM calendar WHERE calNum=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {calNum});	// JDBCUtil에 delete문과 매개 변수 설정

		try {				
			int result = jdbcUtil.executeUpdate();	// delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}
	
}
