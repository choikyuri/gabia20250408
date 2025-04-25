package chapter09;

public class DeskTop extends Computer {

	// 추상 클래스를 상속 받으면 추상 메서드는 반드시 구현해야 한다.

	@Override
	public void display() {
		System.out.println("DeskTop Display()");
	}

	@Override
	public void typing() {
		System.out.println("DeskTop Typing()");
	}

}
