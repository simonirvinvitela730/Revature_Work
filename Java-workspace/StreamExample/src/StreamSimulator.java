import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;

public class StreamSimulator {
	public static FileOutputStream fos = null;
	public static FileInputStream fis = null;
	
	public static void main(String[] args) {
		System.out.println("Start");
		try {
			//fosExample();
			fisExample();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("End");
	}
	
	public static void fosExample() throws IOException{
		fos = new FileOutputStream("files/myFile.txt");
		for (int i=0; i<5; i++) {
			for (char letter = 'A'; letter <= 'Z'; letter++) {
			fos.write(letter);
			}
			fos.write('\n'); //starts new line
		}
		fos.close();
	}
	
	public static void fisExample() throws IOException {
		fis = new FileInputStream("files/myFile.txt");
		byte input;
		while ((input = (byte)fis.read()) != -1) {
			System.out.print((char)input);
		}
	}
}
