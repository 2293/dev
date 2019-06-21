package ml2293.basic;

import java.util.function.Consumer;
public class ComsumerDemo {
    public static void main(String args[]) 
    { 
        // Consumer to display a number 
        Consumer<Integer> display = a -> System.out.println(a);
        Consumer<Integer> displaySquare = a -> System.out.println(a*a);
        // invoke display using accept() 
        display.accept(10);
        //andThen 表示了依次调用的顺序
        display.andThen(displaySquare).accept(9); 
    }
}
