import java.util.*;

public class InterfaceSample {
    public static void main(String[] args) {
        TrafficLight trafficLight = new RedLight();

        System.out.println("System value: " + trafficLight);
    }
}


// Creating closed hierarchy for interfaces.
// Also named sealed classes by other means of a name.