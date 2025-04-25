package chapter05;

public class FunTest_Overload_08 {

	// 멤버변수=필드=속성

	// 생성자(디폴트 생략)

	// 메서드
	public void getResult(int n) {
		System.out.println(n + "은(는) int 입니다.");
	}

	public void getResult(char n) {
		System.out.println(n + "은(는) char 입니다.");
	}

	public void getResult(String n) {
		System.out.println(n + "은(는) String 입니다.");
	}

	public void getResult(int n, String str) {
		System.out.println(n + "은(는) int 이고, " + str + "은(는) String 입니다.");
	}
}
