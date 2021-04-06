
public interface Attackable {
	// If an object is attackable it has to have health
	int getHealth();
	void setHealth(int health);
	void takeDamage(int damageAmount);
}
