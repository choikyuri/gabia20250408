package chapter11;

class OutterRun {

	// 익명의 클래스
	Runnable getRunnable(int i) {
		int num = 100;

		return new Runnable() {

			@Override
			public void run() {
				// num=200;
				// i=10;
				System.out.println(i); // 10
				System.out.println(num); // 100
			}
		};

	}// Runnable

}// OutterRun

public class AnonyMousInnerMain_05 {

	public static void main(String[] args) {
		OutterRun out = new OutterRun();
		Runnable runnable = out.getRunnable(10);
		runnable.run();

	}

}
