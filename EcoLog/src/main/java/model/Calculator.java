package model;

public class Calculator {
	private String id;
	private int totalPoint;
	
	public Calculator() {
		super();
	}

	public Calculator(String id, int totalPoint) {
		super();
		this.id = id;
		this.totalPoint = totalPoint;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTotalPoint() {
		return totalPoint;
	}
	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}
	
	public void sumPoint(int p) {
		totalPoint = totalPoint + p;
	}

	@Override
	public String toString() {
		return "Calculator [id=" + id + ", totalPoint=" + totalPoint + "]";
	}

}
