package chapter05;

public class FuncTest_04 {

	// 반환값이 있음 ~ return
	public int channelUp(int volume) {
		System.out.println("현재 소리는 " + volume + "입니다.");
		System.out.println("소리를 높이겠습니다.");

		return volume + 2;
	}

	// 반환값이 없음
	public void channelDown(int volume) {
		System.out.println("현재 소리를 " + volume + "만큼 내립니다.");

	}

	public static void main(String[] args) {

		FuncTest_04 tv = new FuncTest_04();

		int volume = 5;
		// 반환값이 있음 volume+2
		int v = tv.channelUp(volume);
		System.out.println("소리를 " + v + "로 올립니다.");
		System.out.println("==============================");
		System.out.println("소리를 " + tv.channelUp(volume) + "로 올립니다.");
		System.out.println("==============================");
		// 반환값이 없음
		tv.channelDown(volume);

	}

}
