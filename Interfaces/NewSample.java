import java.util.*;

class Resource implements AutoCloseable {
    public Resource() { System.out.println("created..."); }
    public Resource opt1() {
        System.out.println("opt1...");
        return this;
    }
    public Resource opt2() {
        System.out.println("opt2...");
        return this;
    }
    public void close() {
        System.out.println("Release external resource");
    }
}

public class NewSample {
    public static void main(String[] args) {
        // ARM - Automatic Resource Management
        // We can use a try with resources
        try (Resource resource = new Resource()){
            resource.opt1();
            resource.opt2();
        }
        // In the case of an exception
        System.out.println("Easy to forget and verbose.");
    }
}