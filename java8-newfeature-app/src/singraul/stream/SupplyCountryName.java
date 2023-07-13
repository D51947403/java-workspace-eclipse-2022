package singraul.stream;

import java.util.Arrays;
import java.util.function.Supplier;

public class SupplyCountryName {

	public static void main(String[] args) {
		Supplier<?> contry = () -> {
			return Arrays.asList("India" ,"Pakistan","Nepal","Bhutan","China");
		};
		System.out.println(contry.get());

	}
	


}
