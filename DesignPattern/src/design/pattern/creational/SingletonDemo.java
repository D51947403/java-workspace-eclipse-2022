package design.pattern.creational;
/**
 * https://www.digitalocean.com/community/tutorials/java-singleton-design-pattern-best-practices-examples
 * @author Devendra Singraul
 *
 */
public class SingletonDemo {

	public static void main(String[] args) {
		 //illegal construct
	      //Compile Time Error: The constructor SingleObject() is not visible
	      //SingleObject object = new SingleObject();

	      //Get the only object available
	      SingleObject object = SingleObject.getInstance();

	      //show the message
	      object.showMessage();
	      
	      

	}

}

 class SingleObject {

	   //create an object of SingleObject
	   private static SingleObject instance = new SingleObject();

	   //make the constructor private so that this class cannot be instantiated outside 
	   private SingleObject(){
		   System.out.println("private constructor");
	   }

	   //Get the only object available
	   public static synchronized SingleObject getInstance(){
	      return instance;
	   }

	   public void showMessage(){
	      System.out.println("Hello World!");
	   }
	   
	   
	}
