package design.pattern.creational;

import design.pattern.creational.helper.PrototypeFactory.ModelType;
import design.pattern.creational.helper.Movie;
import design.pattern.creational.helper.PrototypeFactory;

// Client : Client will be responsible for using registry service to access prototype instances.
public class PrototypeDemo {

	public static void main(String[] args) {
		try {
			Movie movieObj=(Movie) PrototypeFactory.getInstance(ModelType.MOVIE);
			
			movieObj.display();
			        
			String moviePrototype = PrototypeFactory.getInstance(ModelType.MOVIE).toString();
			System.out.println(moviePrototype);

			String albumPrototype = PrototypeFactory.getInstance(ModelType.ALBUM).toString();
			System.out.println(albumPrototype);

			String showPrototype = PrototypeFactory.getInstance(ModelType.SHOW).toString();
			System.out.println(showPrototype);

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
