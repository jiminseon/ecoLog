package model.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Post;
import model.dao.mybatis.*;
import model.dao.mybatis.mapper.PostMapper;

public class PostDAO {
	private static SqlSessionFactory ssf;
	
	public PostDAO() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		ssf = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	static {
		try {
			// XML 파일 읽기(mybatis config에 등록된 내용 읽어오기)
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			ssf = new SqlSessionFactoryBuilder().build(reader);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static List<Post> postListData(Map map) {
		List<Post> list = new ArrayList<Post>();
		SqlSession session = null;
		
		try {
			session = ssf.openSession();
			list = session.selectList("postListData", map);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}			
		}
		
		return list;		
	}
	
	public static List<Post> postListLast(Map map) {
		List<Post> list = new ArrayList<Post>();
		SqlSession session = null;
		
		try {
			session = ssf.openSession();
			list = session.selectList("postListLast", map);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}			
		}
		
		return list;		
	}

	public static List<Post> myPostList(String name) {
		List<Post> list = new ArrayList<Post>();
		SqlSession session = null;
		
		try {
			session = ssf.openSession();
			list = session.selectList("myPostList", name);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}			
		}
		
		return list;		
	}
	
	// 게시글의 총 페이지 수를 반환
	public static int postTotalPage() {
		int total = 0;
		SqlSession session = null;
		
		try {
			session = ssf.openSession();
			total = session.selectOne("postTotalPage");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return total;
	}
	
	// 게시글 삽입
	public static Post postInsert(Post post) {
		SqlSession session = ssf.openSession();
		try {
			int result = session.getMapper(PostMapper.class).postInsert(post);
			if(result > 0) {
				session.commit();
			}
			return post;
		}  finally {
				session.close();
		}
	}
	
	// 게시글 상세 보기
	public static Post postDetailData(int postNo) {
		Post post = new Post();
		SqlSession session = null;
		
		try {
			session = ssf.openSession();
			session.update("viewIncrement", postNo);
			post = session.selectOne("postDetailData", postNo);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
		return post;
	}
	
	// 검색 결과 개수 반환
	public static int postFindCount(Map map) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			 session=ssf.openSession();
	         cnt=session.selectOne("postFindCount",map);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return cnt;		
	}
	
	// 검색 게시글 리스트 반환
	public static List<Post> postFindData(Map map) {
		List<Post> list = new ArrayList<Post>();
		SqlSession session = null;
		
		try {
			session = ssf.openSession();
			list = session.selectList("postFindData", map);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
	}
	
	// 게시글 삭제(비밀번호 확인 나중에...)
	public static boolean postDelete(int postNo) {
		boolean check = false;
		SqlSession session=null;
		
		try {
			check = true;
			session = ssf.openSession();
			
			//String db_pwd=session.selectOne("boardGetPassword",no);
			session.delete("postDelete", postNo);
			session.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return check;
	}
	
	// 수정할 게시글 postNum으로 탐색
	public static Post findPost(int postNum) {
		SqlSession session = null;
		try {
			session = ssf.openSession();
			return session.selectOne("selectPost", postNum);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return null;		
	}
	
	// 게시글 수정
	public static int postUpdate(Post post) {
		SqlSession sqlSession = ssf.openSession();
		try {
			int result = sqlSession.getMapper(PostMapper.class).postUpdate(post);
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;
		} finally {
			sqlSession.close();
		}
	}
}
