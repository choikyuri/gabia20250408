package chapter08;

public class B {

	// 같은 패키지에서는 public
	public void method() {
		A_03 a = new A_03();
		a.field = "value";
		a.method();

	}

	public static void main(String[] args) {
		B b = new B();
		b.method();
	}

}
