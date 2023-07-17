package singraul.stream;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GetWordAndDigitCount {

	public static void main(String[] args) {
		String sbiScript = "Buy 1200 shares of SBI Bank at 575 target 580 stop loss 568";
		String[] splitStr = sbiScript.split("\\s+");
		int totalWordCount = (int) Arrays.asList(splitStr).stream().count();
		System.out.println("Total Word Count " + totalWordCount);

		
		CheckNumeric checkNumeric = (String str) -> {
			String regexForDigt = "[0-9]+";
			Pattern p =Pattern.compile(regexForDigt);
			Matcher m = p.matcher(str);
			if (m.matches())
				return true;
			return false;
		};
		
		List<String> onlyDigitList = Arrays.stream(splitStr).filter(x -> checkNumeric.isNumeric(x))
				.collect(Collectors.toList());
		
		System.out.println("Only Digit Count " + onlyDigitList.size());
		
		int onlyWordCount = (int) Arrays.stream(splitStr).filter(x -> !checkNumeric.isNumeric(x))
				.count();
		
		System.out.println("Only Word Count " + onlyWordCount);
	}

}

@FunctionalInterface
interface CheckNumeric {
	boolean isNumeric(String str);
}
