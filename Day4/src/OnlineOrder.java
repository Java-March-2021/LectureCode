
public class OnlineOrder extends Order {
	private int onlineId;
	
	public OnlineOrder(int id, int total, String name) {
		super(id, total, name);
		this.onlineId = 9;
	}
	
	public void cancelOrder() {
		System.out.println("This online order has been canceled");
	}
}
