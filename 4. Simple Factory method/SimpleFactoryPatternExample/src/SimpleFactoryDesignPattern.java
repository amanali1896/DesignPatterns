import java.util.*;

interface Animal{ // in this simple factory design we define the main parameters.
    void speak();
    void preferredAction();
}

class Dog implements Animal{ //note: we implement the interface, and we inherit the classes
    public void speak(){
        System.out.println("Dog says : Bow!");
    }

    public void preferredAction(){
        System.out.println("Dog likes to bark.");
    }
}

class Tiger implements Animal{
    public void speak(){
        System.out.println("Tiger says : Halum!");
    }

    public void preferredAction(){
        System.out.println("Tiger likes to hunt.");
    }
}

class SimpleFactory{ // this class is what creates choice for animals and then
    // moves to the individual classes to perform the required methods.
    public Animal createAnimal(){
        Animal intendedAnimal = null; // objects cannot be initialised to zero. so null.
        System.out.println("Enter your choice(0 for a dog, 1 for a tiger)");
        /*The following line is to supress the warning message:Resource leak:
        * 'input' is never closed.*/
      //  @SuppressWarnings("resource");
        Scanner input = new Scanner(System.in); // declaring a scanner. This helps us take the input.
        int choice = Integer.parseInt(input.nextLine());//parse the input as an integer

        System.out.println("The choice is " + choice);

        switch (choice){
            case 0:
                intendedAnimal = new Dog();
                break;

            case 1:
                intendedAnimal = new Tiger();
                break;

            default:
                System.out.println("Select either only 0 and 1. nothing other than that");
                throw new IllegalArgumentException("Your choice creates an unknown Animal");
        }
        return intendedAnimal;
    }
}

// This is the class that gives access to clients. Clients decide the animal
public class SimpleFactoryDesignPattern { //abstraction creates security. we can change code in backend instead of front-end
    public static void main(String[] args) {
        Animal preferredType = null ; // objects cannot be initialised to zero. so null.

        SimpleFactory simpleFactory = new SimpleFactory();

        //The code will be change based on Users preference.
        preferredType = simpleFactory.createAnimal(); //goes tp SimpleFactory class's createAnimal method
        // the following code does not change since all the animals can speak and
        // prefer their tasks.

        preferredType.speak();
        preferredType.preferredAction();
    }
}
