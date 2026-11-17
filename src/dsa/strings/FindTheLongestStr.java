package dsa.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FindTheLongestStr {

	public static void main(String[] args) {
		List<String> str = Arrays.asList("java", "go", "python");

		Optional<String> max = str.stream().max(Comparator.comparing(ele -> ele.length()));

		if (max.isPresent()) {
			System.out.println("Longest str: " + max.get());
		}
	}
}
