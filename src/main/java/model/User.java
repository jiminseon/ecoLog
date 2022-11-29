//package model;
//
//import java.util.List;
//
//
//
//public class User {
//	private String userId;
//	private String password;
//	private String name;
//	private String phone;
//	private String email;
//	private String address;
//	private String birth;
//	private String nickname;  
//	private int point;
//	private List<Meeting> meeting;
//	private int regDate; 
//	//private Character ch = new Character(id, nickname);
//	private List<String> imageList;
//	
//	public User(java.lang.String userId, java.lang.String password, java.lang.String name, java.lang.String phone,
//			java.lang.String email, java.lang.String address, java.lang.String birth, java.lang.String nickname, int point,
//			List<Meeting> meeting, int regDate) {
//		super();
//		this.userId = userId;
//		this.password = password;
//		this.name = name;
//		this.phone = phone;
//		this.email = email;
//		this.address = address;
//		this.birth = birth;
//		this.nickname = nickname;
//		this.point = point;
//		this.meeting = meeting;
//		this.regDate = regDate;
//	}
//
//	public User(String userId, String password, String name, String phone, String email, String address,
//			String birth, String nickname) {
//		super();
//		this.userId = userId;
//		this.password = password;
//		this.name = name;
//		this.phone = phone;
//		this.email = email;
//		this.address = address;
//		this.birth = birth;
//		this.nickname = nickname;
//	}
//	
//	/*public void update(User updateUser) {
//        this.password = updateUser.password;
//        this.name = updateUser.name;
//        this.email = updateUser.email;
//        this.phone = updateUser.phone;
//    }*/
//	
//
//	
//	/* 占쏙옙橘占싫� 占싯삼옙 */
//	public boolean matchPassword(String password) {
//		if (password == null) {
//			return false;
//		}
//		return this.password.equals(password);
//	}
//
//	public String getUserId() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public String getBirth() {
//		return birth;
//	}
//
//	public void setBirth(String birth) {
//		this.birth = birth;
//	}
//
//	public String getNickname() {
//		return nickname;
//	}
//
//	public void setNickname(String nickname) {
//		this.nickname = nickname;
//	}
//
//	public int getPoint() {
//		return point;
//	}
//
//	public void setPoint(int point) {
//		this.point = point;
//	}
//
//	public List<Meeting> getMeeting() {
//		return meeting;
//	}
//
//	public void setMeeting(List<Meeting> meeting) {
//		this.meeting = meeting;
//	}
//
//	public int getRegDate() {
//		return regDate;
//	}
//
//	public void setRegDate(int regDate) {
//		this.regDate = regDate;
//	}
//
////	public Character getCh() {
////		return ch;
////	}
////
////	public void setCh(Character ch) {
////		this.ch = ch;
////	}
//
//	public List<String> getImageList() {
//		return imageList;
//	}
//
//	public void setImageList(List<String> imageList) {
//		this.imageList = imageList;
//	}
//
//	public boolean isSameUser(String userid) {
//        return this.userId.equals(userid);
//    }
//
//	@java.lang.Override
//	public String toString() {
//		return "user [userId=" + userId + ", password=" + password + ", name=" + name + ", phone=" + phone + ", email=" + email
//				+ ", address=" + address + ", birth=" + birth + ", nickname=" + nickname + ", point=" + point
//				+ ", regDate=" + regDate + "]";
//	}
//	
//}