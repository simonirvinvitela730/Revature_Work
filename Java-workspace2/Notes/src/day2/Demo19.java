package day2;
/*
 * Interfaces-variables inherently abstract, final, private
 */
interface IEmployee{
    void print();
}

class Employee2 implements IEmployee{

    @Override
    public void print() {
        System.out.println("Interface print method");
    }
}

public class Demo19 {
    public static void main(String[] args) {
        Employee2 emp = new Employee2();
        emp.print();
    }
}