package day7;

class Calculator2<T>{

    public boolean areEqual(T a , T b){
        if(a.equals(b))
            return true;
        else
            return false;
    }
}

public class Demo3 {
    public static void main(String[] args) {
        Calculator2<String> cal = new Calculator2<>();

        boolean result = cal.areEqual("A", "B");

        Calculator2<Integer> cal2 = new Calculator2<>();
        boolean result2 = cal2.areEqual(10, 10);

        System.out.println(result);
        System.out.println(result2);
    }
}