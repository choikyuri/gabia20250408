package chapter01;

public class BinaryTest_02 {

	public static void main(String[] args) {
		// 변수선언 타입 -> 카멜: 첫자는 무조건 소문자 중간단어의 시작을 대문자
		// 변수선언 타입 -> 파스칼: 첫자는 무조건 대문자 나머지는 소문자
		
		//integer의 약자 int는 정수를 기억하는 변수방으로 선언
		int num=10; 
		int bNum=0B1000; //Binary 즉 2진수(0,1) 0B
		int oNum=010; //octal 즉 8진수(OCT)
		
		System.out.println("10진수: " + num);
		System.out.println("8진수: " + oNum);
		System.out.println("2진수: " + bNum);
		System.out.println("------------------------");
		
		int bNum2=0B10000;
		int hNum=0x10;//16진수(Hex) 
		
		System.out.println("2진수: "+bNum2);
		System.out.println("16진수: "+hNum);
		
		

	}

}
