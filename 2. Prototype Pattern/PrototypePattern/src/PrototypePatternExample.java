public class PrototypePatternExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        BasicCar nano = new Nano("Red Nano");
        nano.basePrice = 100000;

        BasicCar ford = new Ford("Ford Blue");

        ford.basePrice = 500000;

        BasicCar bc1; // creating a basic car object.

        //Nano
        bc1=nano.clone(); // cloning from nano class. nano class in turn clones from the basic car car.
        bc1.onRoadPrice = nano.basePrice+BasicCar.setAdditionalPrice(); // set additional price uses a random number. so base price + random price is the road price. instead of random we can select a fixed price to be returned.

        System.out.println("Car " + bc1.modelName+" price "+bc1.onRoadPrice);

        //ford
        bc1=ford.clone(); // cloning from ford class. ford class in turn clones from the basic car car.
        bc1.onRoadPrice = ford.basePrice+BasicCar.setAdditionalPrice();

        System.out.println("Car " + bc1.modelName+" price "+bc1.onRoadPrice);


    }
}
