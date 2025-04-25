package chapter02;

import java.util.Scanner;

public class Example08 {

	public static void main(String[] args) {
		// 두 개의 숫자를 입력 받아서 첫 번째(num1) 숫자가 두 번째(num2) 숫자보다
		// 큰지 여부를 출력하는 프로그램을 작성하세요.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자를 입력하세요 : ");
		int num1 = scan.nextInt();
		
		System.out.print("두 번째 숫자를 입력하세요 : ");
		int num2 = scan.nextInt();
		
		//관계 연산자
		boolean isGreaterThen=num1>num2; //true or false
		System.out.print("첫번째 숫자가 두번째 숫자보다 큰가요? " + isGreaterThen);
		System.out.println();
		//삼항 연산자
		String greater=isGreaterThen ? "첫번째 숫자가 큼":"두번째 숫자가 큼";
		System.out.println(greater);

	}

}
