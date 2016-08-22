package hello;

import annotations.DoStuff;

public class Hello {

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
}
