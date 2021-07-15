
public class Constructors {
	public Constructors(){
        System.out.println("Default constructor ran. This constructor has no arguments!");
    }

    public Constructors(double value){
        System.out.println(value);
    }

    public static void main(String[] args) {
        //create instances here
        Constructors c = new Constructors(5839.05);

        //use the no-arg constructor
        Constructors cNoArg = new Constructors();
    }
}

