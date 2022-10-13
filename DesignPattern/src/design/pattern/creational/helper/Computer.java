package design.pattern.creational.helper;
/**
 * https://www.journaldev.com/1425/builder-design-pattern-in-java
 * 
https://howtodoinjava.com/design-patterns/creational/builder-pattern-in-java/
 *
 */
public class Computer {
     // required parameter 
	private String HDD ;
	private String RAM ;
	private String CPU ;
	// Optional Parameter 
	private boolean flagGraphicCardEnabled ;
	private boolean flagBlueToothEnabled ;
	private String SSD ;
	
	public Computer(ComputerBuilder computerBuilder) {
		this.HDD = computerBuilder.HDD;
		this.RAM = computerBuilder.RAM;
		this.CPU = computerBuilder.CPU;
		this.flagBlueToothEnabled =computerBuilder.flagBlueToothEnabled;
		this.flagGraphicCardEnabled =computerBuilder.flagGraphicCardEnabled;
		this.SSD =computerBuilder.SSD;

	}
	// only getter method
	public String getHDD() {
		return HDD;
	}
	public String getRAM() {
		return RAM;
	}
	public String getCPU() {
		return CPU;
	}
	public boolean isFlagGraphicCardEnabled() {
		return flagGraphicCardEnabled;
	}
	public boolean isFlagBlueToothEnabled() {
		return flagBlueToothEnabled;
	}
	public String getSSD() {
		return SSD;
	}
	 

	
	
	@Override
	public String toString() {
		return "Computer [HDD=" + HDD + ", RAM=" + RAM + ", CPU=" + CPU + ", flagGraphicCardEnabled="
				+ flagGraphicCardEnabled + ", flagBlueToothEnabled=" + flagBlueToothEnabled + ", SSD=" + SSD + "]";
	}




	public static class ComputerBuilder {
		  // required parameter 
		private String HDD ;
		private String RAM ;
		private String CPU ;
		// Optional Parameter 
		private boolean flagGraphicCardEnabled ;
		private boolean flagBlueToothEnabled ;
		private String SSD ;
		
		// constructor for required fields
		public ComputerBuilder(String hDD, String rAM, String cPU) {
			super();
			this.HDD = hDD;
			this.RAM = rAM;
			this.CPU = cPU;
		}

		public ComputerBuilder setFlagGraphicCardEnabled(boolean flagGraphicCardEnabled) {
			this.flagGraphicCardEnabled = flagGraphicCardEnabled;
			return this ;
		}

		public ComputerBuilder setFlagBlueToothEnabled(boolean flagBlueToothEnabled) {
			this.flagBlueToothEnabled = flagBlueToothEnabled;
			return this ;
		}

		public ComputerBuilder setSSD(String sSD) {
			this.SSD = sSD;
			return this ;
		}
		// builder method 
		public Computer build () {
			
			return new Computer(this);
		}
		

	}
	
	
}
