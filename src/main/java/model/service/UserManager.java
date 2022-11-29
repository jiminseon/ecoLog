package model.service;

import java.sql.SQLException;
import java.util.List;

import model.UserDTO;
import model.dao.UserDao;

/**
 * 사용자 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스.
 * UserDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 하며,
 * 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다.
 * 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는 클래스를 
 * 별도로 둘 수 있다.
 */
public class UserManager {
	private static UserManager userMan = new UserManager();
	private UserDao userDAO;

	public UserManager() {
		try {
			userDAO = new UserDao();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static UserManager getInstance() {
		return userMan;
	}
	
    public int create(UserDTO user) throws SQLException, ExistingUserException {
        if (userDAO.existingUser(user.getUserId()) == true) {
            throw new ExistingUserException(user.getUserId() + "는 존재하는 아이디입니다.");
        }
        return userDAO.createUser(user);
    }


	public UserDTO findUser(String userId)
		throws SQLException, UserNotFoundException {
		UserDTO user = userDAO.findUser(userId);
		
		if (user == null) {
			throw new UserNotFoundException(userId + "는 존재하지 않는 아이디입니다.");
		}		
		return user;
	}

	public boolean login(String userId, String password)
		throws SQLException, UserNotFoundException, PasswordMismatchException {
	    UserDTO user = findUser(userId);

		if (!user.matchPassword(password)) {
			throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
		}
		return true;
	}

	public UserDao getUserDAO() {
		return this.userDAO;
	}
	
   public List<UserDTO> findUserList() throws SQLException {               
        return userDAO.findUserList();
    }


   public int updateStudent(UserDTO user) {                 
        return userDAO.updateInfo(user);
   }
    
   public int updateNickname(UserDTO user) throws SQLException {         
        return userDAO.updateNickname(user);
   }
   
   public int deleteStudent(String userId) throws SQLException {         
       return userDAO.removeUser(userId);
  }
   
   public int existingNickname(UserDTO user) throws SQLException, ExistingUserException {  
       if (userDAO.existingUser(user.getNickname()) == true) {
           throw new ExistingUserException(user.getNickname() + "는 존재하는 닉네임입니다.");
       }
    return 0;
  }
   
   
}
