package chapter11;

class OutterRunnable {

	Runnable runner = new Runnable() {

		@Override
		public void run() {
			System.out.println("Runnable 이 구현된 익명의 클래스 변수");
		}
	};

}// OutterRunnable

public class AnonyMousInnerMain_06 {

	public static void main(String[] args) {
		OutterRunnable out = new OutterRunnable();
		out.runner.run();

	}

}
