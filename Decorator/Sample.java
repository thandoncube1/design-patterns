import java.util.function.Function;

public class Sample {
    public static void print(int number,
        String message, Function<Integer, Integer> func) {
            System.out.println(number + " " + message + ": " + func.apply(number));
        }
    public static void main(String[] args) {
        Function<Integer, Integer> inc = value  -> value + 1;
        Function<Integer, Integer> doubled = value  -> value * 2;

        print(5, "incremented", inc);
        print(5, "doubled", doubled);
    }
}

/*
- This is a decorator and it doesn't seem to look good in this implementation.

    DataInputStream dis =
        new DataInputStream(
            new BuffererStream(
                new FileInputStream(...)));


- The idea that functions are composable.
- If you want to compose a function you just make use of the ideas we have learned here to create a combined function of two ideas to return an output.
- Method chaining or creating a pipeline -> value from FuncA passed to FuncB to Return a value that can also be passed to another FuncC if needed.

    inc -----> |inc| ----->
    doubled -----> |doubled| ------>

    Combined
    ---->|----->|inc|----->|doubled|----->|------>
*/