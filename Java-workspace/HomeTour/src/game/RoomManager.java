package game;
import fixtures.Items;
import fixtures.Room;

import java.util.ArrayList;

public class RoomManager {
	ArrayList<Room> rooms= new ArrayList<Room>();

	private Room startingRoom;
	
	public Room getStartingRoom() {
		return this.startingRoom;
	}
	
	public void setStartingRoom(Room room) {
		this.startingRoom = room;
	}

	public void init() {
	    	Room frontLawn = new Room("Front Lawn", "Outside of a strange place you can't quite comprehend",
	    			"Welcome to THE SPOOKY DOOR! You stand in the front lawn at the front door of a maze within the mind of a gerbil. \n"
	    			+ "The oven is on and you feel the warm air rise to the top of your psyche... or was it a chill? \n"
	    			+ "Steve Martin sits a few feet away from you strumming a banjo made of clavenets. \n"
	    			+ "And your eyebrows begin to dance around your ears. Good luck traversing this convoluted world! \n"
	    			+ ".......\n"
	    			+ "\n"
	    			+ "\n"
	    			+ "use command 'help' to read commands list");
			rooms.add(frontLawn);
			setStartingRoom(frontLawn);
			
			Room mainHall = new Room("Main Hall", "The main hall of the gerbil's crainum",
	    			"You enter the main hall. \nLarge outstretched canopies made of the finest silk worms stretch accross the room.\n"
	    			+ "The scent of hubris and pellets lingers in the air as you walk uneasily through the viscous liquid covering the floor.\n"
	    			+ "Steve Martin floats, hovering around you, strumming quietly...");
			rooms.add(mainHall);
			
			Room kitchen = new Room("Kitchen", "A small kitchen with a worn expression",
	    			"You come across a kitchen on the northwest side of the estate. It appears the tennants enjoy guzzling water.\n"
	    			+ "And, as you might expect, the larynxes of small children. Such is the life of a gerbil.\n"
	    			+ "Steve Martin stretches his long appendiges and questions his very existence to the side of the room.");
			rooms.add(kitchen);
			
			Room diningRoom = new Room("Dining Room", "The stench of pellets resides strongest in this room",
	    			"You enter a dining room caked with birthday cards and your closest relatives. \n"
	    			+ "It seems as though you've arrived late to the party. What a shame.\n"
	    			+ "Steve Martin is always prepared for the ocassion and gleefully pulls out a kazoo.");
			rooms.add(diningRoom);
			
			Room billiards = new Room("Billiards Room", "A pool hall residing nearest to our dear friend the gerbil's amygdala",
	    			"We find ourselves in what appears to be a billiards room complete with a bar and a shadowy figure.\n"
	    			+ "While that's all well and concering it does appear that there's a jukebox too. You win some you lose some.\n"
	    			+ "Steve Martin, prepared as always, transforms into a shadow himself and begins to transcend our reality.");
			rooms.add(billiards);
			
			Room livingRoom = new Room("Living Room", "An open living space complete with a horse-drawn carriage",
	    			"You enter the living room basking in confusion. At the forefront of the room is a bright yellow taxi.\n"
	    			+ "Along with an equally confounding bright yellow horse-drawn carriage which seems to flash in and out of existence.\n"
	    			+ "Steve Martin waits patiently for his turn to pet the horses to no avail...");
			rooms.add(livingRoom);
			
			Room laundry = new Room("Laundry Room", "A mere closet containing 3 New York aparments",
	    			"As you exit the dining room you enter a laundry room containing a slew of apartments.\n"
	    			+ "While a laundry room by name, there are no washers or dryers, only enough space to walk uncomfortably through.\n"
	    			+ "Viles of various liquids line the wall and tell each other stories about 'the good old days.'\n"
	    			+ "Steve Martin readily joins in, recounting their good times at the 1974 Montreal Olympics.");
			rooms.add(laundry);
			
			Room dumbwaiter = new Room("Dumbwaiter", "A dumbwaiter that goes between the basement and the dining room",
	    			"It's pretty cramped in here with Steve Martin.");
			rooms.add(dumbwaiter);
			
			Room basement = new Room("Basement", "A dimly lit musty unfinished room which is hard to make out",
					"You stumble into a dark room where very little light enters.\n It seems like there is something blurry on the wall "
	    			+ "but you can't quite tell.\n Steve Martin waits prone in the dumbwaiter, scared to enter the room.");
			rooms.add(basement);
			
			Room arcade = new Room("Arcade", "A miniature arcade containing lots of various games with bright flashing lights",
	    			"You enter what appears to be an arcade that's overwhelmingly bright. You're immediately inundated entering the room.\n"
	    			+ "To the side of the room you spot two mysterious sacks along with a pile of dead bodies. \n"
	    			+ "A smoke machine spews multi-colored smoke in all directions which takes shape into a sheep. \n"
	    			+ "Steve Martin, friend of all ovine companions, quickly befriends the smoke sheep and begins playing pinball.");
			rooms.add(arcade);
			
			Items taxi = new Items("Taxi", "A taxi cab", "A large yellow taxi is parked in the middle of the room");
			
			Items iceCream = new Items("Lice Cream", "Your favorite dessert with a new twist", "The name says it all. Take a lick!");
		
			Items lantern = new Items("Lantern", "A lantern! Who cares?", "Use the command 'use' + lantern to brighten this place up a bit");
		
			Items plague = new Items("Sacks of Bubonic Plague", "Are you sure you want to be messing with this?", 
					"The manifestation of plague itself...fun stuff");
			
			Items jukebox = new Items("Jukebox", "A jukebox with unlimited credits and a limited selection", 
					"Your options are: Sweet Caroline.... .");
		
			frontLawn.setExits("north", mainHall);
			
			mainHall.setExits("west", diningRoom);
			mainHall.setExits("east", billiards);
			mainHall.setExits("north", livingRoom);
			
			diningRoom.setExits("west", laundry);
			diningRoom.setExits("north", kitchen);
			diningRoom.setExits("east", mainHall);
			diningRoom.setExits("down", dumbwaiter);
			
			dumbwaiter.setExits("down", basement);
			dumbwaiter.setExits("up", diningRoom);
			
			basement.setExits("up", dumbwaiter);
			basement.setItems(lantern);
			
			laundry.setExits("east", diningRoom);
			
			kitchen.setExits("south", diningRoom);
			kitchen.setExits("east", livingRoom);
			kitchen.setItems(iceCream);
			
			livingRoom.setExits("west", kitchen);
			livingRoom.setExits("south", mainHall);
			livingRoom.setExits("east", arcade);
			livingRoom.setItems(taxi);
			
			arcade.setExits("west", livingRoom);
			arcade.setExits("south", billiards);
			arcade.setItems(plague);
			
			billiards.setExits("north", arcade);
			billiards.setExits("west", mainHall);
			billiards.setItems(jukebox);
			
	}
}
