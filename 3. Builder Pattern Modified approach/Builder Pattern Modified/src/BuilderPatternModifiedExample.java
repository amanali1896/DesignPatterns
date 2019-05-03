/* common interface*/

interface ModifiedBuilder{
    //the return type for all the following methods is a modified builder
    //This will help us write the recursive statements or chaining the methods

    ModifiedBuilder startUpOperations(String startUpMessage);
    ModifiedBuilder buildBody(String bodyType);
    ModifiedBuilder insertWheels(int noOfWheels);
    ModifiedBuilder addHeadlights(int noOfHeadLights);
    ModifiedBuilder endOperations(String endOperationsMessage);

    //Combine all the various parts and make the final product
    ProductClass constructCar();

    //The following method gets the already constructed object

    ProductClass getConstructedCar();

}


//The following is a car class

class CarBuilder implements ModifiedBuilder{
    private String startUpMessage="Start Building the Product"; // default message

    private String bodyType = "Steel"; //this is the default body

    private int noOfWheels = 4;//this is the default number of wheels
    private int noOfHeadLights = 2; // this is the default number of headlights

    private String endOperationsMessage = "Product creation completed"; //since this is not overridden in code, this is default.

    ProductClass product;
    @Override

    public ModifiedBuilder startUpOperations(String startUpMessage){
        this.startUpMessage=startUpMessage;
        return this; //overriding the variable in this class again
    }

    @Override

    public ModifiedBuilder buildBody(String bodyType){
        this.bodyType=bodyType;
        return this;
    }

    @Override

    public ModifiedBuilder insertWheels(int noOfWheels){
        this.noOfWheels=noOfWheels;
        return this;
    }

    @Override

    public ModifiedBuilder addHeadlights(int noOfHeadLights){
        this.noOfHeadLights = noOfHeadLights;
        return this;
    }

    @Override

    public ModifiedBuilder endOperations(String endOperationsMessage){
        this.endOperationsMessage=endOperationsMessage;
        return this;
    }

    @Override

    public ProductClass constructCar(){ // return type is product class
        product = new ProductClass(this.startUpMessage,this.bodyType,this.noOfWheels,this.noOfHeadLights,this.endOperationsMessage);
        return product;
    }
    @Override
    public ProductClass getConstructedCar(){
        return product;
    }
}

//this is the product class

final class ProductClass{
    private String startUpMessage;
    private String bodyType;
    private int noOfWheels;
    private int noOfHeadLights;
    private String endOperationsMessage;

    public ProductClass (final String startUpMessage, String bodyType, int noOfWheels, int noOfHeadLights, String endOperationsMessage){
        this.startUpMessage=startUpMessage;
        this.bodyType = bodyType;
        this.noOfWheels = noOfWheels;
        this.noOfHeadLights = noOfHeadLights;
        this.endOperationsMessage = endOperationsMessage;

    }
    /*There are no setters to have immutability. Since attributes are private and
    * there are no setters methods, we need not have any final key*/

    @Override

    public String toString(){ //overriding toString method
        return "Product Completed as : \n startUpMessage= " + startUpMessage +"\n bodyType = "+ bodyType + "\n noOfWheels = "+ noOfWheels +"\n noOfHeadLights=" + noOfHeadLights + "\n endOperationsMessage="+ endOperationsMessage;


    }
}


//The following is the modified method in which director of the builder pattern is in the main method

public class BuilderPatternModifiedExample{
    public static void main(String[] args) {
        /*Steps:
        * 1. Get builder object with required parameters
        * 2. Methods are like setters and they will set the values too.
        * 3. Invoke constructCar() method to get the final car*/

        final ProductClass customCar1 = new CarBuilder().addHeadlights(5).insertWheels(5).buildBody("Plastic").constructCar();//default builder is used in this case.

        System.out.println(customCar1);
        System.out.println("\n");

        ModifiedBuilder carBuilder2= new CarBuilder(); //modified builder is used here for a new car

        final ProductClass customCar2 = carBuilder2.addHeadlights(6).insertWheels(7).startUpOperations("I am making second Car").constructCar();

        System.out.println(customCar2);

        System.out.println("\n");

        /*The Following one tests getConstructedCar() method*/

        final ProductClass customCar3 = carBuilder2.getConstructedCar();
        System.out.println(customCar3);
    }
}