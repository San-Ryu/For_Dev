package SWCert_Basic;

import java.util.ArrayList;

public class VE_Refer {
	public static void main(String args[]) throws Exception{
		int numbers[] = null;
		
		//	1. �ߺ����� ���� 3���� ���� ������ ������� ���� (6C3)
		for(int i = 0; i < 6; i++) {
			for(int j = i; j < 6; j++) {
				for(int k = j + 1; k < 6; k++) {
					System.out.println(numbers[i] + " " + numbers[j] + " " + numbers[k]);	
				}
			}
		}
		
		//	2. �ߺ����� ���� 3���� ���� ���ý� ���ſ� ���� �ǹ̰� ���� ��
		for(int ii = 0; ii < 6; ii++) {
			for(int j = 0; j < 6; j++) {
				for(int k = 0; k < 6; k++) {
					if(ii != j && j != k && k != ii) {
						System.out.println(numbers[ii] + " " + numbers[j] + " " + numbers[k]);
					}
				}
			}
		}
	}
}
