
public class AnimalController {
	// Entry Point Method
	public static void main(String[] args) {
		Animal hippo = new Animal("Steve", "Gray", 'L', 10);
		Animal alligator = new Animal("Alex", "Dark Green", 'L', 10);
		
		hippo.battle(alligator, "axeKick");
		System.out.println(alligator.getHealth());
		
		alligator.battle(hippo, "stampede");
		System.out.println(hippo.getHealth());
		
		alligator.battle(hippo);
	}
	
	
	
}
