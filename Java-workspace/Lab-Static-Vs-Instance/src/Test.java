
public class Test {
	public static void main(String[] args) {
        ClassA.staticCount = 2494;
        System.out.println("class A staticCount: " + ClassA.staticCount);

        ClassA a = new ClassA();

        System.out.println(a.instanceCount);
        System.out.println(ClassA.staticCount);

        ClassA a2 = new ClassA();

        System.out.println(a2.instanceCount);
        System.out.println(ClassA.staticCount);

        a.instanceCount = 15;

        System.out.println("object a instanceCount: " + a.instanceCount);
        System.out.println("object a2 instanceCount: " + a2.instanceCount);
        
        System.out.println("class A staticCount: " + ClassA.staticCount);
    }
}
