/*	
*/
package SWCert_InClass;

import java.io.*;
import java.util.*;

public class Day3_TestClass {
	static int N = 3;
	static int Order[] = new int [3];	//	선택을 기억
	static int arr[] = {10, 20, 30};
	
	static void perm(int k, int n, int Stat) {	//	Stat : 이미 선택한 요소들의 집합
		if(k == n) {	//	하나의 순열이 생성, 단말 노드에 도착
			//	order[]에 요소가 저장
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
		
		
		
		System.out.println("중복순열");
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
		
		
		
		System.out.println("순열 (중복 X)");
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