package model.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Post;
import model.dao.mybatis.*;

public interface PostMapper2 {
	
	// 게시판 상세 보기
	@Select("SELECT postnum AS postNo," + 
			"		title AS postTitle," +
			" 		writer AS userId," + 
			"		category AS postCategory," +	
			" 		content AS postContent," + 	
			"		visitcnt AS views, " +
			" 		writedate AS writeDate " +
			"FROM POST " + 
			"WHERE postnum = #{postnum}")
	
	Post selectPostByPrimaryKey(long postNo);
	
	// 유저id로 게시판 검색
	@Select("SELECT postnum AS postNo," + 
			"		title AS postTitle, " +
			" 		writer AS userId," + 
			"		category AS postCategory, " +
			" 		content AS postContent," + 
			" 		writedate AS writeDate " +
			"FROM POST " + 
			"WHERE writer = #{userId}")
	
	// 게시판 메인에 표시되는 정보(게시글 번호, 제목, 유형, 작성자, 작성일)
	@Select("SELECT postnum, title, category, writer, writedate " +
			"FROM POST")
	// 주의: @Select annotation으로는 dynamic SQL은 표현 불가 
	//		--> 별도의 클래스 정의 및 @SelectProvider 사용해야 함
	List<Post> selectPostByCondition(Map<String, Object> condition);
	
	// 게시판 삽입
	@Insert("INSERT INTO POST (postnum, writer, title, category, content, writedate) " + 
			"VALUES (#{postNo}, #{userId}, #{postTitle}, #{postCategory}, #{postContent}, #{writeDate})")
	int insertPost(Post post);  
 
	@Update("UPDATE POST " + 
			"SET content = #{postContent} " + 
			"WHERE postnum = #{postNo}")
	int updateComment(Post post);
	
	@Delete("DELETE FROM POST " +
			"WHERE postnum = #{postNo}")
	int deletePost(long postNo);
	
	// 전체 게시글 삭제
	@Delete("DELETE FROM POST")
	int deleteAllPost();

}
