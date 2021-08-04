package day7;

// Generic Constructor

class Employee{
	String name;
	
	public <E> Employee(E name){
		this.name = name.toString();
	}
}
public class Demo6 {
	public static void main(String[] args) {
		Employee emp1 = new Employee("mark");
		Employee emp2 = new Employee(123);
	}
}
