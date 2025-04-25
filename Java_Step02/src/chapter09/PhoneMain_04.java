package chapter09;

public class PhoneMain_04 {

	public static void main(String[] args) {

		// Phone phone=new Phone(); //추상클래스이므로 객체 생성안됨

		SmartPhone smartPhone = new SmartPhone("김자바");

		System.out.println(smartPhone.owner + "님");
		smartPhone.turnOn();
		smartPhone.intersearch();
		smartPhone.turnOff();

	}

}
