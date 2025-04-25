package chapter09;

public class AnimalMain_02 {

	public static void main(String[] args) {

		Dog dog = new Dog();
		Cat cat = new Cat();
		dog.sound();
		cat.sound();

		System.out.println();

		animalSound(new Dog());
		animalSound(new Cat());

	}

	public static void animalSound(Animal animal) {
		animal.sound();
	}

}
