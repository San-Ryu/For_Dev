/*	최댓값 찾기
[문제]
N개의 정수 Ai가 주어진다.
1 이상 N 이하의 각 K에 대하여 Max{A1, A2, A3, ---, AK}를 구하는 프로그램을 작성하시오.

[제한 조건]
1) 시간 제한 1.5 Sec
2) 메모리 제한 512 MB

[입력]
첫번째 줄에 정수 N이 주어진다 (1 <= M <= 1,000,000)
두번째 줄에 N개의 정수 Ai가 빈 칸을 사이에 두고 주어진다.
(|Ai| <= 1,000,000)

[출력]
첫번째 줄에서 N 개의 정수를 출력한다.
i번쨰 출력되는 수는 Max{A1, A2, A3, ---, AK}이다.

[입력 예시]
5
1 2 3 4 5

12
1 0 2 200 -1000000 300 82019 1000 2000 324389 1000000 98765

3
0 -200 1 

5
-200 0 1 2 3

8
100 300 82019 1000000 1 324389 12345 98765

[출력 예시]
1 2 3 4 5

1 1 2 200 200 300 82019 82019 82019 324389 1000000 1000000

0 0 1

-200 0 1 2 3

100 300 82019 1000000 1000000 1000000 1000000 1000000
 */
package SWCert_ADV;

import java.io.*;
import java.util.*;

//	koitp 제출시 Class명
//	public class source{
public class AD_Edu181031_DP_MaxNum {
	static int N;
	static int Num[];
	static int Max[];

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String args[]) throws Exception{
		StringTokenizer st = null;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			Num = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)	Num[i] = Integer.parseInt(st.nextToken());
			Max = new int[N];

			Max[0] = Num[0];
			bw.write(Max[0] + " ");
			for(int i = 1; i < N; i++){
				Max[i] = Math.max(Max[i - 1], Num[i]);
				
				if(i == (N - 1))	bw.write(Max[i] + "");
		        else	bw.write(Max[i] + " ");
			}
			
			br.close();
			bw.flush();
			bw.close();
	}
}