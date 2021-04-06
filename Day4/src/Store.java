
public class Store extends Order{
	private int storeId;

	public Store(int id, double total, String name) {
		super(id, total, name);
		this.storeId = 5;
	}
	
	public void cancelOrder() {
		System.out.println("Order has been canceled from " + this.storeId);
	}
	
}
