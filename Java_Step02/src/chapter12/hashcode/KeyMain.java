package chapter12.hashcode;

import java.util.HashMap;

public class KeyMain {

	public static void main(String[] args) {

		HashMap<Key, String> hashMap = new HashMap<Key, String>();

		// System.out.println(hashMap);
		hashMap.put(new Key(1), "홍길동");
		System.out.println(hashMap);

		hashMap.put(new Key(1), "홍길동");
		System.out.println(hashMap);

	}

}
