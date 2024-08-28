import java.util.function.Supplier;
/*
    Lazy evaluation is to functional programming as polymorphism is to object oriented programming.
    Laziness is implemented using the Streams API.

    To build your own Lazy class:
*/

class Lazy<T> {
    private T instance;
    private Supplier<T> supplier;

    public Lazy(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public T get() {
        if (instance == null) {
            instance = supplier.get();
        }

        return instance;
    }
}

public class Sample {
    public static int compute(int number) {
        // imagine takes some time to compute
        System.out.println("Compute called...");
        return number * 100;
    }

    public static void main(String[] args) {
        int value = 14;

        Lazy<Integer> temp = new Lazy(() -> compute(value));
        // Eager evaluation - Does not wait to see if you will use the value
        // To make this a lazy evaluation.
        if (value > 4 && temp.get() > 100) {
            System.err.println("path 1" + temp);
        } else {
            System.err.println("path 2");
        }
    }
}

/*
    Short circuiting is a process introduced during the Lisp days
    by John McArthy.

    - The best award needs to go to David Wheeler: In COmputer Science we can solve almost any problem by introducing one more level of indirection.
    - The level of indirection using pointers* in C or C++ made the language powerful.
    - In object oriented code, the ability to overriding a function gave the power of indirection. Running functions in the derived classes.
    - In Functional Programming, Lambdas give the power of indirection.

    In General,
    If you are writing a function

            myFunction1(Type value) - eager
            myFunction2(Supplier<Type> supplier) - lazy (This may be a better approach when dealing with optional values) - some level of indirection
        
        When do we pass value vs. a function interface to a method?

        - One consideration is lazy evaluation.
*/