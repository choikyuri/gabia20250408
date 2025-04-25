package chapter05;

import javax.swing.JOptionPane;

public class FuncTest_03 {

	// Display1(static), Display2

	public static void Display1(String[] A) {
		String res = "";

		// A 배열변수방의 요소를 모두 res에 저장하는 method
		for (int i = 0; i < A.length; i++) {
			res += A[i] + " ";
		} // method

		System.out.println(res);
		JOptionPane.showMessageDialog(null, "배열의 요소\n" + res);
	}

	public void Display2(String[] A) {
		String res = "";

		// A 배열변수방의 요소를 모두 res에 저장하는 method
		for (int i = 0; i < A.length; i++) {
			res += A[i] + " ";
		} // method

		System.out.println(res);
		JOptionPane.showMessageDialog(null, "배열의 요소\n" + res);
	}

	public static void main(String[] args) {

		String str[] = { "Java", "Oracle", "JSP", "HTML5", "CSS", "SpringBoot" };

		// DATA 영역에서 호출(static 메서드)
		Display1(str);

		System.out.println();
		// stack에서 호출되는 메서드
		FuncTest_03 obj = new FuncTest_03();
		obj.Display2(str);

	}

}

//DATA 영역(Static Area)-> 프로그램이 실행될때 미리 할당되는 메모리(즉 JVM에 미리 로드됨)
// -> static 메서드는 클래스에 소속되기 때문에 객체 없이도 사용
//Heap 영역(동적 메모리) -> new 등을 통해서 생성된 객체나 배열
//Stack 영역(메서드 호출/종료) -> 지역변수, 매개변수, 함수
