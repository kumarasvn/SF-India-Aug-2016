package annotations;

//@DoStuff
public class StuffClass {
    @SetMe
    private String name;
    
    @SetMe
    private String address;
    
    private String unset = "not set";
            
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

    @Override
    public String toString() {
        return "StuffClass{" + "name=" + name + ", address=" + address + ", unset=" + unset + '}';
    }
}
