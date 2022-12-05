package model;

public class BookMark {
	private String bmId;
	private String postNum;
	private String userId;
	
	public BookMark(String bmId, String postNum, String userId) {
		super();
		this.bmId = bmId;
		this.postNum = postNum;
		this.userId = userId;
	}

	public BookMark(String postNum, String userId) {
		super();
		this.postNum = postNum;
		this.userId = userId;
	}

	public String getBmId() {
		return bmId;
	}

	public void setBmId(String bmId) {
		this.bmId = bmId;
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
		return "BookMark [bmId=" + bmId + ", postNum=" + postNum + ", userId=" + userId + "]";
	}
	
	
}
