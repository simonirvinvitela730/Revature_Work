package game;

import java.util.Scanner;

import fixtures.Room;

public class Main {
	public static void main(String[] args) {
		Room frontLawn = new Room("Front Lawn:", "Outside of a strange place you can't quite comprehend",
		"Welcome to THE SPOOKY DOOR! You stand at the front door of a maze within the mind of a gerbil. "
		+ "The oven is on and you feel the warm air rise to the top of your psyche... or was it a chill? "
		+ "Steve Martin sits a few feet away from you strumming a banjo made of clavenets. And your eyebrows"
		+ " begin to dance around your ears. Good luck travaersing this convoluted world!");
		
	
	}
	
	private static void printRoom(Player player) {
		System.out.println()
	}
	
	private static String[] collectInput() {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
	}
	
	private static void parse(String[] command, Player player) {
		
	}
}
