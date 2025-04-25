package chapter02;

import java.util.Scanner;

public class Example03 {

	public static void main(String[] args) {
		// #1
		// 삼항연산자를 이용하여 score1이 60 보다 크거나 같으면 합격
		// 그렇지 않으면 불합격으로 반환 하시오.
		// 조건?합격:불합격
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("score: ");
		int score=scan.nextInt(); //61
		String pass;
		pass=score >= 60 ? "합격" : "불합격";
		System.err.println(pass+ " 입니다");
		System.out.println("-----------------------");
			
		// #2
		// 삼항연산자를 이용하여 score2가 90보다 크면 'A'이고
		// score2가 80보다 크면 'B' 그 이하는 모두 'C'로 간주한다.
		
		System.out.print("score: ");
		int score2=scan.nextInt();//87
		
		char grade= score2 > 90 ? 'A':((score2 > 80)?'B':'C');
		System.out.println("학점: "+ grade);
	}

}
