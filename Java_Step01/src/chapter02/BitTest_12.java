package chapter02;

public class BitTest_12 {

	public static void main(String[] args) {
		
		int num1=5; //  0101
		int num2=10; // 1010
		
		//Bit연산 => OR(|) : 하나라도 1이면 1로 결과값 반환
		int result=num1 | num2;
		System.out.println(result);
		
		//Bit연산 => AND(&) : 모두 1이면 1로 결과값 반환
		result=num1 & num2;
		System.out.println(result);
		
		//Bit연산 => XOR(^) : 0과 1이여야만 1로 결과값 반환
		result=num1 ^ num2;
		System.out.println(result);

	}

}
