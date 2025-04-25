package chapter04;

import javax.swing.JOptionPane;

public class ArrayTest_06 {

	public static void main(String[] args) {

		String str[] = { "홍길동", "김유신", "장길산", "이순신" };
		String result = "";

		for (int i = 0; i < str.length; i++) {
			result += str[i] + "\n";
		} // for

		System.out.println(result);
		JOptionPane.showMessageDialog(null, "[영웅들]\n" + result);
	}

}
