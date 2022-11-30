package model.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;
import model.Post;

public interface PostMapper {
	
	// 전체 포스트 타입 리스트 반환
	List<Post> postList();
	
	// 조건에 맞는 포스트 타입 리스트 반환
	List<Post> selectPostByCondition(Map<String, Object> condition);
	
	// 게시글 삽입
	int insertPost(Post post);   
	 
	// 게시글 수정
	int updatePost(Post post);
	
	// 게시글 삭제
	int deletePost(long postNo);

}
