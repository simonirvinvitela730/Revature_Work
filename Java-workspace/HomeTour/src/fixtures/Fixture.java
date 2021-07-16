package fixtures;

public abstract class Fixture {
	String name;
	String shortDescription;
	String longDescription;
	
	public Fixture(String n, String s, String l) {
		name = n;
		shortDescription = s;
		longDescription = l;
	}
}
