package chapter05;

public class Example01 {

	/*
	 * 사각형의 넓이를 계산하는 메소드 calculateArea 를 오버로딩 하여 가로와 세로길이, 그리고 한 변의 길이를 받아서 계산할 수 있게
	 * 만들어보세요. 사각형 넓이 계산(직사각형) = 가로 x 세로(매개변수 2개) 가로 5, 세로 3 사각형 넓이 계산(정사각형) = 한 변의
	 * 길이 x 한 변의 길이(매개변수 1개) 한 변의 길이 4
	 */

	private double calculateArea(double a, double b) {
		return a * b;
	}

	private double calculateArea(double a) {
		double area = a * 4;
		return area;

	}

	public static void main(String[] args) {
		// 객체생성 하기
		Example01 rectangle = new Example01();
		double area1 = rectangle.calculateArea(5.0, 3.0);
		double area2 = rectangle.calculateArea(4.0);
		System.out.println("사각형의 넓이 (가로5, 세로 3): " + area1);
		System.out.println("정사각형의 넓이 (한 변의 길이4): " + area2);

	}

}
