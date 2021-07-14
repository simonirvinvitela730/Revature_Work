package main;

import java.util.Scanner;

public class Converter {

	public static void main(String[] args) {
		
		int menuSelection = 0;
		
		while (menuSelection != 42) {
		System.out.println("Welcome to the Unit-Converter!");
		System.out.println("To begin, please select an option by entering one of the following numbers:");
		System.out.println("1. Volume Conversions");
		System.out.println("2. Distance Conversions");
		System.out.println("3. Other Conversions");
		System.out.println("4. Quit");
		
		Scanner in = new Scanner(System.in);
		menuSelection = in.nextInt();
		switch(menuSelection) {
		
		default:
			System.out.println("Please enter a valid input! Re-run the program to convert.");
			break;
		case 1:
			System.out.println("");
			System.out.println("");
			System.out.println("Would you like to continue with a Volume Conversion?");
			System.out.println("If so, please select your conversion:");
			System.out.println("1. Cups to Teaspoons");
			System.out.println("2. US Gallons to Imperial Gallons");
			System.out.println("3. Fl oz to Liters");
			System.out.println("4. Quit");
			menuSelection = in.nextInt();
			switch(menuSelection){
			
			case 1:
				System.out.println("");
				System.out.println("");
				System.out.println("You've selected Cups to Teaspoons!");
				String teaspoons = "Teaspoons";
				String cups= "Cups";
				convertCupsToTeaspoons(collectQuantity(teaspoons, cups));
				System.out.println("To convert again re-run the program!");
				System.out.println("Goodbye!");
				break;
				
			case 2:
				System.out.println("");
				System.out.println("");
				System.out.println("You've selected US Gallons to Imperial Gallons!");
				String usGallons = "US Gallons";
				String impGallons= "Imperial Gallons";
				convertUsgallonsToImpgallons(collectQuantity(usGallons, impGallons));
				System.out.println("To convert again re-run the program!");
				System.out.println("Goodbye!");
				break;
			
			case 3:
				System.out.println("");
				System.out.println("");
				System.out.println("You've selected Fl oz to Liters!");
				String flOz = "Fl Oz";
				String liters= "Liters";
				convertFlozToLiters(collectQuantity(flOz, liters));
				System.out.println("To convert again re-run the program!");
				System.out.println("Goodbye!");
				break;
			
			case 4:
				System.out.println("To convert again re-run the program!");
				System.out.println("Goodbye!");
				menuSelection=42;
				break;
				
			}
			
			break;
			
		
		
		case 2:
			System.out.println("");
			System.out.println("");
			System.out.println("Would you like to continue with a Distance Conversion?");
			System.out.println("If so, please select your conversion:");
			System.out.println("1. Miles to Kilometers");
			System.out.println("2. Feet to Meters");
			System.out.println("3. Inches to Centimeters");
			System.out.println("4. Quit");
			menuSelection = in.nextInt();
			switch(menuSelection) {
			
			case 1:
				System.out.println("");
				System.out.println("");
				System.out.println("You've selected Miles to Kilometers!");
				String miles = "Miles";
				String kilometers= "Kilometers";
				convertMilesToKilometers(collectQuantity(miles, kilometers));
				System.out.println("To convert again re-run the program!");
				System.out.println("Goodbye!");
				break;
				
			case 2:
				System.out.println("");
				System.out.println("");
				System.out.println("You've selected Feet to Meters!");
				String feet = "Feet";
				String meters= "Meters";
				convertFeetToMeters(collectQuantity(feet, meters));
				System.out.println("To convert again re-run the program!");
				System.out.println("Goodbye!");
				break;
			
			case 3:
				System.out.println("");
				System.out.println("");
				System.out.println("You've selected Inches to Centimeters!");
				String inches = "Inches";
				String cent= "Centimeters";
				convertInchesToCentimeters(collectQuantity(inches, cent));
				System.out.println("To convert again re-run the program!");
				System.out.println("Goodbye!");
				break;
			
			case 4:
				System.out.println("To convert again re-run the program!");
				System.out.println("Goodbye!");
				menuSelection=42;
				break;
				
			}
			break;
			
		case 3:
			System.out.println("");
			System.out.println("");
			System.out.println("Would you like to continue with a Other Conversion?");
			System.out.println("If so, please select your conversion:");
			System.out.println("1. Faranheit to Celsius");
			System.out.println("2. Atmospheres to Pascals");
			System.out.println("3. Pounds to Kgs");
			System.out.println("4. Quit");
			menuSelection = in.nextInt();
			switch(menuSelection) {
			
			case 1:
				System.out.println("");
				System.out.println("");
				System.out.println("You've selected Faranheit to Celsius!");
				String far = "Faranheit";
				String cel= "Celsius";
				convertFarToCel(collectQuantity(far, cel));
				System.out.println("To convert again re-run the program!");
				System.out.println("Goodbye!");
				break;
				
			case 2:
				System.out.println("");
				System.out.println("");
				System.out.println("You've selected Atmospheres to Pascals!");
				String atm = "Atmospheres";
				String pa= "Pascals";
				convertAtmToPascals(collectQuantity(atm, pa));
				System.out.println("To convert again re-run the program!");
				System.out.println("Goodbye!");
				break;
			
			case 3:
				System.out.println("");
				System.out.println("");
				System.out.println("You've selected Pounds to Kgs!");
				String lbs = "Pounds";
				String kgs = "Kilograms";
				convertLbsToKgs(collectQuantity(lbs, kgs));
				System.out.println("To convert again re-run the program!");
				System.out.println("Goodbye!");
				break;
			
			case 4:
				System.out.println("To convert again re-run the program!");
				System.out.println("Goodbye!");
				menuSelection=42;
				break;
				
			}
			
			break;
			
		case 4:
			System.out.println("To convert again re-run the program!");
			System.out.println("Goodbye!");
			menuSelection=42;
		}
		in.close();
		break;
		
		}
		
	}

	
	private static double collectQuantity(String unit1, String unit2) {
		Scanner in = new Scanner(System.in);
		System.out.println("Ener amount of " + unit1 + " to be converted to " + unit2);
		double value;
		value= in.nextDouble();
		in.close();
		return value;
		 }
	
	
	public static double convertCupsToTeaspoons(double qty) {
		double teaspoons;
		double cups;
		teaspoons=qty;
		cups= teaspoons/48;
		if(teaspoons==1) {
			System.out.println(teaspoons + " Teaspoon is eqivalent to " + cups + " Cups!");
		}else if(cups==1) {
			System.out.println(teaspoons + " Teaspoons are eqivalent to " + cups + " Cup!");
		}else {
			System.out.println(teaspoons + " Teaspoons is eqivalent to " + cups + " Cups!");
		}
		
		return cups;
		
	}
	
	public static double convertUsgallonsToImpgallons(double qty) {
		double usGallons;
		double impGallons;
		usGallons=qty;
		impGallons= usGallons / 1.201;
		if(usGallons==1) {
			System.out.println(usGallons + " US Gallon is eqivalent to " + impGallons + " Imperial Gallons!");
		}else if(impGallons==1) {
			System.out.println(usGallons + " US Gallons are eqivalent to " + impGallons + " Imperial Gallon!");
		}else {
			System.out.println(usGallons + " US Gallons are eqivalent to " + impGallons + " Imperial Gallons!");
		}
		return impGallons;
		
	}
	
	public static double convertFlozToLiters(double qty) {
		double flOz;
		double liters;
		flOz=qty;
		liters=flOz / 33.814;
		if (flOz==1) {
			System.out.println(flOz + " Fluid ounce is eqivalent to " + liters + " Liters!");
		}else if(liters==1) {
			System.out.println(flOz + " Fluid ounces are eqivalent to " + liters + " Liter!");
		}else {
			System.out.println(flOz + " Fluid ounces are eqivalent to " + liters + " Liters!");
		}
		return liters;
		
	}
	
	public static double convertMilesToKilometers(double qty) {
		double miles;
		double kilometers;
		miles=qty;
		kilometers= miles/1.609;
		if(miles==1) {
			System.out.println(miles + " Mile is eqivalent to " + kilometers + " Kilometers!");
		}
		else if(kilometers==1) {
			System.out.println(miles + " Miles are eqivalent to " + kilometers + " Kilometer!");
		}else {
			System.out.println(miles + " Miles are eqivalent to " + kilometers + " Kilometers!");
		}
		return kilometers;
		
	}
	
	public static double convertFeetToMeters(double qty) {
		double feet;
		double meters;
		feet=qty;
		meters= feet/3.28084;
		if(feet==1) {
			System.out.println(feet + " Foot is eqivalent to " + meters + " Meters!");
		}
		else if(meters==1) {
			System.out.println(feet + " Feet are eqivalent to " + meters + " Meter!");
		}else {
			System.out.println(feet + " Feet are eqivalent to " + meters + " Meters!");
		}
		
		return meters;
		
	}
	
	public static double convertInchesToCentimeters(double qty) {
		double inches;
		double cent;
		inches=qty;
		cent= inches*2.54;
		
		if(inches==1) {
			System.out.println(inches + " Inch is eqivalent to " + cent + " Centimeters!");
		}
		else if(cent==1) {
			System.out.println(inches + " Inches are eqivalent to " + cent + " Centimeter!");
		}
		else {
		System.out.println(inches + " Inches are eqivalent to " + cent + " Centimeters!");
		}
		
		return cent;
		
	}
	
	public static double convertFarToCel(double qty) {
		double far;
		double cel;
		far=qty;
		cel= (far-32)*0.5555;
		if(far==1) {
			System.out.println(far + " degree Faranheit is eqivalent to " + cel + " degrees Celsius!");
		}else if(cel==1) {
			System.out.println(far + " degrees Faranheit is eqivalent to " + cel + " degree Celsius!");
		}else {
			System.out.println(far + " degrees Faranheit is eqivalent to " + cel + " degrees Celsius!");
		}
		return cel;
		
	}
	
	public static double convertAtmToPascals(double qty) {
		double atm;
		double pascals;
		atm=qty;
		pascals= atm*101325;
			if(atm==1) {
				System.out.println(atm + " Atmosphere is eqivalent to " + pascals + " Pascals!");
			}else {System.out.println(atm + " Atmospheres are eqivalent to " + pascals + " Pascals!");
				
			}
		return pascals;
		
	}
	
	public static double convertLbsToKgs(double qty) {
		double lbs;
		double kgs;
		lbs=qty;
		kgs= lbs/2.20462;
			if(lbs==1) {
				System.out.println(lbs + " Pound is eqivalent to " + kgs + " Kilograms!");		
			} 
			else if(kgs==1) {
				System.out.println(lbs + " Pounds are eqivalent to " + kgs + " Kilogram!");
			}
			else {
		System.out.println(lbs + " Pounds are eqivalent to " + kgs + " Kilograms!");
			}
		return kgs;
	}
	
}



