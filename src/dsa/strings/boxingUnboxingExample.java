package dsa.strings;

public class boxingUnboxingExample {

	public static void main(String[] args) {
		int a = 10;
		Integer obj = Integer.valueOf(a);//boxing
		
		Integer obj1 = a; //autoboxing
		
		int x = obj.intValue();//unboxing
		
		int y = obj1;
	}

}
