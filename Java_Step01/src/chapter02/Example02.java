package chapter02;

public class Example02 {

	public static void main(String[] args) {
		/*soldesk 과수원
		 * 배, 사과, 오렌지를 키우고 있는데 하루에 생산되는 양은 각각 5개, 7개, 5개 입니다.
		 * 과수원에서 하루에 생산되는 총 과일의 갯수를 출력하고,
		 * 시간당(24) 전체 과일의 평균 생산 갯수를 출력 하시오.
		 * (단, 평균값을 담는 데이터 타입은 float)로 정의한다.
		 */
		
		int pear=5;
		int apple=7;
		int orange=5;
		
		//#1
		System.out.println("하루에 생산되는 총 과일의 갯수: "+(pear+apple+orange)+"개");
		System.out.println("시간당 전체 과일의 평균 생산 갯수: "+((float)(pear+apple+orange)/24)+"개");
		
		//#2
		int fruitTotal=pear+apple+orange;
		System.out.println("하루에 생산되는 총 과일의 갯수: "+fruitTotal);
		float fruitAvg=fruitTotal/24f;
		System.out.println("시간당 전체 과일의 평균 생산 갯수: "+fruitAvg);
	}

}
