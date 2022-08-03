package SWCert_Basic;

import java.util.Scanner;
import java.io.FileInputStream;

public class VE_Root {
	static int T;
	static float A;
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (Root).txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			A = sc.nextFloat();
			String num = String.format("%.2f", Math.sqrt(A));
			System.out.println("#" + test_case + " " + Math.sqrt(A) + "\t" + num);
			// Math.sqrt() : ������
			// Math.cbrt() : ��������
			// Math.pow(A , B) : ù��° �Ű������� �ι�° �Ű�������ŭ�� ������
			// Math.scalb() : <ù��° �Ű�����> * 2 ^ <�Ű�����>
			// Math.hypot() : (<ù��° �Ű�����> ^ 2) + (<�ι�° �Ű�����> ^ 2)
		}
	}
}
