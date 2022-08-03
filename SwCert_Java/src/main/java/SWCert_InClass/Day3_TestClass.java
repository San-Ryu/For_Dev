/*	
*/
package SWCert_InClass;

import java.io.*;
import java.util.*;

public class Day3_TestClass {
	static int N = 3;
	static int Order[] = new int [3];	//	������ ���
	static int arr[] = {10, 20, 30};
	
	static void perm(int k, int n, int Stat) {	//	Stat : �̹� ������ ��ҵ��� ����
		if(k == n) {	//	�ϳ��� ������ ����, �ܸ� ��忡 ����
			//	order[]�� ��Ұ� ����
			for(int i = 0; i < n; i++) System.out.print(arr[Order[i]] + " ");
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if((Stat & (1 << i)) != 0) continue;
			Order[k] = i;
			perm(k + 1, n, Stat | (1 << i));
		}
	}
	
	public static void main(String args[]) throws Exception{
		perm(0, 3, 0);
		
		
		
		System.out.println("�ߺ�����");
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					System.out.print("[" + i + " " + j + " " + k + "]");	
				}
				System.out.print(" / ");
			}
			System.out.println();
		}
		System.out.println();
		
		
		
		System.out.println("���� (�ߺ� X)");
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				
				for(int k = 0; k < N; k++) {
					if(j == k || i == k) continue;
					System.out.print("[" + i + " " + j + " " + k + "]");	
				}
				System.out.print(" / ");
			}
			System.out.println();
		}
		System.out.println();
	}	//	End Main
}	//	End Class