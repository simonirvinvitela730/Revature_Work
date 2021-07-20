package lambdas;

/*
 * Functional Interface because it is has
 * a single abstract method. If you define a second method within
 * an interface it ceases to be an functional interface
 * */
 
public class Simulator {
	public static void main(String[] args) {
		HelloWorldInterface hwi = new HelloWorldClass();
		hwi.sayHello();
		
		HelloWorldInterface hlam = () -> {
			System.out.println("Hello World- Lambda");
		};
		hlam.sayHello();
		
		TakeInput tiLam = (name, num) -> {
			System.out.println("Word: " + name + ", Num:" + num);
	};
	}
}
