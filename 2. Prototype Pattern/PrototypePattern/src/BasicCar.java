/*This particular pattern is used for prototyping from a standard project.
* There are multiple ways in which this can be thought as. Like modifing an already existing codebase. Clone it/ Fork it and reimplement it or modify it. Github does it in a similar way. */

import java.util.*;
public abstract class BasicCar implements Cloneable{ //implements an interface!!
/*A method without body (no implementation) is known as abstract method. A method must always be declared in an abstract class, or in other words you can say that if a class has an abstract method, it should be declared abstract as well.*/


    public String modelName;
    public int basePrice, onRoadPrice;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public static int setAdditionalPrice(){
        int price = 0;
        Random r = new Random();
        //the below line gets an integer from 0 to 1000000
        int p = r.nextInt(100000);
        price = p;
        return price;

    }
    public BasicCar clone() throws CloneNotSupportedException{ /*Thrown to indicate that the clone method in class Object has been called to clone an object, but that the object's class does not implement the Cloneable interface.

Applications that override the clone method can also throw this exception to indicate that an object could not or should not be cloned.

clonable exception is always used when we implement cloning'

Clone() performs shallow copy and the object is returned with super.clone()

Deep copy is expensive as you have to create new objects.*/
        return (BasicCar)super.clone();
    }

}
