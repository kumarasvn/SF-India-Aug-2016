package annotations;

//@DoStuff
public class StuffClass {
//    @DoStuff
    private String name;
    
    @DoStuff
    public void runThisPlease() {
        System.out.println("Hello, this is runThisPlease");
    }
    
    public void dontRunThis() {
        System.out.println("Should not see this");
    }
    
    @DoStuff
    private void doThisOneToo() {
        System.out.println("This should also show up...");
    }
}
