import java.util.Arrays;

public class PizzaTester {
	public static void main(String[] args) {
		String[] toppings = {"Jalapenos", "Olives", "Jalapenos", "anchovies"};
		Pizza cheesePizza = new Pizza(toppings, "deep dish", 'L', 8);
		
		Pizza theDavid = new Pizza(new String[] {"cheese", "sasuage", "pepperoni"}, 'L', 10);
		
		System.out.println(Arrays.toString(theDavid.getTopping()));
		
		System.out.println(Pizza.numOfPizzasMade);
		
		Pizza.advertise();
		
		System.out.println(theDavid.eatSlice(5));
		System.out.println(theDavid.eatSlice());
		
		theDavid.pizzaFight(cheesePizza);
	}
	
	

}