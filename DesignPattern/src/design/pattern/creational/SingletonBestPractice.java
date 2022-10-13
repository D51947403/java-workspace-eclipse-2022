package design.pattern.creational;

/**
 * https://www.geeksforgeeks.org/java-singleton-design-pattern-practices-examples/
 * 
 * https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
 * 
 * @author Devendra Singraul
 *
 */
public class SingletonBestPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//Java code to create singleton class by Eager Initialization 
class SingletonEager {
// public instance initialized when loading the class 
	public static final SingletonEager instance = new SingletonEager();

	private SingletonEager() {
		// private constructor
	}

	public static SingletonEager getInstance() {
		return instance;
	}
}

//Java code to create singleton class Using Static block 
class SingletonStatic {
// public instance 
	public static SingletonStatic instance;

	private SingletonStatic() {
		// private constructor
	}

	static {
		// static block to initialize instance
		instance = new SingletonStatic();
	}
}

//Java Code to create singleton class With Lazy initialization 
// Good for single threaded environment
class SingletonLazy {
//private instance, so that it can be 
//accessed by only by getInstance() method 
	private static SingletonLazy instance;

	private SingletonLazy() {
		// private constructor
	}

//method to return instance of class 
	public static SingletonLazy getInstance() {
		if (instance == null) {
			// if instance is null, initialize
			instance = new SingletonLazy();
		}
		return instance;
	}
}

//Java program to create Thread Safe Singleton class 
class SingletonThreadSafe {
//private instance, so that it can be 
//accessed by only by getInstance() method 
	private static SingletonThreadSafe instance;

	private SingletonThreadSafe() {
		// private constructor
	}

//synchronized method to control simultaneous access 
	synchronized public static SingletonThreadSafe getInstance() {
		if (instance == null) {
			// if instance is null, initialize
			instance = new SingletonThreadSafe();
		}
		return instance;
	}
}

//Java code to explain double check locking 
class SingletonDoubleCheck {
//private instance, so that it can be 
//accessed by only by getInstance() method 
	private static SingletonDoubleCheck instance;

	private SingletonDoubleCheck() {
		// private constructor
	}

	public static SingletonDoubleCheck getInstance() {
		if (instance == null) {
			// synchronized block to remove overhead
			synchronized (SingletonDoubleCheck.class) {
				if (instance == null) {
					// if instance is null, initialize
					instance = new SingletonDoubleCheck();
				}

			}
		}
		return instance;
	}
}

//Java code for Bill Pugh Singleton Implementaion 
class SingletonBest {

	private SingletonBest() {
		// private constructor
	}

   //Inner class to provide instance of class 
	private static class BillPughSingleton {
		private static final SingletonBest INSTANCE = new SingletonBest();
	}

	public static SingletonBest getInstance() {
		return BillPughSingleton.INSTANCE;
	}
}
