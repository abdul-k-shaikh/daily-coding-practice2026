package module;

import java.util.function.Predicate;

public class EmptyTest {

	public static void main(String[] args) {
		Predicate<Integer> p = n -> n > 10;
		System.out.println(p.test(11));
	}
}
