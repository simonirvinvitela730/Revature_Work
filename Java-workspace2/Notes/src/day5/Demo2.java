package day5;

class multiThreadingDemo2 implements Runnable{
	@Override
	public void run() {
		System.out.println("thread is running...");
	}
}
public class Demo2 {
	public static void main(String[] args) {
		multiThreadingDemo2 threadDemo2 = new multiThreadingDemo2();
		Thread t1 = new Thread(threadDemo2);
		t1.start();
	}
}
