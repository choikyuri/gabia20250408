package chapter01;

public class BinaryTest_03 {
	
	public static void main(String[] args) {
		// 자료형:정수 
		// byte -> 1byte 2의 8승(-128 ~ 127) 
		// short -> 2byte 2의 16승(-32,768 ~ 32,767)
		// int -> 4byte 2의 32승, 가장 일반적(약 42억) 
		// long -> 8byte 2의 64승, 큰 숫자가 필요할때(약 18경)
		
		byte myByte=100;
		short myShort=20000;
		int myInt=1000000000;
		long myLong=900000000000000L;
		
		
		System.out.println("byte: " + myByte);
		System.out.println("short: " + myShort);
		System.out.println("int: " + myInt);
		System.out.println("long: " + myLong);
		
		
		int result=myByte + myShort;
		System.out.println("두수의 합: "+ result);
		System.out.println("두수의 합: "+ (myByte+myShort));
		
	}

}
