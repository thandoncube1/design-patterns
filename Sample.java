import java.util.*;

public class Sample {
    // legacy code

    // tempting, but don't
    // public static void setName(Optional<String> name) {
    //     if (name.isPresent()) {
    //         // use the given name
    //     } else {
    //         // Use the default value Thando
    //     }
    // }

    /**
     * SetName(Optional.empty());
     * 
     * setName(Optional.of("Thando"));
     * punishment
     */

    // A good design has empty

    public static void setName() {
        // use the given name
    }

    public static void setName(String name) {
        // use the given name
    }

    public static Optional<String> getName() {
        // return null; // Bad idea
        if (Math.random() > 0.5) {
            return Optional.of("Thando");
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        var result = getName();
        // This is to prevent a Null pointer exception.
        // Does the code convey the code really clearly
        System.out.println(result.orElse("Not Found"));

        // This example is much better than get.
        System.out.println(result.orElseThrow()); // This method returns the value at all times unless there is no value it throws an exception.
    }
}

// Don't use Optional<T> as a parameter to methods
// If needed, use overloading instead.

// There is little reason to use Optional as a field
// Return optional only when your object doesn't exist. (Promises)