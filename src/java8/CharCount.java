package java8;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharCount {

	public static void main(String[] args) {
		String str = "javaarticles";
		Map<Character, Long> charCount = str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("charCount :"+charCount);
	}
}
