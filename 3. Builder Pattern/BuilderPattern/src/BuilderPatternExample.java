import java.sql.Struct;
import java.util.*;

interface Builder{ // this is the common interface for the motor vehicles
    void startUpOperations();
    void buildBody();
    void insertWheels();
    void addHeadlights();
    void endOperations();
    Product getVehicle(); //the following method is used to retrieve the object which has been constructed.

}

class Car implements Builder{
    private String brandName;
    private Product product;

    public Car (String brand){
        product = new Product ();
        this.brandName = brand; // brandname, the class variable is equal to the local variable being passed.
    }

    public void startUpOperations(){ // we inform the brandname here
        product.add(String.format("Model is %s", this.brandName));
    }

    public void buildBody(){ // public since it will be used by others too, void since it is not denoting anything
        product.add("This is body of a car");
    }

    public void insertWheels(){
        product.add("The 4 wheels are added");
    }

    public void addHeadlights(){
        product.add("2 headlights are added");
    }

    public void endOperations(){
        //nothing to be added here since we will continue with motorcycle too
    }


    public Product getVehicle() { // returns the product data
        return product;
    }
}

//Motorcycle class

class MotorCycle implements Builder{
    private String brandName;
    private Product product;
    public MotorCycle(String brand){
        product = new Product();
        this.brandName = brand;
    }
    public void startUpOperations(){} // why nothing in this case?

    public void buildBody(){ // public since it will be used by others too, void since it is not denoting anything
        product.add("This is body of a bike");
    }

    public void insertWheels(){
        product.add("The 2 wheels are added");
    }

    public void addHeadlights(){
        product.add("1 headlights are added");
    }

    public void endOperations(){
      product.add(String.format(("Bike model is %s"), this.brandName)); // string format is used since we have to add a variable in the linkedlist of the product class
    }



    public Product getVehicle() { // returns the product data
        return product;
    }

}

//The following is the product class

class Product{
    /*linkedlist is used to store the data in a list structure*/

    private LinkedList<String> parts;
    public Product(){
        parts = new LinkedList<String>();
    }

    public void add(String part){ // since everything in it is a string, we use string format function
        parts.addLast(part); // sequence of adding data
    }

    public void showProduct(){
        System.out.println("\nproduct is done as below");
        for(String part : parts){
            System.out.println(part);
        } // the above is like a foreach loop that prints the whole contents of the linkedlist
    }

}


//The following is the director class. Director is also like an architect who builds
// the whole product in the sequence of steps.

class Director{
    Builder builder;

    public void construct(Builder builder){
        this.builder = builder;
        builder.startUpOperations();
        builder.buildBody();
        builder.insertWheels();
        builder.addHeadlights();
        builder.endOperations();
    } //the above is the sequence of building the car
}

public class BuilderPatternExample{
    public static void main(String[] args) {
        System.out.println("Demo");

        Director director = new Director(); // creating an instance of a director.

        Builder fordCar = new Car("Ford");

        Builder hondaBike = new MotorCycle("Honda");

        // the following is director making a car

        director.construct(fordCar);

        Product p1 = fordCar.getVehicle(); // fetches the details of the vehicle and
        // stores it in p1
        p1.showProduct();
        //in the following director is making a bike

        director.construct(hondaBike);

        Product p2 = hondaBike.getVehicle();

        p2.showProduct();
    }
}