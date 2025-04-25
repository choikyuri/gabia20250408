package chapter02;

import java.util.Scanner;

public class Example05 {

	public static void main(String[] args) {
		/*
		 1. Scanner를 이용하여 값을 입력받아서 양수인지 음수인지를 판별하는 프로그램
		 2. 삼항연산자를 사용하여 변수방에 저장된 수가 양수면 "양수입니다."
		    그렇지 않으면 "음수 또는 0입니다."라고 출력이 되어야함
		 */
		
		Scanner scan=new Scanner(System.in);
		System.out.print("숫자 입력: ");
		
		int number=scan.nextInt();
		//양수인지 여부를 판별하는 변수방 isPositive
		boolean isPositive=number>0;
		
		//삼항연산
		String result=isPositive ? "양수입니다." : "음수 또는 0입니다.";
		System.out.println(result);
		System.out.println("------------------------");
		
		int number2=-5;
		String result2=number2 > 0 ? "양수입니다." : "음수 또는 0입니다.";
		System.out.println(result2);

	}

}
