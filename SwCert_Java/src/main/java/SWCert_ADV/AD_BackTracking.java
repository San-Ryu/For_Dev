/*	�ؼ�
�Է°� / �ʿ䰪

��Ʈ��ŷ (��������)
- �������� (�������� == ������?)
   Y : ��� �� Return (�ǵ�����)
   N : ���� (��������� ���� ���)
       Y : Continue
       N : ��� ó�� / �� ���� (�迭 �ڸ���)
		       ��� ȣ�� 
		       �̻�� ó��
 */
package SWCert_ADV;

import java.util.Scanner;
import java.io.FileInputStream;

public class AD_BackTracking {
	
	static int N = 4;
	static int[] sol = new int [N];
	static int[] perm = new int [N];
	
	public static void main(String args[]) throws Exception {
		backtrack(0);
	}
	
	public static void backtrack(int n) {
		if(isSolution(n)) {
			processSolution();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(perm[i] == 0) {
				sol[n] = i + 1;
				perm[i] = 1;
				backtrack(n + 1);
				perm[i] = 0;
			}
		}
		
	}
	
	public static boolean isSolution(int n) {
		return (n == N);
	}
	
	public static void processSolution() {
		for(int i = 0; i < N; i++) {
			System.out.printf("%d", sol[i]);
		}
		System.out.println();
	}
}
