package chapter05;

import java.util.Scanner;

public class Pastry_09 {

	// 멤버변수

	// 생성자

	// 메서드 Overload 1
	public void makeBread() {
		System.out.println("빵을 만듭니다.");
	}

	// 메서드 Overload 2
	public void makeBread(int cnt) {
		for (int i = 0; i < cnt; i++) {
			System.out.println((i + 1) + "번째 빵을 만들었습니다.");
		}
		System.out.println("요청하신 " + cnt + "개의 빵이 모두 완료되었습니다.");
	}

	// 메서드 Overload 3
	public void makeBread(int cnt, String name) {
		for (int i = 0; i < cnt; i++) {
			System.out.println((i + 1) + "번째 빵을 만들었습니다.");
		}
		System.out.println("요청하신 " + cnt + "개의 " + name + "빵이 모두 완료되었습니다.");
	}

	// -----------------------------------

	void order() {

		boolean run = true;

		Scanner scan = new Scanner(System.in);

		while (run) {
			System.out.println("------------------------------------------");
			System.out.println("1. 빵 개수만 선택 | 2.빵 개수와 종류 선택 | 3.종료");
			System.out.println("------------------------------------------");
			System.out.print("선택>> ");

			int input_num = Integer.parseInt(scan.nextLine());

			switch (input_num) {
			case 1:
				System.out.print("빵 개수 입력: ");
				int cnt1 = Integer.parseInt(scan.nextLine());// 3
				makeBread(cnt1);
				break;
			case 2:
				System.out.print("빵 개수 입력: ");
				int cnt2 = Integer.parseInt(scan.nextLine()); // 3
				System.out.print("종류 선택 : ");
				String name = scan.nextLine();
				makeBread(cnt2, name);
				break;
			case 3:
				System.out.print("프로그램 종료");
				run = false;
				break;
			default:
				System.out.println("잘못된 번호를 입력하셨습니다.");
			}// switch
		} // while
	}// main
}// class
