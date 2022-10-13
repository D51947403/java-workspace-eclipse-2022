package design.pattern.creational.helper;

import java.util.HashMap;
import java.util.Map;

// Prototype registry : This is used as registry service to have all prototypes 
// accessible using simple string parameters.
public class PrototypeFactory {

	public static class ModelType {
		public static final String MOVIE = "movie";
		public static final String ALBUM = "album";
		public static final String SHOW = "show";
	}

	private static Map<String, EntertainPrototype> prototypes = new HashMap<String, EntertainPrototype>();

	static {
		prototypes.put(ModelType.MOVIE, new Movie());
		prototypes.put(ModelType.ALBUM, new Album());
		prototypes.put(ModelType.SHOW, new Show());
	}
	
	// factory method to get object 
	
	public static EntertainPrototype getInstance (String str) throws CloneNotSupportedException{
		
		return (EntertainPrototype)prototypes.get(str).clone();
		
	}
}
