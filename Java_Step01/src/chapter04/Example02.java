package chapter04;

public class Example02 {

	public static void main(String[] args) {
		// 배열에서 최대값을 찾아서 출력

		int max = 0;
		int array[] = { 1, 6, 9, 2, 35, 178, 234, 4, 5, 11 };

		// for 문에서 if문으로 숫자의 크기를 비교해서
		// max방의 0을 배열방의 값으로 변경 max=array[i];
		for (int i = 0; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			} // if
		} // for
		System.out.println("최대값: " + max);

		System.out.println();
		for (int num : array) {
			if (max < num) {
				max = num;
			} // if
		} // for

		System.out.println("최대값: " + max);
	}

}
