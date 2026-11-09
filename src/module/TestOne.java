package module;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestOne {

	public static void main(String[] args) {

//		List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);
//		numbers.stream().filter(n->n%2==0).forEach(System.out::println);
//		
//		List<String>names = Arrays.asList("java", "spring", "boot");
//		names.stream().map(String::toUpperCase).forEach(System.out::println);

		String str = "javaarticles";

		Character chr = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() > 1).map(e -> e.getKey()).findFirst()
				.orElse(null);
		System.out.println("First non repeating character is " + chr);

		// 1. Frquency of each character
		LinkedHashMap<Character, Long> collect = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println("occurences of each character :" + collect);

		List<String> listOfStrings = Arrays.asList("java", "python", "cpp", "golang", "ruby", "java");
		List<String> distinctElement = listOfStrings.stream().distinct().collect(Collectors.toList());
		System.out.println("Distinct element:" + distinctElement);

		String s = "Java";
		s = s.concat("Programming");
		System.out.println("concat example:" + s);
		// System.out.println("concat example:"+concat1);

		List<Integer> nums = Arrays.asList(12, 23, 34, 5, 60, 80, 100);
		Optional<Integer> SecondHighest = nums.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
		System.out.println("SecondHighest: " + SecondHighest);

		List<String> names = Arrays.asList("A", "B", "A", "C");
		Map<String, Long> frequency = names.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Count Frequency :" + frequency);

		List<Integer> nums1 = Arrays.asList(12, 23, 34, 5, 60, 60, 100);
		Set<Integer> set = new HashSet<Integer>();
		System.out.println("Unique elements are: ");
		nums1.stream().filter(n -> !set.add(n)).forEach(System.out::println);

		// 2. Remove duplicates using java 8 groupingBy
		List<Integer> duplicate = Arrays.asList(11, 11, 11, 23, 22, 24, 25);
		Integer dupli = duplicate.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() > 1).map(x -> x.getKey()).findFirst().orElse(null);
		System.out.println("dupli:" + dupli);

		// 3. Remove duplicates using set
		List<Integer> duplicate1 = Arrays.asList(11, 11, 11, 23, 22, 24, 25);
		Set<Integer> s1 = new HashSet<Integer>();
		List<Integer> collect2 = duplicate1.stream().filter(x -> !s1.add(x)).distinct().collect(Collectors.toList());
		System.out.println("duplicate ele using set:" + collect2);

		// 4. all repeating characters
		String str1 = "javaisjava";
		List<Character> allRepeatingChar = str1.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() > 1).map(x -> x.getKey()).collect(Collectors.toList());
		System.out.println("allRepeatingChar :" + allRepeatingChar);

		// 5. all non-repeating characters
		List<Character> alNonRepeatingChar = str1.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(x -> x.getValue() == 1).map(x -> x.getKey()).collect(Collectors.toList());
		System.out.println("alNonRepeatingChar :" + alNonRepeatingChar);

		// 6. character frequency program in Java 8
		Map<Character, Long> charFrequency = str1.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("charFrequency :" + charFrequency);

//		same questions for words instead of characters
		// 7. word count
		String sentance = "java is programming language and java is awesome";
		Map<String, Long> collect3 = Arrays.stream(sentance.split(" "))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("collect3 :" + collect3);

		// 8. all repeating words
		List<String> allRepeatingWords = Arrays.stream(sentance.split(" "))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(x -> x.getValue() > 1).map(x -> x.getKey()).collect(Collectors.toList());
		System.out.println("allRepeatingWords :" + allRepeatingWords);

		// 9. all non-repeating word
		List<String> allNonRepeatingWords = Arrays.stream(sentance.split(" "))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(x -> x.getValue() == 1).map(x -> x.getKey()).collect(Collectors.toList());
		System.out.println("allNonRepeatingWords :" + allNonRepeatingWords);

		// 10 char count from given sentence
		LinkedHashMap<String, Long> charCountFromWords = Arrays.stream(sentance.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println("charCountFromWords :" + charCountFromWords);
		
		//11. char count from given sentance removing ignoring whiteSpace
		Map<String, Long> charCountFromGivenWordsIgnoringSpace = Arrays.stream(sentance.replaceAll("\\s+", "").split(""))
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("charCountFromGivenWordsIgnoringSpace: "+ charCountFromGivenWordsIgnoringSpace);
		
		//12. 

	}

}
