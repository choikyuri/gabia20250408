package chapter01;

public class ImplicitConversion_11 {

	public static void main(String[] args) {
		// 묵시적 형변환: 작은 메모리에서 큰 메모리로 자동으로 변환(byte->int)
		byte bNum=10;
		int iNum=bNum;
		
		System.out.println(bNum);
		System.out.println(iNum);
		
		int iNum2=10;
		//byte bNum2=iNum2; //ERROR
		
		System.out.println(iNum2);
		
		// 묵시적 형변환: 더 정밀한 수로 형변환(int->float)
		int iNum3=30;
		float fNum=iNum3;
		
		System.out.println(iNum3);
		System.out.println(fNum);
		
		float fNum2=30.5f;
		//int iNum4=fNum2;//ERROR
		System.out.println(fNum2);
	}

}
