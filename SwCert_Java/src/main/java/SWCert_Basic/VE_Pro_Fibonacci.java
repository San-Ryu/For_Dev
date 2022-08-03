/* Fibonacci
[문제] 
N번째까지의 Fibonacci 수열 출력

[입력 예시]
10

*/
package SWCert_Basic;

import java.util.Scanner;
import java.io.FileInputStream;

public class VE_Pro_Fibonacci {
	static int N;
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (Fibonacci).txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		//	Improvement : 굳이 For문을 통해 Arr[0]과 Arr[1]을 정의할 필요는 없다.
		//				   더욱 간단하게 표현할 수 있다.
		int []arr = new int[N];

//		for(int i = 0; i < N; i++) {
//			if(i == 0) {
//				arr[i] = 1;
//			}
//			else if(i == 1) {
//				arr[i] = 1;
//			}
//			else {
//				arr[i] = arr[i - 1] + arr[i - 2];
//			}
//		}

		arr[0] = 1;
		arr[1] = 1;
		
		System.out.print(" " + arr[0] + " " + arr [1] + " ");
		for(int i = 2; i < N; i ++) {
			arr[i] = arr[i - 2] + arr[i - 1];
			System.out.print(arr[i] + " ");
		}
	}
}
