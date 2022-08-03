/*	재귀 Recursion

 */
package SWCert_InClass;

public class Day1_03_Recursive {
	static int cnt, sum;
	
	public static void PrintHello(int i, int n, int deg) {
		if(i == n && deg == 0) {
//			if(i % 2 == 1) {
				cnt++;
				return;	
//			}
		}
		
		if(i == n && deg == 1) {
//			if(i % 2 == 0) {
				sum++;
				return;	
//			}
		}
		
		if(i < n) {
			System.out.println(i + " >> Hello!");
			PrintHello(i + 1, n, 0);	//	Degree가 N일 ��의 K진 트리 단말로그 개수 : K^N
			PrintHello(i + 1, n, 1);
			PrintHello(i + 1, n, 1);
			PrintHello(i + 1, n, 0);
			System.out.println(i + " >> Hello!");
		}
	}	//	End PrintHello
	public static void main(String args[]) throws Exception{
		cnt = sum = 0;
		PrintHello(0, 3, 0);
		System.out.println("cnt = " + cnt);
		System.out.println("sum = " + sum);
	}	//	End Main
}	//	End	Class 