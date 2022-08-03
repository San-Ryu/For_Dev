package SWCert_Basic;

import java.util.ArrayList;

public class VE_Refer {
	public static void main(String args[]) throws Exception{
		int numbers[] = null;
		
		//	1. 중복되지 않은 3개의 수를 순서에 관계없이 선택 (6C3)
		for(int i = 0; i < 6; i++) {
			for(int j = i; j < 6; j++) {
				for(int k = j + 1; k < 6; k++) {
					System.out.println(numbers[i] + " " + numbers[j] + " " + numbers[k]);	
				}
			}
		}
		
		//	2. 중복되지 않은 3개의 수를 선택시 순거에 대한 의미가 있을 때
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
