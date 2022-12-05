package model.service;

import java.sql.SQLException;
import java.util.List;

import model.MyMeeting;
import model.User;
import model.dao.MyMeetingDAO;
import model.dao.UserDAO;
import model.dao.bookMarkDAO;

public class MeetingManager {
	private static MeetingManager meetMan = new MeetingManager();
	private UserDAO userDAO;
	private MyMeetingDAO mtDao;  

	public MeetingManager() {
		try {
			userDAO = new UserDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static MeetingManager getInstance() {
		return meetMan;
	}
	
    public int create(MyMeeting mt) throws SQLException, ExistingUserException {
        return mtDao.create(mt);
    }

	public int remove(String postNum) throws SQLException, UserNotFoundException {
		return userDAO.remove(postNum);
	}
	
	public MyMeetingDAO getUserDAO() {
		return this.mtDao;
	}
	
   public List<MyMeeting> findUserList(String userId) throws SQLException {               
        return mtDao.findMyMtList(userId);
    }

}
