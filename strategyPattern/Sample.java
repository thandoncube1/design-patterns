
import java.util.*;
import java.util.function.Predicate;

// Strategy Pattern
/**
 * We want to vary a small part of an algorithm while keeping the rest of the
 * algorithm the same.
 *
 * Language design is program design
 *
 * Design patterns often kick in to fill the gaps of a programming language.
 *
 * A more powerful language is, the less we talk about design patterns as these
 * naturally become the feautures of the language. In the past, how did we use
 * strategy: - We created an interface and a bunch of classes - Then wire them
 * together often use factories.
 *
 * Lambdas are lightweight strategies
 */
public class Sample {
    public static int totalValues(List<Integer> numbers, Predicate<Integer> selector) {
        // int total = 0;

        // for(var number: numbers) {
        //     if (selector.test(number)) {
        //         total += number;
        //     }
        // }

        // return total;

        return numbers.stream() // functional programming solution
                    .filter(selector)
                    .mapToInt(e -> e)
                    .sum();
    }

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public static void main(String[] args) {
        var numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(totalValues(numbers, ignore -> true));
        System.out.println(totalValues(numbers, number -> number % 2 == 0));
        System.out.println(totalValues(numbers, Sample::isOdd)); // Refactored to work in the case where you are forced to duplicate code.
    }
}

/**
 * Suppose we have a collection of numbers, maybe price of stock, products, etc.
 * 
 * We are asked to write a method to total all values.
 * 
 * So, functional interfaces and lambdas work really well to strategies in general.
 * 
 * __ We just did some refactoring to bring in a strategy in our code
 */