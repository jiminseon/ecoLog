package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.MyMeeting;

public class MyMeetingDAO {
	private JDBCUtil jdbcUtil = null;
	
	private static final Logger log = LoggerFactory.getLogger(bookMarkDAO.class);

	public MyMeetingDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	/**
	 * 모임 추가
	 */
	public int create(MyMeeting mymt) throws SQLException {
		String sql = "INSERT INTO myMeeting(myMtId, postNum, userId) VALUES (Seq_mm.nextval,?, ?)";		
		Object[] param = new Object[] {mymt.getPostNum(),mymt.getUserId()};				
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

	/**
	 * 모임 삭제	
	 */
	public int remove(String postNum) throws SQLException {
		String sql = "DELETE FROM myMeeting WHERE postNum=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {postNum});	// JDBCUtil에 delete문과 매개 변수 설정

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

	/**
	 * 모임 리스트 출력
	 */
	public List<MyMeeting> findMyMtList(String userId) throws SQLException {
		log.debug("DAO32-1");	
        String sql = "SELECT * " 
        		   + "FROM myMeeting "
        		   + "WHERE userId = ? "
        		   + "ORDER BY mymtId";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<MyMeeting> mtList = new ArrayList<MyMeeting>();	// User들의 리스트 생성
			while (rs.next()) {
				MyMeeting mymt = new MyMeeting(	
					rs.getString("myMtId"),
					rs.getString("postNum"),
					rs.getString("userId"));
				mtList.add(mymt);				
			}		
			return mtList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	
	/**
	 * 모임 개수 반환
	 */
	public int getNumberOfMyMt(String userId) {
		String sql = "SELECT COUNT(userId) FROM myMeeting "
     				+ "WHERE userId = ?";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil에 query문과 매개 변수 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			rs.next();										
			return rs.getInt(1);			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return 0;
	}
}
