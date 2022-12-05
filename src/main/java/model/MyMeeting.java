package model;

public class MyMeeting {
	private String myMtId;
	private String postNum;
	private String userId;
	
	public MyMeeting(String myMtId, String postNum, String userId) {
		super();
		this.myMtId = myMtId;
		this.postNum = postNum;
		this.userId = userId;
	}

	public MyMeeting(String postNum, String userId) {
		super();
		this.postNum = postNum;
		this.userId = userId;
	}

	public String getMyMtId() {
		return myMtId;
	}

	public void setMyMtId(String myMtId) {
		this.myMtId = myMtId;
	}

	public String getPostNum() {
		return postNum;
	}

	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "MyMeeting [myMtId=" + myMtId + ", postNum=" + postNum + ", userId=" + userId + "]";
	}
	
	
}
