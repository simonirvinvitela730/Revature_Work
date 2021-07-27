package day2;
/*
 * Default interface method
 */
interface Drawable{
    void draw();

    default void print(){
        System.out.println("printing...");
    }
}

class Rect implements Drawable{

    @Override
    public void draw() {
        System.out.println("drawing...");
    }
}


public class Demo22 {
    public static void main(String[] args) {
        Rect rectObj = new Rect();
        rectObj.draw();
        rectObj.print();
    }
}