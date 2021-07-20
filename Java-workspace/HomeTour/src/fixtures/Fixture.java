package fixtures;

public abstract class Fixture {
	String name;
	String shortDescription;
	String longDescription;
	
	public Fixture(String name, String shortDescription, String longDescription) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}
	
	public String getName() {
		return name;
	}
	
	public String shortDescription() {
		return shortDescription;
	}
	
	public String longDescription() {
		return longDescription;
	}
}
