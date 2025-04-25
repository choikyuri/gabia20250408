package chapter04;

public class ArrayTest_01 {

	public static void main(String[] args) {

		int[] number = new int[5];

		// 권장
		int[] number2;
		number2 = new int[10];

		// 초기화
		// int[] number3=new int[] {1,2,3,4,5,6,7,8,9,10};
		int[] number3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int number4[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		for (int i = 0; i < number3.length; i++) {
			System.out.println(number3[i] = (i + 1));
		} // for

	}// m

}
