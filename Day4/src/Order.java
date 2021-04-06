
public abstract class Order {
	private int id;
	private double total;
	private String name;
	
	public Order(int id, double total, String name) {
		this.id = id;
		this.total = total;
		this.name = name;
	}
	
	public abstract void cancelOrder();
	
}
