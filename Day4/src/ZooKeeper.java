import java.util.ArrayList;

public class ZooKeeper {
	// Entry Point Method
	public static void main(String[] args) {
		Mammal matt = new Mammal("Human", 100);
		Gorilla maggilla = new Gorilla();
		Barrel barrel = new Barrel("barrel1");
		
		Gorilla dK = new Gorilla();
		dK.attack(barrel);
		
		maggilla.eatBanana();
		
		ArrayList<Mammal> ourMammals = new ArrayList<Mammal>();
		ourMammals.add(matt);
		ourMammals.add(maggilla);
		
		for(Mammal m : ourMammals) {
			System.out.println(m.getSpecies());
		}
	}
}
