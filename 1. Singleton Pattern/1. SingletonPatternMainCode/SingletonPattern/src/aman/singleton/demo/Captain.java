package aman.singleton.demo;

final class Captain {
	private static Captain captain; // instance variable

	//private since we have to make constructor private
	//By this, others will not be able to change the value. and we will
	private Captain() {

	}
public static synchronized Captain getCaptain(){ //getCaptain is a getters method
	    /*Multi-threaded programs may often come to a situation where multiple threads try to access the same resources and finally produce erroneous and unforeseen results.

So it needs to be made sure by some synchronization method that only one thread can access the resource at a given point of time.*/
/*Lazy Initialization is a technique where one postpones the instantiation of a object until its first use. In other words the instance of a class is created when its required to be used for the first time. The idea behind this is to avoid unnecessary instance creation. But there are concerns related to using such approaches in a concurrent scenario*/
	/*by lazy initialisation we will avoid any other mistakes that can be made by the programmer*/
	if (captain==null){ // if no captain, then assign the captain.
		captain = new Captain(); // same instances!!!
		System.out.println("We have a new captain for the team");
	}
	else
	{
		System.out.println("You already have a captain. send him for a toss");
	}
	    return captain;


}


}

//since the constructor is private, class B extends captain() will be an issue.



