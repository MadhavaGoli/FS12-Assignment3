public class Animal {
    public void makeSound() {
        System.out.println("Animal makes a generic sound.");
    }
}


public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks.");
    }

    // Method Overloading
    public void makeSound(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Dog barks!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();

        // Method Overriding
        animal.makeSound(); // Output: Animal makes a generic sound.
        dog.makeSound();    // Output: Dog barks.

        // Method Overloading
        dog.makeSound(3);   // Output: Dog barks! Dog barks! Dog barks!
    }
}