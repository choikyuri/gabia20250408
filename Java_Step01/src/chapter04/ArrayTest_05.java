package chapter04;

public class ArrayTest_05 {

	public static void main(String[] args) {

		double[] data = new double[5];
		int size = 0;

		// 대입연산
		data[0] = 10.0;
		size++; // size=size+1 -> 0
		data[1] = 20.0;
		size++; // 1
		data[2] = 30.0;
		size++; // 2

		double total = 1.0;

		System.out.println(size);// 3
		// System.out.println(data[3]);
		// System.out.println(data[4]);

		for (int i = 0; i < size; i++) { // data[0], data[1], data[2]
			System.out.println(data[i]);
			total *= data[i];
		}

		System.out.println("Total: " + total);

	}

}
