package model.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;
import model.Post;

public interface PostMapper {
	
	List<Post> selectPostByCondition(Map<String, Object> condition);
	
	int insertPost(Post post);   
	 
	int updatePost(Post post);
	
	int deletePost(long postNo);

}
