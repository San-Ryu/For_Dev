/*




 */
package SWCert_Basic;

import java.io.*;
import java.util.*;

public class VE_Pro_Fibonacci_Basis {
	static int N;

	static int arr[];
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("Input (VE_Fibonacci).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			for(int i = 0; i < N; i++) {
				if(i == 0 || i == 1) {
					arr[i] = 1;
					System.out.print(arr[i] + " ");
					continue;
				}
				
				arr[i] = arr[i - 1] + arr[i - 2];
				
				System.out.print(arr[i] + " ");
			}
			
			System.out.println();
		}	//	End Test Case
	}	//	End Main
}	//	End Class
