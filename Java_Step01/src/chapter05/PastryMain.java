package chapter05;

public class PastryMain {

	public static void main(String[] args) {

		Pastry_09 bread = new Pastry_09();
		/*
		 * //Overload 활용 bread.makeBread(); System.out.println("--------------------");
		 * bread.makeBread(2); System.out.println("--------------------");
		 * bread.makeBread(3, "크림빵");
		 */

		bread.order();
	}

}
