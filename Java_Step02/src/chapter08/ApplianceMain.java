package chapter08;

public class ApplianceMain {

	public static void main(String[] args) {

		Appliance_05 a1 = new Washer("LG");
		Appliance_05 a2 = new TV("Samsung");
		// ERROR -> TV tv = new Appliance("LG");

		a1.turnOn();
		a2.turnOn();
		System.out.println();

		Appliance_05[] list = new Appliance_05[3];
		list[0] = new Washer("LG");
		list[1] = new TV("Samsung");
		list[2] = new Washer("Daewoo");

		for (Appliance_05 a : list) {
			a.turnOn();
		}

	}

}
