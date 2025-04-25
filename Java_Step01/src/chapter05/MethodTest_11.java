package chapter05;

public class MethodTest_11 {

	public static void main(String[] args) {

		String name = "최백설";
		greet(name); // 매개변수가 있는 메서드
	}

	// 메서드
	public static void greet(String irum) {
		System.out.println("Hello, " + irum + "~~");
	}

}
