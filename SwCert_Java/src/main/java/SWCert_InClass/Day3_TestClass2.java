/*	상태 교환 트리
*/
package SWCert_InClass;

import java.io.*;
import java.util.*;

public class Day3_TestClass2 {
	static char Arr[] = {'A', 'B', 'C', 'D'};
	static int N = Arr.length;	//	선택을 기억

	public static void main(String args[]) throws Exception{
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; i < N; j++) {
				for(int k = j + 1; k < N; k++) {
					System.out.println(Arr[i] + " " + Arr[j] + " " + Arr[k]);
					
				}
			}
		}
	}	//	End Main
}	//	End Class