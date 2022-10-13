package design.pattern.creational;

import design.pattern.creational.helper.Computer;
import design.pattern.creational.helper.ComputerBuilderDirector;

/**
 * https://www.journaldev.com/1425/builder-design-pattern-in-java
 * 
https://howtodoinjava.com/design-patterns/creational/builder-pattern-in-java/
 *
 */

public class BuilderDemo {

	public static void main(String[] args) {
    
		clientTest() ;
	//	clientTestWithDirector();
     
	}

	// using builder director class 
	public static void clientTestWithDirector() {
		  System.out.println("Basic Computer : "+ComputerBuilderDirector.getBasicComputer());
		  System.out.println("Bluetooth Computer : "+ComputerBuilderDirector.getBlueThoothComputer());
		  System.out.println("Graphic Computer : "+ComputerBuilderDirector.getGraphiCardComputer());
		  System.out.println("SSD Computer : "+ComputerBuilderDirector.getSsdComputer());
		  System.out.println("SSD Bluetooth Computer : "+ComputerBuilderDirector.getBluetoohSsdComputer());
	}
	// without builder director
	public static void clientTest() {
	    Computer   basicCom = new Computer.ComputerBuilder("1 TB", "4 GB", "Intel i5").build();
	       
	       System.out.println("Basic Computer : "+basicCom);
	       
	       Computer  graphicCardComp=new Computer.ComputerBuilder("500 TB", "8 GB", "Intel i7")
	    		   .setFlagGraphicCardEnabled(true)
	    		   .build();
	       System.out.println("Graphic card enabled Computer : "+graphicCardComp);
	       
	       Computer  blueToothComp=new Computer.ComputerBuilder("2 TB", "4 GB", "Intel i5")
	    		   .setFlagBlueToothEnabled(true)
	    		   .build();
	       System.out.println("Blue tooth enabled Computer : "+blueToothComp);
	       
	       Computer  ssdComp=new Computer.ComputerBuilder("2 TB", "4 GB", "Intel i5")
	    		   .setSSD("256 MB")
	    		   .build();
	       System.out.println("SSD  Computer : "+ssdComp);
	}
}
