package chapter05;

public class FunTest_Overload_main {

	public static void main(String[] args) {

		FunTest_Overload_08 obj = new FunTest_Overload_08();

		obj.getResult(5);
		obj.getResult('A');
		obj.getResult("목요일 입니다.");
		obj.getResult(4, "2025");

	}

}
