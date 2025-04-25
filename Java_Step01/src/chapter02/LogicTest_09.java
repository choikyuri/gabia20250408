package chapter02;

public class LogicTest_09 {

	public static void main(String[] args) {
		// 논리연산 AND(&&),OR(||)
		
		char a,b;
		boolean c;
		
		a='A';
		b='B';
		//AND(&&)
		c= true && true;
		System.out.println(c);
		c= true && false;
		System.out.println(c);
		System.out.println("----------------");
		
		//OR(||)
		c= true || true;
		System.out.println(c);
		c= true || false;
		System.out.println(c);
		System.out.println("----------------");
		
		//&& ||
		c= (true||true) && false;
		System.out.println(c);
		c=  (true&&true) || false;
		System.out.println(c);
		System.out.println("----------------");
		
		//관계연산을 활용한 논리연산
		c=a<b && (a==b); // T && F => F
		System.out.println(c);
		c=a<b || (a==b); // T || F => T
		System.out.println(c);
		
		
		
		
		

	}

}
