package model;

public class Item {
	private String activity;
	private int itemPoint;
	private int itemid;
	
	public Item(String activity, int itemPoint, int itemid) {
		super();
		this.activity = activity;
		this.itemPoint = itemPoint;
		this.itemid = itemid;
	}
	
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public int getItemPoint() {
		return itemPoint;
	}
	public void setItemPoint(int itemPoint) {
		this.itemPoint = itemPoint;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	@Override
	public String toString() {
		return "Item [activity=" + activity + ", itemPoint=" + itemPoint + ", itemid=" + itemid + "]";
	}
	
	
}
