package chapter01;

public class VarType_10 {

	public static void main(String[] args) {
		// 명시적으로 int 타입 선언
		int i=10;
		
		//var 키워드를 사용하여 값을 보고 타입을 자동으로 추론
		var n=5; //int로 추론됨
		var j=10.5; //double로 추론됨
		var str="Test Good"; //String로 추론됨

		System.out.println("i: "+i);
		System.out.println("n: "+n);
		System.out.println("j: "+j);
		System.out.println("str: "+str);
		
		//처음 정해진 타입으로 고정되므로 값 변경이 안됨
		var x=5; //int
		//x="Hello";
		
		
	}

}
