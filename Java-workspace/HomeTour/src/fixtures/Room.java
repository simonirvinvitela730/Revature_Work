package fixtures;

public class Room extends fixtures.Fixture {
	
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
	}
	
	public Room[] getExits() {
		return null;
		
	}
	
	public Room getExit(String direction) {
		return null;
	}
}
