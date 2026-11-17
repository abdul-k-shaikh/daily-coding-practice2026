package java8;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MoveZerosToEnd {
//	Array a[]={3,5,0,2,0,1,0} o/p:{3,5,2,1,0,0,0} 
	public static void main(String[] args) {
		int a[] = { 3, 5, 0, 2, 0, 1, 0 };
		int[] array = IntStream.concat(Arrays.stream(a).filter(n -> n != 0), Arrays.stream(a).filter(n -> n == 0))
				.toArray();
		System.out.println("moved zeros at the end :" + Arrays.toString(array));
		
		//Or
		
	}

}
