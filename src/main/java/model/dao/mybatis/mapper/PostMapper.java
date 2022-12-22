package model.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;
import model.Post;

public interface PostMapper {
	
	// 전체 포스트 타입 리스트 반환
	List<Post> postListData();
		
	// 게시글 삽입
	int postInsert(Post post);   
	 
	// 게시글 수정
	int postUpdate(Post post);
	
	// 게시글 삭제
	int postDelete(int postNo);
	
}
