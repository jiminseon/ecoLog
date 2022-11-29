package model.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Post;

public interface PostMapper2 {
	/*
	@Select("SELECT comment_no AS commentNo," + 
			" 		user_id AS userId," + 
			" 		comment_content AS commentContent," + 
			" 		reg_date AS regDate " +
			"FROM COMMENTS " + 
			"WHERE comment_no = #{commentNo}")
	Comment selectCommentByPrimaryKey(long commentNo);
	
	@Select("SELECT comment_no AS commentNo," + 
			" 		user_id AS userId," + 
			" 		comment_content AS commentContent," + 
			" 		reg_date AS regDate " +
			"FROM COMMENTS " + 
			"WHERE user_id = #{userId}")
	// 주의: @Select annotation으로는 dynamic SQL은 표현 불가 
	//		--> 별도의 클래스 정의 및 @SelectProvider 사용해야 함
	List<Comment> selectCommentByCondition(Map<String, Object> condition);
	
	@Insert("INSERT INTO COMMENTS (comment_no, user_id, comment_content, reg_date) " + 
			"VALUES (#{commentNo}, #{userId}, #{commentContent}, #{regDate})")
	int insertComment(Comment comment);  
 
	@Update("UPDATE COMMENTS " + 
			"SET comment_content = #{commentContent} " + 
			"WHERE comment_no = #{commentNo}")
	int updateComment(Comment comment);
	
	@Delete("DELETE FROM COMMENTS " +
			"WHERE comment_no = #{commentNo}")
	int deleteComment(long commentNo);
	
	@Delete("DELETE FROM COMMENTS")
	int deleteAllComments();*/

}
