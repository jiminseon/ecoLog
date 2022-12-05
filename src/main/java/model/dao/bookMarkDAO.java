package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.BookMark;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.dao.JDBCUtil;

public class bookMarkDAO {
private JDBCUtil jdbcUtil = null;

private static final Logger log = LoggerFactory.getLogger(bookMarkDAO.class);

	public bookMarkDAO() {		
		log.debug("hihi");
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	/**
	 * 북마크 추가
	 */
	public int create(BookMark bm) throws SQLException {
		String sql = "INSERT INTO bookMark(bmId, postNum, userId) VALUES (Seq_bm.nextval,?, ?)";		
		Object[] param = new Object[] {bm.getPostNum(),bm.getUserId()};				
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
	 * 북마크 삭제	
	 */
	public int remove(String postNum) throws SQLException {
		String sql = "DELETE FROM bookMark WHERE postNum=?";		
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
	 * 사용자의 북마크 리스트 출력
	 */
	public List<BookMark> findBookMarkList(String userId) throws SQLException {
		log.debug("DAO22-1");	
        String sql = "SELECT * " 
        		   + "FROM bookMark "
        		+ "where userId= ? "
        		   + "order by bmId";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});		// JDBCUtil에 query문 설정

		log.debug("DAO22-"+userId);			
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<BookMark> bmkList = new ArrayList<BookMark>();	// User들의 리스트 생성
			while (rs.next()) {
				BookMark bm = new BookMark(
					rs.getString("bmId"),
					rs.getString("postNum"),
					rs.getString("userId"));
				bmkList.add(bm);
				log.debug(bm.toString() + "bm");
			}		
			log.debug("bmList" + bmkList);
			return bmkList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	
	/**
	 * 북마크 개수 반환
	 */
	public int getNumberOfBookMark(String userId) {
		String sql = "SELECT COUNT(userId) FROM bookMark "
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
