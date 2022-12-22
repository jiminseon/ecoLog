package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 * 사용자 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
 * USER_INFO 테이블에 사용자 정보를 추가, 수정, 삭제, 검색 수행 
 */
public class UserDAO {
	private JDBCUtil jdbcUtil = null;

	public UserDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}

	/**
	 * 사용자 관리 테이블에 새로운 사용자 생성.
	 */
	public int create(User user) throws SQLException {
		/*
		 * java.util.Date utilDate = new java.util.Date(); java.sql.Date sqlDate = new
		 * Date(utilDate.getTime());
		 */
		String sql = "INSERT INTO USER_INFO (ID, PASSWORD, NAME, PHONENUMBER, EMAIL, ADDRESS, BIRTH, nickname, POINT, REGDATE)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, TO_CHAR(SYSDATE, 'YYYY/MM/DD')";	
		Object[] param = new Object[] {user.getId(), user.getPassword(), 
				user.getName(), user.getphoneNumber(), user.getEmail(), user.getAddress(), user.getBirth(), user.getNickname(),
				0};		//포인트와 meeting 0과 null로 표시		

		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
		System.out.println(user.getName() + user.getNickname()+ user.getBirth()+ user.getphoneNumber()+ user.getEmail());
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
	 * 기존의 사용자 정보를 수정.
	 */
	public int update(User user) throws SQLException {
		String sql = "UPDATE USER_INFO "
				+ "SET password=?, name=?, nickname=?, birth=?, email=?, phoneNumber=?, address=? "
				+ "WHERE Id=?";
		Object[] param = new Object[] {user.getPassword(), user.getName()
				, user.getNickname(), user.getBirth(), user.getEmail(), user.getphoneNumber(), user.getAddress(), user.getId()};
		
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정

		try {		
			int result = jdbcUtil.executeUpdate();	// update 문 실행
			return result;
		} catch (Exception ex) {
			System.out.println("DAO 오류");
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			System.out.println("정보 수정 완료");
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	/**
	 * 사용자 Id에 해당하는 사용자를 삭제.
	 */
	public int remove(String Id) throws SQLException {
		String sql = "DELETE FROM USER_INFO WHERE Id=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {Id});	// JDBCUtil에 delete문과 매개 변수 설정

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
	 * 주어진 사용자 Id에 해당하는 사용자 정보를 데이터베이스에서 찾아 User 도메인 클래스에 
	 * 저장하여 반환.
	 */
	public User findUser(String Id) throws SQLException {
		String sql = "SELECT password, name, phoneNumber, email, address, birth, nickname, point "
				+ "FROM USER_INFO "
				+ "WHERE Id=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {Id});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 학생 정보 발견
				User user = new User(		// User 객체를 생성하여 학생 정보를 저장
						Id,
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("phoneNumber"),
						rs.getString("email"),
						rs.getString("address"),
						rs.getString("birth"),
						rs.getString("nickname"),
						rs.getInt("point"));
				System.out.println("유저 정보 저장 성공");
				return user;
			}
			System.out.println("유저 정보 저장 실패");

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

//	/**
//	 * 전체 사용자 정보를 검색하여 List에 저장 및 반환
//	 */
	public List<User> findUserList() throws SQLException {
		String sql = "SELECT Id, password, name, phoneNumber, email, address, birth, nickname, point " 
				+ "FROM USER_INFO "
				+ "ORDER BY Id";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<User> userList = new ArrayList<User>();	// User들의 리스트 생성
			while (rs.next()) {
				User user = new User(			// User 객체를 생성하여 현재 행의 정보를 저장
						rs.getString("Id"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("phoneNumber"),
						rs.getString("email"),
						rs.getString("address"),
						rs.getString("birth"),
						rs.getString("nickname"),
						rs.getInt("point"));
				userList.add(user);				// List에 User 객체 저장
			}		
			return userList;					

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
//
//	/**
//	 * 전체 사용자 정보를 검색한 후 현재 페이지와 페이지당 출력할 사용자 수를 이용하여
//	 * 해당하는 사용자 정보만을 List에 저장하여 반환.
//	 */
	public List<User> findUserList(int currentPage, int countPerPage) throws SQLException {
		String sql = "SELECT Id, name, email, NVL(commId, 0) AS commId, cName " 
				+ "FROM USER_INFO u LEFT OUTER JOIN Community c ON u.commId = c.cId "
				+ "ORDER BY Id";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil에 query문 설정
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 가능
				ResultSet.CONCUR_READ_ONLY);						

		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query 실행			
			int start = ((currentPage-1) * countPerPage) + 1;	// 출력을 시작할 행 번호 계산
			if ((start >= 0) && rs.absolute(start)) {			// 커서를 시작 행으로 이동
				List<User> userList = new ArrayList<User>();	// User들의 리스트 생성
				do {
					User user = new User(			// User 객체를 생성하여 현재 행의 정보를 저장
							rs.getString("Id"),
							rs.getString("password"),
							rs.getString("name"),
							rs.getString("phoneNumber"),
							rs.getString("email"),
							rs.getString("address"),
							rs.getString("birth"),
							rs.getString("nickname"));
					userList.add(user);							// 리스트에 User 객체 저장
				} while ((rs.next()) && (--countPerPage > 0));		
				return userList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/**
	 * 주어진 사용자 Id에 해당하는 사용자가 존재하는지 검사 
	 */
	public boolean existingUser(String Id) throws SQLException {
		String sql = "SELECT count(*) FROM USER_INFO WHERE Id=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {Id});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}

	public boolean existingUserNickName(String nickname) throws SQLException {
		String sql = "SELECT count(*) FROM USER_INFO WHERE nickname=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {nickname});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}
	
	public boolean existingUserEmail(String email) throws SQLException {
		String sql = "SELECT count(*) FROM USER_INFO WHERE email=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {email});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}

	public boolean existingUserPhoneNumber(String phoneNumber) throws SQLException {
		String sql = "SELECT count(*) FROM USER_INFO WHERE phoneNumber=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {phoneNumber});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}
	
	public int savePoint(int point, String Id) throws SQLException {
		String sql = "UPDATE USER_INFO "
				+ "SET point= point + ? "
				+ "WHERE Id=?";
		Object[] param = new Object[] {point, Id};
		
		System.out.println("point update "+ point+ Id);
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정

		try {		
			System.out.println("DAO에서 수정 중");
			int result = jdbcUtil.executeUpdate();	// update 문 실행
			return result;
		} catch (Exception ex) {
			System.out.println("DAO 오류");
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			System.out.println("정보 수정 완료");
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}
	
	public List<User> rankList() throws SQLException {
		String sql = "SELECT rownum, nickname, point " 
				+ "FROM (select nickname, point from USER_INFO ORDER BY point DESC) "
				+ "WHERE rownum <= 3 and point > 0";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<User> userList = new ArrayList<User>();	// User들의 리스트 생성
			while (rs.next()) {
				User user = new User(	
						rs.getString("nickname"),
						rs.getInt("point"));
				userList.add(user);				// List에 User 객체 저장
			}		
			return userList;					

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

}