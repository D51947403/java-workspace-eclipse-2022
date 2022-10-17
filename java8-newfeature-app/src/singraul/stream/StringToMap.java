package singraul.stream;
/**
 * https://www.geeksforgeeks.org/how-to-convert-a-stream-into-a-map-in-java/
 */
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class StringToMap {

	public static void main(String[] args) {
		String str="Devendra Kumar Singraul";
		
		Map<String, Integer> lengthMap=Arrays.stream(str.split(" ")).collect(
				Collectors.toMap(s -> s , s -> s.length()));
		System.out.println(lengthMap); 
	}

}
