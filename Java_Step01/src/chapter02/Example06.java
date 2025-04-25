package chapter02;

import java.util.Scanner;

public class Example06 {

	public static void main(String[] args) {
		/*Scanner 을 사용하여 
		두 개의 불리언(boolean) 변수 isSunny와 isWarm을 입력받아, 
		날씨가 화창하면서 따뜻한지 여부를 출력하는 프로그램을 작성하세요.
		(날씨가 화창하면서 따뜻한지에 대한 변수 isNiceWeather 으로 작성하세요.)*/
		
		Scanner scan=new Scanner(System.in);
		
		System.out.print("날씨가 화창한가요? (true/false) : ");
		boolean isSunny=scan.nextBoolean(); //true
		
		System.out.print("날씨가 따뜻한가요? (true/false) : "); 
		boolean isWarm=scan.nextBoolean(); //true
		
		//판단(논리연산)
		boolean isNiceWeather= isSunny && isWarm;
		System.out.print("날씨가 화창하면서 따뜻한가요? " + isNiceWeather);

	}

}
