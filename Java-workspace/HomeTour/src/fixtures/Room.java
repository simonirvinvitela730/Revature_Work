package fixtures;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Room extends fixtures.Fixture {
	private Map<String, Room> exits = new HashMap<>();
	private ArrayList<Items> items = new ArrayList<>();
	private ArrayList<Items> inventory = new ArrayList<>();
	
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
	}
	
	public void setExits(String direction, Room room) {
		exits.put(direction, room);
	}
	
	public Map<String, Room> getExits() {
		return this.exits;
	}
	
	public Room getExit(String direction) {
		for(String keyDirection : exits.keySet()) {
			if(keyDirection.startsWith(direction.toLowerCase().intern())) {
				return exits.get(keyDirection);
			}
		}
		return null;
	}
	
	public ArrayList<Items> getItems() {
		return items;
	}
	
	public void setItems(Items item) {
		items.add(item);
	}
	
	public ArrayList<Items> getInventory() {
		return inventory;
	}
	
	public void setInventory(Items item) {
		inventory.add(item);
	}
	
	public void removeInventory(Items item) {
		inventory.remove(item);
	}
	
	public String getName() {
		return name;
	}
	
	public String getShortDescription() {
		return shortDescription;
	}
	
	public String getLongDescription() {
		return longDescription;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	
}
