package model;

import java.sql.Date;
import java.util.List;

public class User {
	private String Id;
	private String password;
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private String birth;
	private String nickname;  
	private int point;
	private int regDate; 
	//private Character ch = new Character(id, nickname);
	private List<String> imageList;
	
	public User(java.lang.String Id, java.lang.String password, java.lang.String name, java.lang.String phoneNumber,
			java.lang.String email, java.lang.String address, java.lang.String birth, java.lang.String nickname, int point,
			int regDate) {
		super();
		this.Id = Id;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.nickname = nickname;
		this.point = point;
		this.regDate = regDate;
	}

	public User(String Id, String password, String name, String phoneNumber, String email, String address,
			String birth, String nickname, int point) {
		this.Id = Id;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.nickname = nickname;
		this.point = point;
	}
	
	public User(String Id, String password, String name, String phoneNumber, String email, String address,
			String birth, String nickname) {
		this.Id = Id;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.nickname = nickname;
	}
	
//	public void update(User updateUser) {
//        this.password = updateUser.password;
//        this.name = updateUser.name;
//        this.email = updateUser.email;
//        this.phoneNumber = updateUser.phoneNumber;
//    }

	public User(String string, int int1) {
		this.nickname = string;
		this.point = int1;
	}
	



	public boolean matchPassword(String password) {
		if (password == null) {
			return false;
		}
		return this.password.equals(password);
	}

	public String getId() {
		return Id;
	}

	public void setId(String Id) {
		this.Id = Id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getphoneNumber() {
		return phoneNumber;
	}

	public void setphoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getRegDate() {
		return regDate;
	}

	public void setRegDate(int regDate) {
		this.regDate = regDate;
	}

//	public Character getCh() {
//		return ch;
//	}
//
//	public void setCh(Character ch) {
//		this.ch = ch;
//	}

	public List<String> getImageList() {
		return imageList;
	}

	public void setImageList(List<String> imageList) {
		this.imageList = imageList;
	}

	public boolean isSameUser(String Id) {
        return this.Id.equals(Id);
    }

	@java.lang.Override
	public String toString() {
		return "user [Id=" + Id + ", password=" + password + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email
				 + ", birth=" + birth + ", nickname=" + nickname + ", address=" + address+ ", point=" + point
				+ ", regDate=" + regDate + "]";
	}
	
}