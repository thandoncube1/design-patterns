import java.util.*;
import java.util.function.Consumer;

class Mailer {
    public Mailer from(String address) {
        System.out.println("From...");
    }
    public Mailer to(String address) {
        System.out.println("To...");
    }
    public Mailer subject(String line) {
        System.out.println("Subject...");
    }
    public Mailer body(String content) {
        System.out.println("body...");
    }
    public static void send(Consumer<Mailer> block) {
        Mailer mailer = new Mailer();
        block(mailer);
        System.out.println("Sending...");
    }
}

public class Sample {
    public static void main(String[] args) {
        // This code is too verbose.
        // How to improve this is to actually return a Mailer on each method
        // Inside the Mailer class. 
        /**
         * Mailer mailer = new Mailer();
         * mailer.from(...);
         * mailer.to(...);
         */

        // We can use the cascade method pattern (A more general pattern compared to the builder).
        Mailer.send(mailer ->
            mailer
            .from("builder@thandoncube.com")
            .to("william@mymail.com")
            .subject("Your code sucks")
            .body("....details....")
        );
    }
}