//package model.dao;
//
//import java.beans.Statement;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.naming.InitialContext;
//import javax.servlet.http.HttpServletRequest;
//import javax.sql.DataSource;
//
//import org.apache.commons.dbcp2.BasicDataSource;
//
//import ch.qos.logback.core.Context;
//
//import model.Post;
//
//public class postDAO {
//	private HttpServletRequest request;
//	private Context context;
//	private DataSource datasource;
//	private Connection conn;
//	private Statement stmt;
//	private PreparedStatement preStmt;
//	private ResultSet result;
//	private JDBCUtil jdbcUtil = null;
//	
//	public postDAO() {	
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");	
//		} catch (ClassNotFoundException ex) {
//			ex.printStackTrace();
//		}	
//	}
//	
//
//	
//	public String getDate() {
//	  	String SQL = "SELECT NOW()"; // 현재 시간 가져오기
//	  	try {
//	  		PreparedStatement pstmt = conn.prepareStatement(SQL);
//	  		result = pstmt.executeQuery();
//	  		if (result.next()) {
//	  			return result.getString(1);
//	  		}
//	  	} catch(Exception e) {
//	  		e.printStackTrace();
//	  	}
//	  	return "";
//	  }
//	
//	 public int getNext() { // 다음 글 가지고 오기.
//		  	String SQL = "SELECT postnum FROM POST ORDER BY postnum DESC";
//		  	try {
//		  		PreparedStatement pstmt = conn.prepareStatement(SQL);
//		  		result = pstmt.executeQuery();
//		  		if (result.next()) {
//		  			return result.getInt(1) + 1;
//		  		}
//		  		return 1; // 첫 번째 게시물인 경우
//		  	} catch(Exception e) {
//		  		e.printStackTrace();
//		  	}
//		  	return -1; // 데이터베이스 오류
//	 }
//	 
//	 public ArrayList<Post> getList(int pageNumber) {
//			String SQL = "SELECT * FROM post WHERE postnum < ? ORDER BY postnum DESC LIMIT 10";
//			ArrayList<Post> list = new ArrayList<Post>();
//			try {
//				PreparedStatement pstmt = conn.prepareStatement(SQL);
//				pstmt.setInt(1, getNext() - (pageNumber -1) * 10);
//				result = pstmt.executeQuery();
//				while (result.next()) {
//					Post post = new Post();
//					post.setPostNum(result.getInt(1));
//					post.setTitle(result.getString(2));
//					post.setCategory(result.getString(3));
//					post.setContent(result.getString(4));
//					post.setWriter(result.getString(6));
//					post.setWriteDate(result.getString(7));
//					list.add(post);
//				}			
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//			return list;
//		}
//
//		public boolean nextPage(int pageNumber) {
//			String SQL = "SELECT * FROM POST WHERE postnum < ? ";
//
//			try {
//				PreparedStatement pstmt = conn.prepareStatement(SQL);
//				pstmt.setInt(1, getNext() - (pageNumber -1) * 10);
//				result = pstmt.executeQuery();
//				if (result.next()) {
//					return true;
//				}			
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//			return false;
//		}
//		
//	 
//	 public int write(String postTitle, String userID, String postContent, String category) {
//		  	String SQL = "INSERT INTO POST (postnum, title, category, content, writer, writedate) "
//		  			+ "VALUES (?, ?, ?, ?, ?, ?)";
//		  	try {
//		  		PreparedStatement pstmt = conn.prepareStatement(SQL);
//		  		pstmt.setInt(1, getNext());
//		  		pstmt.setString(2, postTitle);
//		  		pstmt.setString(3, category);
//		  		pstmt.setString(4, postContent);
//		  		pstmt.setString(5, userID);
//		  		pstmt.setString(6, getDate());
//
//		  		return pstmt.executeUpdate();
//		  	} catch(Exception e) {
//		  		e.printStackTrace();
//		  	}
//		  	return -1; // 데이터베이스 오류
//		  }
//	
//	public List<Post> postList(int currentPage, int countPerPage) {
//		String sql = "SELECT postnum, title, writer, category, writedate " 
//				+ "FROM USER_INFO u LEFT OUTER JOIN POST p ON u.id = p.writer "
//				+ "ORDER BY postnum";
//		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil에 query문 설정
//			ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 가능
//			ResultSet.CONCUR_READ_ONLY);
//		
//		try {
//			ResultSet rs = jdbcUtil.executeQuery();						
//			int start = ((currentPage-1) * countPerPage) + 1;	
//			if ((start >= 0) && rs.absolute(start)) {			
//				List<Post> postList = new ArrayList<Post>();	
//				do {
//					Post post = new Post(			
//						rs.getInt("postnum"),
//						rs.getString("title"),
//						rs.getString("writer"),
//						rs.getString("category"),
//						rs.getString("writedate"));
//					postList.add(post);							
//				} while ((rs.next()) && (--countPerPage > 0));		
//				return postList;							
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			jdbcUtil.close();		// resource 반환
//		}
//		return null;
//	}
//		
//
//}
