package model;

public class Calculator {
	private String cal_day;
	private String cal_content;
	private int cal_point;
	private String userid;
	private int calNum;
	
	
	public Calculator(String cal_day, String cal_content, int cal_point, String userid, int calNum) {
		super();
		this.cal_day = cal_day;
		this.cal_content = cal_content;
		this.cal_point = cal_point;
		this.userid = userid;
		this.calNum = calNum;
	}
	
	public String getCal_day() {
		return cal_day;
	}
	public void setCal_day(String cal_day) {
		this.cal_day = cal_day;
	}
	public String getCal_content() {
		return cal_content;
	}
	public void setCal_content(String cal_content) {
		this.cal_content = cal_content;
	}
	public int getCal_point() {
		return cal_point;
	}
	public void setCal_point(int cal_point) {
		this.cal_point = cal_point;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getCalNum() {
		return calNum;
	}
	public void setCalNum(int calNum) {
		this.calNum = calNum;
	}
	@Override
	public String toString() {
		return "Calculator [cal_day=" + cal_day + ", cal_content=" + cal_content + ", cal_point=" + cal_point
				+ ", userid=" + userid + ", calNum=" + calNum + "]";
	}
	
	
	
}
