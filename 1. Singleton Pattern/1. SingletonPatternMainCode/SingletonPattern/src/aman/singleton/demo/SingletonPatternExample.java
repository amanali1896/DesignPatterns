package aman.singleton.demo;

public class SingletonPatternExample {
    public static void main(String[] args) {
        System.out.println("Demo");
        System.out.println("Try to make a captain for your team");

      //  Captain c3= new Captain(); // since constructor is private, we cannot modify here
        // single instance of a object=singleton pattern
        Captain captain1=Captain.getCaptain();
        Captain captain2=Captain.getCaptain();

        if(captain1==captain2){
            System.out.println("Both captain are same instances");
        }
    }
}
