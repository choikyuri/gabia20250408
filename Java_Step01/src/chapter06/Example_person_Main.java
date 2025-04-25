package chapter06;

public class Example_person_Main {

	public static void main(String[] args) {

		// 이름:홍길동/ 키:180/ 몸무게: 80
		Example_person person1 = new Example_person();
		person1.name = "홍길동";
		person1.height = 180f;
		person1.weight = 80F;

		System.out.println("이름: " + person1.name + " | 키: " + person1.height + " | 몸무게: " + person1.weight);
		System.out.println("--------------------------------------------------------");

		Example_person person2 = new Example_person("홍길동");
		person2.height = 180f;
		person2.weight = 80F;

		System.out.println("이름: " + person2.name + " | 키: " + person2.height + " | 몸무게: " + person2.weight);
		System.out.println("--------------------------------------------------------");

		Example_person person3 = new Example_person("홍길동", 180, 80);
		System.out.println("이름: " + person3.name + " | 키: " + person3.height + " | 몸무게: " + person3.weight);

	}

}
