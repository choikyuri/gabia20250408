package chapter09;

public class SmartPhone extends Phone {

	// 부모 클래스에서 생성자를 오버로딩시 기본 생성자는 인식이 안되서 추상클래스로 정의함
	public SmartPhone(String owner) {
		super(owner);
	}

	public void intersearch() {
		System.out.println("인테넷 검색을 합니다");
	}

}
