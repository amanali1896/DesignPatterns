
interface Animal{
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

abstract class AnimalFactory{
    public abstract Animal createAnimal(); //this is just the abstract method to create
    //various factories.
}

class DogFactory extends AnimalFactory {

    public Animal createAnimal(){
        return new Dog(); // this is how we create a new dog.
    }
}

class TigerFactory extends AnimalFactory {

    public Animal createAnimal(){
        return new Tiger(); // this is how we create a new dog.
    }
}


class FactoryMethodPatternExample {

public static void main(String[] args){
    System.out.println("Demo \n");

    AnimalFactory tigerFactory = new TigerFactory();//creating a factory
    Animal aTiger = tigerFactory.createAnimal(); //creation of animal
    aTiger.speak();
    aTiger.preferredAction();

    AnimalFactory dogFactory = new DogFactory();//creating a factory
    Animal aDog = dogFactory.createAnimal(); //creation of animal
    aDog.speak();
    aDog.preferredAction();
/*Animal and AnimalFactory are two hierarchies running in parallel*/

}
}
