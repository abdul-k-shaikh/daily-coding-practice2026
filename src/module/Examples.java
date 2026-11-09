package module;

// method overloading example
public class Examples {
	void m1(int a) {
		System.out.println("int m1 method");
	}

	void m1(int a, int b) {
		System.out.println("int int m1 method");
	}

	void m1(char ch) {
		System.out.println("char m1 method");
	}

	public static void main(String[] args) {
		Examples ex = new Examples();
		ex.m1(10);
		ex.m1(1, 2);
		ex.m1('a');
	}
}
