package chapter05;

import javax.swing.JOptionPane;

public class FuncTest_01 {

	// 메서드
	// int num1, int num2 -> 매개변수
	public static void sum(int num1, int num2) {
		int sum = num1 + num2;
		System.out.println("두 수의 합: " + sum);

	}

	public static void main(String[] args) {

		int a, b;

		a = Integer.parseInt(JOptionPane.showInputDialog("값1"));
		b = Integer.parseInt(JOptionPane.showInputDialog("값2"));

		/*
		 * int sum = a + b; System.out.println("두 수의 합: " + sum);
		 */

		sum(a, b); // 호출시 사용되는 매개변수 a와b는 실 값이 정의 되어 있으므로 실매개변수

	}
}
