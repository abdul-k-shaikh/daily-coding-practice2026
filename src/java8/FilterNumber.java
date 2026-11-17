package java8;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/*Different string related functions in Springboot like 11,12,32,15 is in an array. 
How will you extract only numbers starting with 1 (the functon should return - 11,12,15). 
There is a straight forward function/option Springboot gives, whats that?*/

public class FilterNumber {

	public static void main(String[] args) {
		int a[] = {11,12,32,15};
//		Arrays.stream(a).map(String::valueOf).filter(n->n.startsWith("1")).
//		map(Integer::valueOf).collect((Supplier<R>) Collectors.toList());
		
		// or
		int[] array = Arrays.stream(a).filter(n->String.valueOf(n).startsWith("1")).toArray();
		System.out.println("startes with one :"+ Arrays.toString(array));
		
		//or 
		
		String arr[] = {"11","12","32","15"};
		Arrays.stream(arr).filter(s-> StringUtils.startsWithIgnoreCase(s, "1"))
		.toArray(String[]::new);
}
}