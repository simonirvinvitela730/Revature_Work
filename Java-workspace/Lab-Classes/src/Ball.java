
public class Ball {
	 String size;
	 String color;
	 
	   public void bounce(){
	        System.out.println("The " + size + " " + color + " ball is bouncing.");
	    }

	    public static void main(String[] args){
	        Ball b1 = new Ball();
	        Ball b2 = new Ball();

	        b1.size = "humongous";
	        b1.color = "purple";
	        b2.size = "petite";
	        b2.color = "teal";
	        
	        b1.bounce();
	        b2.bounce();
	    }
}
