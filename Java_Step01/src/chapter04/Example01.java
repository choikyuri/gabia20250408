package chapter04;

public class Example01 {

	public static void main(String[] args) {
		// for문을 이용하여 다음 배열의 점수를 줄단위로 총점과 평균을 출력하시오.
		int[][] array = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };

		double avg = 0;
		int count = 0;
		int sum[] = new int[3];

		// for문을 이용 -> 각 행을 가져와서 / 각행의 열을 읽어서
		// sum에 누적하고(count++) 평균까지 구하여 출력

		for (int i = 0; i < array.length; i++) {// 각 행을 가져오기

			for (int j = 0; j < array[i].length; j++) {// 각 행의 열을 가져오기
				sum[i] += array[i][j];// {95,86]
				count++;// 2
			} // for

			System.out.println("각 행의 합: " + sum[i]);
			avg = sum[i] / (double) count;
			System.out.println("각 행의 평균: " + avg);
			System.out.println("--------------");
			count = 0;// 초기화

		} // for

	}

}
