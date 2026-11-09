package module;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ProblemInP {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		IntStream.range(1, 1000).parallel().forEach(ele -> list.add(ele));

	}

}
// above program wont be compile due to we are using parallel stream and and we are adding element in list which is not 
// thread safe and it will arrayindex outof bound or race condition
