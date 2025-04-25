package chapter02;

public class IncreTest_07 {

	public static void main(String[] args) {
		
		int x=10;
		int y=10;
		int z;
		
		x++; //10 -> 11
		++x; //12
		System.out.println("x="+x);
		System.out.println("-----------");
		
		//y후위연산 후 전위연산
		y--; //10 -> 9
		--y; //8
		System.out.println("y="+y);
		System.out.println("-----------");
		
		//x후위연산후 z에 대입
		z=x++;
		System.out.println("z="+z); //12
		System.out.println("x="+x); //13
		System.out.println("-----------");
		
		//x전위연산후 z에 대입
		z=++x;
		System.out.println("z="+z); //14
		System.out.println("x="+x); //14
		System.out.println("-----------");
		
		//x전위연산 + y후위연산의 결과값을 z에 대입
		z=++x + y++; //15+8
		System.out.println("z="+z);//23
		System.out.println("x="+x);//15
		System.out.println("y="+y);//9
		
		
	}

}
