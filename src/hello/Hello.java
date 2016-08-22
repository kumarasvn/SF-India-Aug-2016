package hello;

import annotations.DoStuff;
import annotations.SetMe;

public class Hello {
    @SetMe
    private String name = "Unset";
    
    @DoStuff
    public void runMe() {
        System.out.println("This is run me...");
    }
    
    @DoStuff
    private void runMeToo() {
        System.out.println("More and more !");
    }
    
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    @Override
    public String toString() {
        return "Hello{" + "name=" + name + '}';
    }
}
