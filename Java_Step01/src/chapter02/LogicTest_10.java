package chapter02;

public class LogicTest_10 {

	public static void main(String[] args) {
		
		int num1=10;
		int i=2;
		
		boolean value=((i=i+2) < 10 && (num1=num1+2) < 10); //T && F
		System.out.println(i);//4
		System.out.println(num1);//12
		System.out.println(value);//F		
		System.out.println("--------------");

		value=((i=i+2) < 10 || (num1=num1+2) < 10); //T || F
		System.out.println(i);//6
		System.out.println(num1);//14
		System.out.println(value);//T		
	}

}
