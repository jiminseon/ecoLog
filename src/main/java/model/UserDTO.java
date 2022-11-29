package model;

public class UserDTO {
	private String Id;
	private String password;
	private String name;
	private String phone;
	private String email;
	private String address;
	private String birth;
	private String nickname;


	 public UserDTO(java.lang.String Id, java.lang.String password, java.lang.String name, java.lang.String phone,
  java.lang.String email, java.lang.String address, java.lang.String birth, java.lang.String nickname, int point, int regDate) {
        super();
        this.Id = Id;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.birth = birth;
        this.nickname = nickname;
}

    public UserDTO(String Id, String password, String name, String phone, String email, String address,
      String birth, String nickname) {
    super();
    this.Id = Id;
    this.password = password;
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.address = address;
    this.birth = birth;
    this.nickname = nickname;
    }
public UserDTO() {
        // TODO Auto-generated constructor stub
    }

public UserDTO(String parameter, String parameter2, String parameter3, String parameter4, String parameter5,
        String parameter6, String parameter7) {
    // TODO Auto-generated constructor stub
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	
	
}
