
public class Gorilla extends Mammal{
	
	public Gorilla() {
		super("Gorilla", 500);

	}
	
	// Annotation
	@Override
	public void takeDamage(int damageAmount) {
		this.health -= (damageAmount/2);
	}
	
	public void eatBanana() {
		System.out.printf("I am a %s eating a banana \n", this.species);
	}
}
