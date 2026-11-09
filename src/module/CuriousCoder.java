package module;

import java.util.ArrayList;
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
import java.util.stream.IntStream;

public class CuriousCoder {

	public static void main(String[] args) {
		// 1. Second Highest Number in a list
		List<Integer> al = Arrays.asList(1, 0, 1, 56, 239, 9, 0, 100, 234, 678);
		System.out.println("Second Highest Number in a list :"
				+ al.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());

		// 2. Top 3 numbers
		al.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);

		// 3. Max number using Reduce
		System.out.println("Max number using reduce: " + al.stream().reduce(Integer.MIN_VALUE, Integer::max));

		// 4. Duplicates elements
		Set<Integer> hs = new HashSet<Integer>();

		List<Integer> duplicates = al.stream().filter(n -> !hs.add(n)).collect(Collectors.toList());
		System.out.println("duplicates are : " + duplicates);

		Map<Boolean, List<Integer>> oddEven = al.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
		System.out.println("Even number :" + oddEven.get(true));
		System.out.println("Even number :" + oddEven.get(false));

		// 5. Common elements from 2 list
		List<Integer> list1 = Arrays.asList(0, 56, 239, 9, 0, 100, 239, 678);
		List<Integer> list2 = Arrays.asList(5, 56, 240, 9, 7, 100, 239, 700);
		List<Integer> commonElements = list1.stream().filter(list2::contains).collect(Collectors.toList());
		System.out.println("commonElements : " + commonElements);

		// 6. remove duplicates and sort them in descending order
		List<Integer> uniqueAndDescending = al.stream().sorted(Comparator.reverseOrder()).distinct()
				.collect(Collectors.toList());
		System.out.println("remove duplicates and sort them in descending order :" + uniqueAndDescending);

		// or
		List<Integer> uniqueAndDescending1 = al.stream().distinct().sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println("remove duplicates and sort them in descending order :" + uniqueAndDescending1);

		// 7. find all the odd numbers and return their squares
		List<Integer> oddSquareList = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> oddSquareListAns = oddSquareList.stream().filter(x -> x % 2 != 0).map(x -> x * x)
				.collect(Collectors.toList());
		System.out.println("oddSquareListAns :" + oddSquareListAns);

		// 8. Get 2nd and 3rd elements from the list and return in a list
		List<Integer> secondthird = Arrays.asList(10, 20, 30, 40, 50);
		List<Integer> secondthirdAns = secondthird.stream().sorted(Comparator.reverseOrder()).skip(1).limit(2)
				.collect(Collectors.toList());
		System.out.println("secondthirdAns :" + secondthirdAns);

		// 9. given list of integers devide numbers into even and odd
		List<Integer> oddEvenSeparate = Arrays.asList(1, 2, 3, 4, 5);
		Map<Boolean, List<Integer>> oddEvenSeparateAns = oddEvenSeparate.stream()
				.collect(Collectors.partitioningBy(i -> i % 2 == 0));
		System.out.println("Even number " + oddEvenSeparateAns.get(true));
		System.out.println("Odd number " + oddEvenSeparateAns.get(false));

		// 10. list of string, Find the longest string in a list
		List<String> longestString = Arrays.asList("Java", "SpringBoot", "API");
		Optional<String> longestStringAns = longestString.stream().max(Comparator.comparing(ele -> ele.length()));
		if (longestStringAns.isPresent()) {
			System.out.println("longestStringAns :" + longestStringAns.get());
		}

		// 11. From the list of employess , find the first emp whose salary is greater
		// than 50000
		List<Employee> employees = new ArrayList<>(
				Arrays.asList(new Employee("Abhishek", "IT", 50000), new Employee("Ankit", "IT", 50000),
						new Employee("Rahul", "IT", 70000), new Employee("Rahul", "HR", 40000),
						new Employee("Tina", "HR", 45000), new Employee("Esha", "Finance", 60000),
						new Employee("Naman", "Finance", 55000), new Employee("Sachit", "IT", 80000),
						new Employee("Push", "Marketing", 50000), new Employee("Sumit", "Marketing", 52000)));

		Optional<Employee> first = employees.stream().filter(emp -> emp.getSalary() > 50000).findFirst();
		if (first.isPresent()) {
			System.out.println(" first emp whose salary is greater :" + first.get());
		}

		// 12. Find top paid employee
		List<Employee> collect = employees.stream().sorted(Comparator.comparingInt(emp -> -1 * emp.getSalary()))
				.limit(2).collect(Collectors.toList());
		System.out.println("highest paid employee :" + collect);

		// 13. from a list of employees, sort employees by salary, then name
		List<Employee> collect2 = employees.stream().sorted((emp1, emp2) -> {
			if (emp1.getSalary() > emp2.getSalary()) {
				return 1;
			} else if (emp1.getSalary() < emp2.getSalary()) {
				return -1;
			} else {
				return emp1.getName().compareTo(emp2.getName());
			}
		}).collect(Collectors.toList());
		System.out.println("sort employees by salary, then name :" + collect2);

		// 14. find the frequencey of integer from list of integer
		List<Integer> freList = Arrays.asList(3, 2, 3, 4, 4, 1, 2, 1, 1, 1, 5, 6, 5);
		Map<Integer, Long> collect3 = freList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Frequency fo elements : " + collect3);

		// 15. Count how many employees are present in each dept
		Map<String, Long> collect4 = employees.stream()
				.collect(Collectors.groupingBy(ele -> ele.getDepartment(), Collectors.counting()));
		System.out.println("dept and its emp count " + collect4);

		// 16. find avg salary of employees in each dept
		Map<String, Double> collect5 = employees.stream().collect(
				Collectors.groupingBy(emp -> emp.getDepartment(), Collectors.averagingInt(em -> em.getSalary())));
		System.out.println(" avg salary of employees in each dept :" + collect5);

		// 17. find the highest paid employee from each dept
		Map<String, Optional<Employee>> collect6 = employees.stream().collect(Collectors.groupingBy(
				emp -> emp.getDepartment(), Collectors.maxBy(Comparator.comparingInt(em -> em.getSalary()))));
		System.out.println("Highest paid employee from each dept :" + collect6);

		// 18. given list of employees, convert the list into a comma-separate string of
		// employee names
		String collect7 = employees.stream().map(emp -> emp.getName()).collect(Collectors.joining(","));
		System.out.println("converted the list into a comma-separate string of employee names :" + collect7);

		// 19. find common elements bw 2 lists
		List<Integer> listOne = Arrays.asList(1, 2, 3, 4);
		List<Integer> listTwo = Arrays.asList(3, 4, 5, 6);

		List<Integer> commonElementBw2List = listOne.stream().filter(listTwo::contains).collect(Collectors.toList());
		System.out.println("commonElementBw2List :" + commonElementBw2List);
		// OR
		List<Integer> collect8 = listOne.stream().filter(e -> listTwo.contains(e)).collect(Collectors.toList());
		System.out.println("commonElementBw2List :" + collect8);

		// 20 . find common elements bw 2 lists using set
		Set<Integer> set = new HashSet<Integer>(listOne);
		List<Integer> collect9 = listTwo.stream().filter(ele -> set.contains(ele)).collect(Collectors.toList());
		System.out.println("commonElementBw2List :" + collect9);

		// 21. we have list of list, convert it into a single list with all the
		// elements. Remove duplicates if any
		List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3, 4), Arrays.asList(3, 4, 5, 6),
				Arrays.asList(7, 8, 1, 2), Arrays.asList(9, 10, 5, 6), Arrays.asList(11, 12, 7, 8));

		List<Integer> collect10 = listOfLists.stream().flatMap(innerList -> innerList.stream()).distinct()
				.collect(Collectors.toList());
		System.out.println("we have list of list, convert it into a single list :" + collect10);
		
		//22. given list of employees, Print all employee names. Their order doesnt matter but the operation should be very fast
		employees.parallelStream().map(name->name.getName()).forEach(System.out::println);
		//OR
		employees.parallelStream().map(name->name.getName()).forEach(name->System.out.println(name));
		
		//23. from the list of employess, compute total combined salary of all the employees, Operations should be very fast
		Integer reduce = employees.parallelStream().map(e->e.getSalary())
				.reduce(0,(a,b) -> a+b);
				
		System.out.println("combined slaray "+ reduce);
		
		//24. 
		int[] prices = {12, 7, 18, 5, 10};
		int target = 17;
		//one way
		IntStream.range(0, prices.length)
        .forEach(i -> {
            IntStream.range(i + 1, prices.length)
                     .filter(j -> prices[i] + prices[j] == target)
                     .forEach(j -> System.out.println("[" + i + "," + j + "]"));
        });
		
		//2nd way
//		IntStream.range(0, prices.length)
//        .boxed()
//        .flatMap(i -> IntStream.range(i + 1, prices.length)
//                .filter(j -> prices[i] + prices[j] == target)
//                .mapToObj(j -> new int[]{i, j})
//        .findFirst()
//        .ifPresent(arr -> System.out.println(Arrays.toString(arr)));
		
		//24. sum only even numbers in a list 
		List<Integer> sumEven = Arrays.asList(10, 20, 30, 40, 50);
		int sumEvenAns = sumEven.stream().filter(n->n%2==0).mapToInt(Integer::intValue).sum();
		System.out.println("sumEven :"+ sumEvenAns);
		
		//  OR
		Integer sumEvenAns2 = sumEven.stream().filter(n->n%2==0).reduce(0,Integer::sum);
		System.out.println("sumEven2 :"+ sumEvenAns2);
		
		//25. Reverse a string
		String str= "java";
		StringBuilder rev = new StringBuilder();
		for(int i=str.length()-1; i>=0; i--) {
			rev = rev.append(str.charAt(i));
		}
		System.out.println("reve str:"+ rev);
		
		//other ways
		// Simple
		new StringBuilder(str).reverse().toString();

		// Java 8
//		IntStream.range(0, str.length())
//		         .mapToObj(i -> String.valueOf(str.charAt(str.length()-1-i)))
//		         .collect(Collectors.joining());
		
		//26 Write a program to compress a string (aaayyycccvvvbbaa → a3y3c3v3b2a2).
		String str1 ="aaayyycccvvvbbaa";
		LinkedHashMap<Character, Long> collect11 = str1.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println("not commpressed but its cont :"+ collect11);
		
		//25. Sort employee by name
		List<Employee> sortedEmpByName = employees.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
		System.out.println("sortedEmpByName :"+ sortedEmpByName);
		
		//26. sort employee by salary
		List<Employee> sortedEmpBySalary = employees.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
		System.out.println("sortedEmpBySalary :"+sortedEmpBySalary);
		
		// 27. Sort by Salary then Name
		 List<Employee> sortedByNameAndSal = employees.stream().sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName)).collect(Collectors.toList());
		System.out.println("sortedByNameAndSal :"+ sortedByNameAndSal);
		
		//28. Remove duplicates from a list using streams.
		List<Integer> removeDuplicates = Arrays.asList(1, 0, 1, 56, 239, 9, 0, 100, 234, 678);
		List<Integer> collect12 = removeDuplicates.stream().distinct().collect(Collectors.toList());
		System.out.println("removedDuplicates: "+ collect12);
		
		//29 Find duplicate elements in a list using streams.
		List<Integer> collect13 = removeDuplicates.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream().filter(x->x.getValue()>1).map(x->x.getKey()).collect(Collectors.toList());
		System.out.println("Find duplicates :"+ collect13);
		
		//30. Remove duplicates from a list using streams. using set
		Set<Integer>seen = new HashSet<Integer>();
		List<Integer> removeDuplicatesUsingSet = removeDuplicates.stream().filter(n->seen.add(n)).collect(Collectors.toList());
		System.out.println("removeDuplicatesUsingSet: "+ removeDuplicatesUsingSet);
		
		//31 Find duplicate elements in a list using streams.
		Set<Integer>seen1 = new HashSet<Integer>();
		 List<Integer> collect14 = removeDuplicates.stream().filter(n->!seen1.add(n)).collect(Collectors.toList());
		 System.out.println("FindDuplicatesUsingSet: "+ collect14);
		 
	    //sum numbers from 1to 10 using stream
		System.out.println("Sum 1to 10 :"+  IntStream.range(1, 3).sum());
	}
}
