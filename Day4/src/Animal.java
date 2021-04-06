
public class Animal {
   // Attributes Of An Animal
	private String name;
	private String color;
	private char size;
	private int strength;
	private int health;
	
	// Constructor
	public Animal(String name, String color, char size, int strength) {
		this.name = name;
		this.color = color;
		this.size = size;
		this.strength = strength;
		this.health = 100;
	}
	
	// Attack other animal
	public void battle(Animal target, String powerMove) {
		// Define logic of how an animal attacks
		int damage;
		if(powerMove.equals("iron_tail")) {
			damage = 3;
		} else if(powerMove.equals("swipe")) {
			damage = 5;
		} else if(powerMove.equals("stampede")){
			damage = 6;
		} else if (powerMove.equals("axeKick")){
			damage = 4;
		} else {
			System.out.println("Move Not Recognized");
			return;
		}
		
		// multiple strength x damage
		int effectiveDamage = this.strength * damage;
		
		// Reduce the target's health by the effectiveDamage
		int health = target.getHealth();
		health -= effectiveDamage;
		target.setHealth(health);
		
		// Print to the console what just happened, using a formatted string
		System.out.printf("%s attacks %s for %d health points \n", this.name, target.getName(), effectiveDamage);
	}
	
	// Overload Battle Method
	public void battle(Animal target) {
		this.battle(target, "iron_tail");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public char getSize() {
		return size;
	}

	public void setSize(char size) {
		this.size = size;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	
	
}
