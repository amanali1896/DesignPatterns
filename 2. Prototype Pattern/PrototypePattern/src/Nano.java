/*This is one of the variety of cars*/


class Nano extends BasicCar{

    public int basePrice=100000;
    public Nano(String m){
        modelName = m;
    }

    @Override //is used to override previous code.
    public BasicCar clone() throws CloneNotSupportedException{
        return (Nano)super.clone();
        //return this.clone();
    }




}
