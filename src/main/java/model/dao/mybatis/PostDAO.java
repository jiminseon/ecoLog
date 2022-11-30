package model.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Post;
import model.dao.mybatis.*;
import model.dao.mybatis.mapper.PostMapper;

public class PostDAO {
	private SqlSessionFactory sqlSessionFactory;
	
	public PostDAO() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	/**
	 * 포스트 테이블에 새로운 행 생성 (PK 값은 Sequence를 이용하여 자동 생성)
	 */
	public Post create(Post post) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(PostMapper.class).insertPost(post);
			if (result > 0) {
				sqlSession.commit();
			} 
			return post;
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * 기존의 게시글 정보를 수정
	 */
	public int update(Post post) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(PostMapper.class).updatePost(post);
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * 주어진 No.에 해당하는 게시글 정보를 삭제.
	 */
	public int remove(int postNo) {		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(PostMapper.class).deletePost(postNo);
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;	
		} finally {
			sqlSession.close();
		}
	}

	



}
