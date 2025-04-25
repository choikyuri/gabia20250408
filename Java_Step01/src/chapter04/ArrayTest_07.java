package chapter04;

public class ArrayTest_07 {

	public static void main(String[] args) {

		char[] alpa = new char[26];
		char ch = 'A'; // 65

		// for문 이용해서 초기화 하기
		/*
		 * for (int i = 0; i < alpa.length; i++) { alpa[i] = ch; ch++;
		 * System.out.print(alpa[i] + " "); }
		 */
		for (int i = 0; i < alpa.length; i++, ch++) {
			alpa[i] = ch;
			System.out.print(alpa[i] + " ");
		}

	}

}
