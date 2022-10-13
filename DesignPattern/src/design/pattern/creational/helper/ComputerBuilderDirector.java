package design.pattern.creational.helper;

public class ComputerBuilderDirector {

	public static Computer getBasicComputer() {

		return new Computer.ComputerBuilder("1 TB", "4 GB", "Intel i5").build();
	}

	public static Computer getBlueThoothComputer() {

		return new Computer.ComputerBuilder("1 TB", "4 GB", "Intel i3")
				.setFlagBlueToothEnabled(true)
				.build();
	}

	public static Computer getGraphiCardComputer() {

		return new Computer.ComputerBuilder("1 TB", "2 GB", "Intel i5")
				.setFlagGraphicCardEnabled(true)
				.build();
	}

	public static Computer getSsdComputer() {

		return new Computer.ComputerBuilder("1 TB", "4 GB", "Intel i5")
				.setSSD("500 MB")
				.build();
	}

	public static Computer getBluetoohSsdComputer() {

		return new Computer.ComputerBuilder("500 GB", "4 GB", "Intel i5")
				.setFlagBlueToothEnabled(true)
				.setSSD("256 GB")
				.build();
	}
	
	public static Computer getFullyFeaturedCompuert() {
		return new Computer.ComputerBuilder("512 GB", "16 GB", "Intel i5")
				.setFlagBlueToothEnabled(true)
				.setFlagGraphicCardEnabled(true)
				.setSSD("512 GB")
				.build();
	}
}
