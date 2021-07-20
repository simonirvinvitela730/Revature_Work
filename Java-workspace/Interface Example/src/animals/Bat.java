package animals;
import utilities.Flyable;
import utilities.Herbivorous;

public class Bat implements Flyable, Herbivorous{
	public void fly() {
		System.out.println("Flying");
	}
	
	@Override
	public void eat() {
		System.out.println("Eating");
	}
}
