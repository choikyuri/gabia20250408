package chapter02;

import java.util.Scanner;

public class Condition_15 {

	public static void main(String[] args) {
		
		// 삼항 연산
		int a = 10;
		int b = 15;
		boolean result;
		
		result=a>=b ? true : false;
		System.out.println(result);
		
		int n1=10;
		int n2=20;
		char result2;
		
		result2=(++n1 == n2)? 'Y':'N';
		System.out.println(result2);
		
		Scanner scan=new Scanner(System.in);
		System.out.print("나이를 입력하세요: ");
		int age=scan.nextInt();
		
		String result3;
		result3= age >= 19 ? "성인" : "미성년";
		System.out.println(result3);
		
		int fatherAge=38;
		int motherAge=45;
		
		String ch= (fatherAge > motherAge) ? "연상":"연하";
		System.out.println(ch);

	}

}
