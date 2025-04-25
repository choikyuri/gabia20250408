package chapter02;

public class LogicTest_11 {

	public static void main(String[] args) {
		
		int num1=10;
		int num2=20;
		
		System.out.println("----------AND----------");
		boolean flag1=(num1>10)&&(num2>20);
		System.out.println("false && false : "+flag1);
		
		boolean flag2=(num1>10)&&(num2>0);
		System.out.println("false && true : "+flag2);
		
		boolean flag3=(num1>0)&&(num2>20);
		System.out.println("true && false : "+flag3);
		
		boolean flag4=(num1>0)&&(num2>0);
		System.out.println("true && true : "+flag4);
		
		System.out.println("----------OR----------");
		boolean flag5=(num1>10)||(num2>20);
		System.out.println("false && false : "+flag5);
		
		boolean flag6=(num1>10)||(num2>0);
		System.out.println("false && true : "+flag6);
		
		boolean flag7=(num1>0)||(num2>20);
		System.out.println("true && false : "+flag7);
		
		boolean flag8=(num1>0)||(num2>0);
		System.out.println("true && true : "+flag8);
		
		//num1과 num2가 같다 또는 같지 않다
		boolean flag9=(num1==num2);
		System.out.println(flag9);
		
		boolean flag10=!(num1>0);
		System.out.println(flag10);

	}

}
