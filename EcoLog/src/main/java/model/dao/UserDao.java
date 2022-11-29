package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.UserDTO;
/**
 * 사용자 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
 * USERINFO 테이블에 사용자 정보를 추가, 수정, 삭제, 검색 수행 
 */

public class UserDao{ 
	private JDBCUtil jdbcUtil = null;
	
	public UserDao() {			
		jdbcUtil = new JDBCUtil();	// JDBC
	}
	   /**
     * 사용자 관리 테이블에 새로운 사용자 생성.
     */
		
	public int createUser(UserDTO user) throws SQLException {
		String sql = "INSERT INTO USER_INFO VALUES (?, ?, ?, ?, ?, ?, ?)";		
		Object[] param = new Object[] {user.getUserId(), user.getPassword(), 
				user.getName(), user.getPhone(), user.getEmail(), user.getAddress(), user.getBirth()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
						
		try {				
			int result = jdbcUtil.executeUpdate();		// insert 문 실행
			System.out.println(user.getName() + "삽입되었습니다.");
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
	 * 湲곗〈�쓽 �궗�슜�옄 �젙蹂대�� �닔�젙.
	 */
	public int updateInfo(UserDTO user) {
		
		String updateQuery = "UPDATE USER_INFO SET ";
		int index = 0;
		Object[] params = new Object[10];		// update 臾몄뿉 �궗�슜�븷 留ㅺ컻蹂��닔瑜� ���옣�븷 �닔 �엳�뒗 �엫�떆 諛곗뿴
		
		if (user.getPassword() != null) {		// �씠由꾩씠 �꽕�젙�릺�뼱 �엳�쓣 寃쎌슦
			updateQuery += "password = ?, ";		// update 臾몄뿉 �씠由� �닔�젙 遺�遺� 異붽�
			params[index++] = user.getPassword();		// 留ㅺ컻蹂��닔�뿉 �닔�젙�븷 �씠由� 異붽�
		}
		if (user.getPhone() != null) {		// �뙣�뒪�썙�뱶媛� �꽕�젙�릺�뼱 �엳�쓣 寃쎌슦
			updateQuery += "phone = ?, ";		// update 臾몄뿉 �뙣�뒪�썙�뱶 �닔�젙 遺�遺� 異붽�
			params[index++] = user.getPhone();		// 留ㅺ컻蹂��닔�뿉 �닔�젙�븷 �뙣�뒪�썙�뱶 異붽�
		}
		if (user.getEmail() != null) {		// �쑕���룿 踰덊샇媛� �꽕�젙�릺�뼱 �엳�쓣 寃쎌슦
			updateQuery += "email = ?, ";		// update 臾몄뿉 �쑕���룿 �닔�젙 遺�遺� 異붽�
			params[index++] = user.getEmail();		// 留ㅺ컻蹂��닔�뿉 �닔�젙�븷 �쑕���룿 異붽�
		}
		if (user.getAddress() != null) {		// �븰�뀈�씠 �꽕�젙�릺�뼱 �엳�쓣 寃쎌슦
			updateQuery += "address = ?, ";		// update 臾몄뿉 �븰�뀈 �닔�젙 遺�遺� 異붽�
			params[index++] = user.getAddress();		// 留ㅺ컻蹂��닔�뿉 �닔�젙�븷 �븰�뀈 異붽�
		}
		if (user.getBirth() != null) {		// 援먯닔肄붾뱶媛� �꽕�젙�릺�뼱 �엳�쓣 寃쎌슦
			updateQuery += "birth = ?, ";		// update 臾몄뿉 吏��룄援먯닔 �닔�젙 遺�遺� 異붽�
			params[index++] = user.getBirth();		// 留ㅺ컻蹂��닔�뿉 �닔�젙�븷 吏��룄援먯닔肄붾뱶 異붽�
		}
		updateQuery += "WHERE userId = ? ";		// update 臾몄뿉 議곌굔 吏��젙
		updateQuery = updateQuery.replace(", WHERE", " WHERE");		// update 臾몄쓽 where �젅 �븵�뿉 �엳�쓣 �닔 �엳�뒗 , �젣嫄�
		
		params[index++] = user.getUserId();		// 李얠쓣 議곌굔�뿉 �빐�떦�븯�뒗 �븰踰덉뿉 ���븳 留ㅺ컻蹂��닔 異붽�
		
		Object[] newParam = new Object[index];
		for (int i=0; i < newParam.length; i++)		// 留ㅺ컻蹂��닔�쓽 媛쒖닔留뚰겮�쓽 �겕湲곕�� 媛뽯뒗 諛곗뿴�쓣 �깮�꽦�븯怨� 留ㅺ컻蹂��닔 媛� 蹂듭궗
			newParam[i] = params[i];
		
		jdbcUtil.setSqlAndParameters(updateQuery, newParam);
		
		try {
			int result = jdbcUtil.executeUpdate();		// update 臾� �떎�뻾
			return result;			// update �뿉 �쓽�빐 諛섏쁺�맂 �젅肄붾뱶 �닔 諛섑솚
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 諛섑솚
		}		
		return 0;
	}

	/**
	 * �궗�슜�옄 ID�뿉 �빐�떦�븯�뒗 �궗�슜�옄瑜� �궘�젣.
	 */
	public int removeUser(String userId) throws SQLException {
		String sql = "DELETE FROM USERINFO WHERE userId=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil�뿉 delete臾멸낵 留ㅺ컻 蹂��닔 �꽕�젙

		try {				
			int result = jdbcUtil.executeUpdate();	// delete 臾� �떎�뻾
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 諛섑솚
		}		
		return 0;
	}

	/**
	 * 二쇱뼱吏� �궗�슜�옄 ID�뿉 �빐�떦�븯�뒗 �궗�슜�옄 �젙蹂대�� �뜲�씠�꽣踰좎씠�뒪�뿉�꽌 李얠븘 User �룄硫붿씤 �겢�옒�뒪�뿉 
	 * ���옣�븯�뿬 諛섑솚.
	 */
	public UserDTO findUser(String userId) throws SQLException {
        String sql = "SELECT password, name, phone, email, address, birth, nickname"
        			+ "FROM USER_INFO "
        			+ "WHERE userId=? ";          
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil�뿉 query臾멸낵 留ㅺ컻 蹂��닔 �꽕�젙

		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			UserDTO dto = null;
			if (rs.next()) {						// �븰�깮 �젙蹂� 諛쒓껄
				dto = new UserDTO();	
				dto.setUserId(userId);
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setAddress(rs.getString("address"));
				dto.setBirth(rs.getString("birth"));
				dto.setNickname(rs.getString("nickname"));
			}
			return dto;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 諛섑솚
		}
		return null;
	}

	/**
	 * �쟾泥� �궗�슜�옄 �젙蹂대�� 寃��깋�븯�뿬 List�뿉 ���옣 諛� 諛섑솚
	 */
	public List<UserDTO> findUserList() throws SQLException {
        String sql = "SELECT userId, name, phone,email, birth,nickname " 
        		   + "FROM USER_INFO"
        		   + "ORDER BY userId";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil�뿉 query臾� �꽕�젙
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query �떎�뻾			
			List<UserDTO> userList = new ArrayList<UserDTO>();	// User�뱾�쓽 由ъ뒪�듃 �깮�꽦
			while (rs.next()) {
				UserDTO dto = new UserDTO();		
					dto.setUserId(rs.getString("userId"));
					dto.setPassword(null);
					dto.setName(rs.getString("name"));
					dto.setPhone(rs.getString("phone"));
					dto.setEmail(rs.getString("email"));
					dto.setAddress(null);
					dto.setBirth(rs.getString("birth"));
					dto.setNickname(rs.getString("nickname"));
				userList.add(dto);				// List�뿉 User 媛앹껜 ���옣
			}		
			return userList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 諛섑솚
		}
		return null;
	}
	
	/**
	 * �쟾泥� �궗�슜�옄 �젙蹂대�� 寃��깋�븳 �썑 �쁽�옱 �럹�씠吏��� �럹�씠吏��떦 異쒕젰�븷 �궗�슜�옄 �닔瑜� �씠�슜�븯�뿬
	 * �빐�떦�븯�뒗 �궗�슜�옄 �젙蹂대쭔�쓣 List�뿉 ���옣�븯�뿬 諛섑솚.
	 */
	public List<UserDTO> findUserList(int currentPage, int countPerPage) throws SQLException {
		String sql = "SELECT userId, name, phone,email, birth, nickname " 
					+ "FROM USER_INFO "
					+ "ORDER BY userId";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil�뿉 query臾� �꽕�젙
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 媛��뒫
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query �떎�뻾			
			int start = ((currentPage-1) * countPerPage) + 1;	// 異쒕젰�쓣 �떆�옉�븷 �뻾 踰덊샇 怨꾩궛
			if ((start >= 0) && rs.absolute(start)) {			// 而ㅼ꽌瑜� �떆�옉 �뻾�쑝濡� �씠�룞
				List<UserDTO> userList = new ArrayList<UserDTO>();	// User�뱾�쓽 由ъ뒪�듃 �깮�꽦
				do {
					UserDTO dto = new UserDTO();		
						dto.setUserId(rs.getString("userId"));
						dto.setPassword(null);
						dto.setName(rs.getString("name"));
						dto.setPhone(rs.getString("phone"));
						dto.setEmail(rs.getString("email"));
						dto.setAddress(null);
						dto.setBirth(rs.getString("birth"));
						dto.setNickname(rs.getString("nickname"));
					userList.add(dto);				
				}while ((rs.next()) && (--countPerPage > 0));	
				return userList;								
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 諛섑솚
		}
		return null;
	}

	/**
	 * �듅�젙 紐⑥엫�뿉 �냽�븳 �궗�슜�옄�뱾�쓣 寃��깋�븯�뿬 List�뿉 ���옣 諛� 諛섑솚
	 */
	public List<UserDTO> findUsersInMeeting(String meetingName) throws SQLException {
        String sql = "SELECT userId, name, email, phone FROM USER_INFOu LEFT OUTER JOIN Meeting m ON c.userId = m.userId " //c.userId媛� User_INFO�쓽 Pk, m.userId媛� 洹멸구 李몄“�븯�뒗 Fk
     				+ "WHERE m.meetingName = ?";                         
		jdbcUtil.setSqlAndParameters(sql, new Object[] {meetingName});	// JDBCUtil�뿉 query臾멸낵 留ㅺ컻 蹂��닔 �꽕�젙
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query �떎�뻾
			List<UserDTO> userList = new ArrayList<UserDTO>();	// member�뱾�쓽 由ъ뒪�듃 �깮�꽦
			while (rs.next()) {
				UserDTO dto = new UserDTO();		
				dto.setUserId(rs.getString("userId"));
				dto.setPassword(null);
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setAddress(null);
				dto.setBirth(rs.getString("birth"));
				dto.setNickname(rs.getString("nickname"));
			userList.add(dto);					
			}		
			return userList;					
				
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 諛섑솚
		}
		return null;
	}
	
	/**
	 * 二쇱뼱吏� �궗�슜�옄 ID�뿉 �빐�떦�븯�뒗 �궗�슜�옄媛� 議댁옱�븯�뒗吏� 寃��궗 
	 */
	public boolean existingUser(String userId) throws SQLException {
		String sql = "SELECT count(*) FROM USER_INFO WHERE userId=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil�뿉 query臾멸낵 留ㅺ컻 蹂��닔 �꽕�젙

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query �떎�뻾
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 諛섑솚
		}
		return false;
	}


	public boolean existingNickname(String nickname) throws SQLException {
		String sql = "SELECT count(*) FROM USER_INFO WHERE nickname=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {nickname});	// JDBCUtil�뿉 query臾멸낵 留ㅺ컻 蹂��닔 �꽕�젙

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query �떎�뻾
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 諛섑솚
		}
		return false;
	}

	public int updateNickname(UserDTO user) throws SQLException {
		String sql = "UPDATE USER_INFO"
					+ "SET nickname=? "
					+ "WHERE userId=?";
		Object[] param = new Object[] {user.getNickname(),user.getUserId()};		//�옒紐⑤Ⅴ寃좎쓬		
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil�뿉 update臾멸낵 留ㅺ컻 蹂��닔 �꽕�젙
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update 臾� �떎�뻾
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 諛섑솚
		}		
		return 0;
	}

}
