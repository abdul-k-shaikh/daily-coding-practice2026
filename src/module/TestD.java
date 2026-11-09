package module;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestD {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(12, 23, 34, 5, 60, 80, 100);

		nums.stream().sorted(Comparator.reverseOrder()).limit(5).forEach(System.out::println);
		// OR
		List<Integer> collect = nums.stream().sorted(Comparator.reverseOrder()).limit(5).collect(Collectors.toList());
		System.out.println("top 5 elements:" + collect);

		int a[] = { 12, 23, 34, 5, 60, 80, 100 };
		List<Integer> top5UsingCollect = Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).limit(5)
				.collect(Collectors.toList());
		System.out.println("top5UsingCollect:" + top5UsingCollect);

		Arrays.stream(a).boxed().sorted(Comparator.naturalOrder()).limit(5).forEach(System.out::println);

		String input = "javaarticles";
//		LinkedHashMap<Character, Long> collect2 = input.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
//		System.out.println("character ocurrences:"+collect2);
//		
		Character ch = input.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() == 1).map(e -> e.getKey()).findFirst().orElse(null);
		System.out.println("first non-repeating character: " + ch);

		// Separate odd and even numbers
		List<Integer> listOfIntegers = Arrays.asList(2, 4, 8, 3, 5, 9);
		Map<Boolean, List<Integer>> oddEven = listOfIntegers.stream()
				.collect(Collectors.partitioningBy(i -> i % 2 == 0));
		System.out.println("oddEven:" + oddEven);

		List<Integer> al = Arrays.asList(32, 23, 43, 51, 20);
		List<Integer> collect2 = al.stream().sorted(Comparator.reverseOrder()).limit(5).collect(Collectors.toList());
		System.out.println("top most 5 elements :" + collect2);

		int arr[] = { 32, 23, 43, 51, 20 };
		System.out.println("Top 5 elements are:");
		Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).limit(5).forEach(System.out::println);

		List<Integer> list2 = Arrays.asList(5, 10, 40, 30, 25, 30);
		List<Integer> multipleOfFive = list2.stream().filter(n -> n % 5 == 0).collect(Collectors.toList());
		System.out.println("multipleOfFive: " + multipleOfFive);

		System.out.println("Merge 2 unsorted arrays into single sorted array");
		int arr1[] = { 32, 23, 43, 51, 20 };
		int arr2[] = { 22, 13, 42, 21, 30 };
		int[] mergedSortedArray = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().toArray();
		System.out.println("mergedSortedArray :"+ Arrays.toString(mergedSortedArray));
		
		int[] mergedSortedDistinctArray = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr1)).sorted().distinct().toArray();
		System.out.println("mergedSortedDistinctArray : "+ Arrays.toString(mergedSortedDistinctArray));
		

	}
}
