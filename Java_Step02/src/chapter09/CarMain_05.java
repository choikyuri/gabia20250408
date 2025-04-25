package chapter09;

public class CarMain_05 {

	public static void main(String[] args) {
		// method(new ManualCar());
		// System.out.println();
		// method(new AICar());

		System.out.println("-------------자율주행-----------");
		Car mycar = new AICar();
		mycar.run();
		System.out.println("-------사람이 운전하는 자동차--------");
		Car hiscar = new ManualCar();
		hiscar.run();

	}
	/*
	 * public static void method(Car car) { car.drive(); car.stop(); }
	 */

}
