package chapter08;

public class CellPhone_07 {

	String model;
	String color;

	void powerOn() {
		System.out.println("전원을 켭니다.");
	}

	void powerOff() {
		System.out.println("전원을 끕니다.");
	}

	void bell() {
		System.out.println("벨이 울립니다.");
	}

	void sendVoice(String message) {
		System.out.println("자기자신 : " + message);
	}

	void receiveVoice(String message) {
		System.out.println("상대방 : " + message);
	}

	void hangUp() {
		System.out.println("전원을 끕니다.");
	}

}
