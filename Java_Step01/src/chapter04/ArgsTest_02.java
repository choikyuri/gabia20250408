package chapter04;

public class ArgsTest_02 {

	public static void main(String[] args) {
		// 배열의 선언
		int a[] = new int[5];

		int[] b;// fixed length
		// .........
		b = new int[50];

		args = new String[2];
		args[0] = "10"; // [0]첨자의 요소로 10
		args[1] = "20";

		String sum = args[0] + args[1];
		System.out.println("문자열의 병합: " + sum);

		int aVal;
		int bVal;

		if (args.length == 2) {
			aVal = Integer.parseInt(args[0]); // "10"
			bVal = Integer.parseInt(args[1]); // "20"
		} else {
			aVal = 0;
			bVal = 0;
		}

		System.out.println("------------------");
		int Total = aVal + bVal;
		System.out.println("산술연산: " + Total);

	}// main

}
