package chapter02;

public class RelaTest_08 {

	public static void main(String[] args) {
		 
		char a,b;
		a='A'; //65
		b='B'; //66
		
		boolean AL=a>b;
		System.out.println(AL);
		
		System.out.println("a>b: "+(a>b));//F
		System.out.println("a<b: "+(a<b));//T
		System.out.println("a==b: "+(a==b));//F
		System.out.println("a!=b: "+(a!=b));//T
		System.out.println("a<=b: "+(a<=b));//T
		System.out.println("a>=b: "+(a>=b));//F
		

	}

}
