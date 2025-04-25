package chapter05;

public class MethodTest_13 {

	public static void main(String[] args) {

		int sum = add(5, 7);
		double sumDouble = add(3.5, 7.2);

		System.out.println("합계(int): " + sum);
		System.out.println("합계(double): " + sumDouble);
	}

	// Overload
	// 정수의 합
	public static int add(int a, int b) {
		int result = a + b;
		return result;
	}

	// 실수의 합
	public static double add(double a, double b) {
		return a + b;
	}

}
