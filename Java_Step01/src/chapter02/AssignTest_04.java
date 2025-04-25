package chapter02;

public class AssignTest_04 {

	public static void main(String[] args) {
		
		int num1=10;
		int num2=20;
		
		//음수기호만 붙여서 출력
		System.err.println(-num2);
		System.out.println(+num1);
		System.out.println(num2);
		
		//대입연산을 이용하여 음수로 변환
		num2=-num2; //음수로 다시 선언해서 저장
		System.out.println(num2);
		
	}

}
