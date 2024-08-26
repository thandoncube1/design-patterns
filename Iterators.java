import java.util.*;

public class Iterators {
    public static void main(String[] args) {
        var names = List.of("Thando", "Eric", "Wilson", "Bruce", "Nemo", "Darla", "Marlin", "Jacques");
        // External iterators - We control the iteration

        // for (int i = 0; i <= names.size(); ...) {} // Verbose
        int count = 0;
        for (var name: names) {
            if (name.length() == 5) {
                System.out.println(name.toUpperCase());
                count++;
                // Continue
                if (count == 2) {
                    break;
                }
            }
        }

        System.out.println("----------");
        // internal iterator - Not controlling the flow of interation
        names.stream()
            .filter(name -> name.length() == 4)
            .map(String::toUpperCase)
            .limit(2)
            //.takeWhile(predicate)
            .forEach(System.out::println);

            // Limit and takeWhile are thefunction equivalent of the break
            // from the imperative style.
    }
}