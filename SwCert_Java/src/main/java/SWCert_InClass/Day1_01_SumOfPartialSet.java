/*	부분 수열의 합 _ S/W Academy 2817 (부분 집합의 합)
[문제]
A1, A2, ... , AN의 N개의 자연수가 주어졌을 때, 최소 1개 이상의 수를 선택하여 그 합이 K가 되는 경우의 수를 구하는 프로그램을 작성하시오.

[입력]
첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 2개의 자연수 N(1 ≤ N ≤ 20)과 K(1 ≤ K ≤ 1000)가 주어진다.

두 번째 줄에는 N개의 자연수 수열 A가 주어진다. 수열의 원소인 N개의 자연수는 공백을 사이에 두고 주어지며, 1 이상 100 이하임이 보장된다.

[출력]

각 테스트 케이스마다 ‘#x ’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 부분 수열의 합이 K가 되는 경우의 수를 출력한다. 
  
[입력 예시]
1
4 3
1 2 1 2 

[출력 예시]
#1 4

 */
package SWCert_InClass;

import java.io.*;
import java.util.*;

public class Day1_01_SumOfPartialSet {
	static int N, K;
	static ArrayList<Integer> Arr;
	static int AnsN;

	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("Ipt (Set_Sum).txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
		//	Ipt.
			AnsN = 0;	//	Init.
			
			N = sc.nextInt();
			K = sc.nextInt();
			
			Arr = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				Arr.add(sc.nextInt());	
			}
			
		//	Ipt.
			
			for(int set = 0; set < (1 << N); set++) {	//	i는 2^N까지
				System.out.print("{ ");
				
				int tmp = 0;
				for(int i = 0; i < N; i++) {	//	N = i개일 경우 (i는 0부터 2까지)
					if((set & (1 << i)) != 0) {	//	i번째의 원소를 포함하고 있는가?
						System.out.print(Arr.get(i) + " ");
						tmp += Arr.get(i);
					}
				}
				
				if(tmp == K)	AnsN++;
				System.out.println("}");
			}
			
			
		//	Opt.
			System.out.println("#" + tc + " " + AnsN);
		//	Opt.
		}	//	End Test Case
	}	//	End Main
}	//	End Class

/*
for(int set = 0; set < (1 << N); set++) {	//	i는 2^N까지
	System.out.print("{ ");
	for(int i = 0; i < N; i++) {	//	N = i개일 경우 (i는 0부터 2까지)
		if((set & (1 << i)) != 0) {	//	i번째의 원소를 포함하고 있는가?
			System.out.print(arr[i] + " ");
		}
	}
	System.out.println("}");
}
*/