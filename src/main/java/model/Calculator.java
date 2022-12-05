package model;

public class Calculator {
	private String cal_day;
	private String cal_content;
	private int cal_point;
	private String color;
	private int userid;
	
	
	
	public Calculator(String cal_day, String cal_content, int cal_point, String color, int userid) {
		super();
		this.cal_day = cal_day;
		this.cal_content = cal_content;
		this.cal_point = cal_point;
		this.color = color;
		this.userid = userid;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "Calculator [cal_day=" + cal_day + ", cal_content=" + cal_content + ", cal_point=" + cal_point
				+ ", color=" + color + ", userid=" + userid + "]";
	}
	
	
	
	
	

}
