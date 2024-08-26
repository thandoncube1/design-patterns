import java.util.*;

public class Iterators {
    public static void iterator(List<String> names) {
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
    public static void main(String[] args) {
        var names = List.of("Thando", "Eric", "Wilson", "Bruce", "Nemo", "Darla", "Marlin", "Jacques");
        // External iterators - We control the iteration

        System.out.println("------------");

        iterator(names);

        System.out.println("--------------");

        var result1 = new ArrayList<String>();

        for (var name: names) {
            if (name.length() == 4) {
                result1.add(name.toUpperCase());
            }
        }

        System.out.println(result1);

        var result2 = new ArrayList<String>();
        names.stream()
            .filter(name -> name.length() == 4)
            .map(String::toUpperCase)
            .forEach(name -> result2.add(name)); // BAD IDEA - Modifying a pipeline that is given.
            // The functional pipeline is *not* pure
            // We are doing shared mutability - Changing to .parallel() or
            // by changing .stream() to .parallelStream()

            System.out.println(result2);

            // Functional pipeline offers internal iterators
            // is less complex
            // easy to modify
            // easy to understand
            // but...
    }
}

// It is very important that we make the functional pipeline as pure as possible. Avoid shared mutable variables.

// What is a pure function:
// A pure function is idempotent, it returns the same result for the same input and does not have any side effects.
// 1. It does not change any state that is visible outside
// 2. It does not depend on anything outside that may possibly change

// Functional programming relies on lazy evaluation for efficiency.
// Lazy evaluation and parallel execution rely on
// immutability and purity, not because it is fashionable, but because it is essential to its survival.