package game;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import fixtures.Fixture;
import fixtures.Items;
import fixtures.Room;

public class Main {
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		RoomManager rm = new RoomManager();
		rm.init();
		Player player = new Player();
		player.setCurrentRoom(rm.getStartingRoom());
		
		boolean ongoing = true;
		
		do {
			printRoom(player);
			printShortDescription(player);
			System.out.println(" ");
			printLongDescription(player);
			System.out.println(" ");
			System.out.println("Exits: ");
			printExits(player);
			printItems(player);
			String[] commands = collectInput();
			ongoing = parse(commands, player);
		}while(ongoing);
		parse(collectInput(), player);
	
	}
	
	public static void printExits(Player player) {
		Room currentRoom = player.getCurrentRoom();
		Map<String,Room> exits = currentRoom.getExits();
		int i = 0;
		for(Entry<String, Room> exit : exits.entrySet()) {
			i++;
			System.out.println("Go " + exit.getKey() + ": " + exit.getValue().getName());
		}
	}
		
	public static void printItems(Player player) {
			System.out.println("ITEMS: ");
			Room currentRoom = player.getCurrentRoom();	
			for (int i = 0; i<currentRoom.getItems().size(); i++) {
				Items item = currentRoom.getItems().get(i);
				System.out.println(item.getName());
			}
	}
	
	public static void printRoom(Player player) {
		System.out.println(player.getCurrentRoom().getName().toUpperCase() + ":");
	}
	
	public static void printLongDescription(Player player) {
		System.out.println(player.getCurrentRoom().getLongDescription());
	}
	
	public static void printShortDescription(Player player) {
		System.out.println(player.getCurrentRoom().getShortDescription());
	}

	public static void printHelp() {
		System.out.println("Travel: use 'move' or 'go' plus a direction \n" +
	"Inspect items: use 'look' or 'inspect' plus an item's name \n" + 
	"Take items: use 'take' plus an item's name \n" + "Use item: use 'use' plus an item's name when it's in your inventory\n" + 
	"Open inventory: use 'inventory' \n" + "Open help: use 'help' \n" + "Quit: use 'exit'\n");
	} 
	
	private static String[] collectInput() {
		String input = in.nextLine().toLowerCase();
		String[] commands = input.split(" ");
		return commands;
	}
	
	public static void objectInteraction(String details, Player player) {
		Room currentRoom = player.getCurrentRoom();	
	}
	
	private static boolean parse(String[] commands, Player player) {
		switch(commands[0]) {
		case ("go"):
		case ("move"):
			if(player.getCurrentRoom().getExit(commands[1])  == null) {
				System.out.println("Nothing that way!");
				return true;
			}
			player.setCurrentRoom(player.getCurrentRoom().getExit(commands[1]));
			return true;
			
		case ("help"):
			printHelp();
			return true;
			
		case ("look"):
		case ("inspect"):
			if(player.getCurrentRoom().getItems().get(0)  == null) {
				System.out.println("Can't interact with that!");
				return true;
			}
			for (int i = 0; i<player.getCurrentRoom().getItems().size(); i++) {
				Items item = player.getCurrentRoom().getItems().get(i);
				System.out.println(item.getShortDescription());
				System.out.println(item.getLongDescription());
			}
			return true;
		
		case ("take"):
			if(player.getCurrentRoom().getItems().get(0)  == null) {
				System.out.println("You can't take that!");
				return true;
			}for (int i = 0; i<player.getCurrentRoom().getItems().size(); i++) {
				Items item = player.getCurrentRoom().getItems().get(i);
				player.getCurrentRoom().setInventory(item);
				System.out.println("You took " + item.getName() + " another one appeared mysteriously...");
				
			}
			return true;
		
		case ("inventory"):
			System.out.println("INVENTORY: ");
				if(player.getCurrentRoom().getInventory().size() == 0) {
					System.out.println("Your inventory is empty!");
					return true;
			}
			for (int i = 0; i<player.getCurrentRoom().getInventory().size(); i++) {
				Items inventory = player.getCurrentRoom().getInventory().get(i);
				System.out.println(inventory.getName());
			}
			return true;
			
		case ("use"):
			for (int i = 0; i<player.getCurrentRoom().getInventory().size(); i++) {
				Items inventory = player.getCurrentRoom().getInventory().get(i);
				if(inventory.getName() == "Lice Cream") {
					System.out.println("Mmmmm....gross");
					player.getCurrentRoom().removeInventory(inventory);
				}else if(inventory.getName() == "Taxi") {
					System.out.println("Beep Beep...man this thing is heavy");
					player.getCurrentRoom().removeInventory(inventory);
				}else if(inventory.getName() == "Lantern") {
					System.out.println("Ah man...this thing is busted. I'm out of here.");
					player.getCurrentRoom().removeInventory(inventory);
				}else if(inventory.getName() == "Sacks of Bubonic Plague") {
					System.out.println("Well, that will surely be the end of the world");
					player.getCurrentRoom().removeInventory(inventory);
				}else if(inventory.getName() == "Jukebox") {
					System.out.println("I'm tired of Sweet Caroline.");
					player.getCurrentRoom().removeInventory(inventory);
				}else {
					System.out.println("You can't use that");
				}
				
			}
			return true;
		
		case ("exit"):
			System.out.println("Thanks for playing!");
			return false;
		}
		System.out.println("I didn't understand that command. Please try another input!");
		return true;
	}
}
