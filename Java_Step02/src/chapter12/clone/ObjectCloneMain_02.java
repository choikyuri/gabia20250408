package chapter12.clone;

public class ObjectCloneMain_02 {

	public static void main(String[] args) throws CloneNotSupportedException {

		Circle circle = new Circle(10, 20, 30);
		Circle circleCopy = (Circle) circle.clone();

		System.out.println(circle);
		System.out.println(circleCopy);

		// hash
		System.out.println(System.identityHashCode(circle));
		System.out.println(System.identityHashCode(circleCopy));

	}

}
