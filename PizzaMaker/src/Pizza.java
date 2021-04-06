import java.util.Arrays;

public class Pizza {
	// Things PIzzas Have
	// Attributes
	private String[] topping;
	private String crustType;
	private char size;
	private int slices;
	static int numOfPizzasMade;
	
	// Constructor
	public Pizza(String[] topping, String crustType, char size, int slices) {
		this.topping = topping;
		this.crustType = crustType;
		this.size = size;
		this.slices = slices;
		numOfPizzasMade++;
	}
	
	// Method Overloading
	public Pizza(String[] topping, char size, int slices) {
		this.crustType = "Deep Dish";
		this.topping = topping;
		this.size = size;
		this.slices = slices;
		numOfPizzasMade++;
	}
	
	
	// Things you can do 
	// Advertise()
	// Eat()
	
	public int eatSlice(int slices) {
		this.slices -= slices;
		return this.slices;
	}
	
	// Overloaded Eat Slice Method
	public int eatSlice() {
		this.slices -= 1;
		return this.slices;
	}
	
	public void pizzaFight(Pizza otherPizza) {
		otherPizza.eatSlice();
		System.out.printf("%s took a bite out of %s and is missing 1 piece! \n", Arrays.toString(this.topping), Arrays.toString(otherPizza.topping));
		System.out.println(Arrays.toString(otherPizza.topping) + " now has " + otherPizza.getSlices() + "slices");
	}

	public static void advertise() {
		System.out.println("Edgar's pizzaria, definitely not mob affiliated... wink wink");
	}

	// Getters and Setters
	public String[] getTopping() {
		return topping;
	}

	public void setTopping(String[] topping) {
		if(topping.equals("")) {
			System.out.println("Hey there, you need to have something to top the pziza!");
			return;
		}
		this.topping = topping;
	}

	public String getCrustType() {
		return crustType;
	}

	public void setCrustType(String crustType) {
		this.crustType = crustType;
	}

	public char getSize() {
		return size;
	}

	public void setSize(char size) {
		this.size = size;
	}

	public int getSlices() {
		return slices;
	}

	public void setSlices(int slices) {
		this.slices = slices;
	}

	
}
