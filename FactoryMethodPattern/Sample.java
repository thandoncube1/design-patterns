/**
 * How to use default methods when it comes to classes. Interfaces are better than abstract classes. Abstract classes carry state but interfaces don't
 */
interface Pet {}
class Dog implements Pet {}
class Cat implements Pet {}

interface Person {
    Pet getPet();

    default void play() {
        System.out.println("playing with " + getPet());
    }
}

class DogPerson implements Person {
    private Dog dog = new Dog();
    public Pet getPet() { return dog; }
}

class CatLover implements Person {
    private Cat cat = new Cat();
    public Pet getPet() { return cat; }
}

public class Sample {
    // Call method is used to person and return the Pet
    // they own or love.
    public static void call(Person person) {
        person.play();
    }
    public static void main(String[] args) {
        call(new DogPerson());
        call(new CatLover());
    }
}

/**
 *  The difference between and Abstract Factory vs Factory Method
 *
    Factory Method: A class or an interface relies on a derived class to provide the implementation whereas the base provides the common behaviour that you want to capture.

    Factory Method uses inheritance as a design tool.
 */