/*	동전 교환
[문제]
우리나라 동전 단위는 1원, 5원, 10원, 50원, 100원, 500원의 6단계로 이루어진다. 
잔돈 256원을 내주려면, 100원 2개, 50원 1개, 5원 1개, 1원 1개로 모두 5개의 동전이 필요하다.

만약 동전 단위가 1원, 4원, 6원의 3단계로 이루어진 나라에서 잔돈 8원을 내주려면 
6원 1개, 1원 2개도 가능하고, 4원 2개로도 가능하다. 
앞의 경우에는 동전이 3개, 뒤의 경우에는 동전이 2개 필요하다.

동전의 개수를 최소로 하면서 동전을 내주는 것이 목적이라면 뒤의 방법을 택해야한다. 
동전들의 단위가 주어지고, 원하는 잔돈이 주어질 때, 그 잔돈에 맞추기 위해 필요한 최소의 동전 수를 구하시오. 
갖고 있는 동전의 수는 무한하다.

[제한 조건]
1) 시간 제한 1.0 Sec
2) 메모리 제한 512 MB

[압력]
첫 번째 줄에 동전의 단계 수 N이 주어진다. (1 <= N <= 10)
두 번째 줄에 각 동전들의 단위가 공백으로 분리되어 주어진다. 
각 동전들의 단위는 1 이상 64,000 이하이다.
세 번째 줄에 잔돈 W가 주어진다. (1 ≤ W ≤ 64,000)

[출력]
첫 번째 줄에 잔돈을 내주기 위해 필요한 최소 동전의 수를 출력한다. 
잔돈을 내주는 것이 불가능한 경우는 없다.

[입력 예시]
3
1 4 6
8

[출력 예시]
2
 */
//	70퍼센트만 정답인 이유?
package SWCert_ADV;

import java.io.*;
import java.util.*;

//	koitp 제출시 Class명
//	public class source{
public class AD_Edu181031_DP_Coin {
	static int K;
	static int Change;
	static int AnsN;

	static boolean Flag;
	static ArrayList<Integer> Coin;
	static Queue<Integer> q;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		AnsN = 0;
		
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		
		Coin = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++){
			Coin.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(Coin);
		Collections.reverse(Coin);
		
		st = new StringTokenizer(br.readLine());
		Change = Integer.parseInt(st.nextToken());
		
		q = new LinkedList<>();
		
		BTRK(0);
		
		while(!q.isEmpty()){
			int tmp = q.poll();
			AnsN = Math.min(AnsN, tmp);
		}
		System.out.print(AnsN);
	}
	
	public static void BTRK(int n){
		for(int i : Coin){
			if((Change - i) < 0) continue;
			if((Change - i) == 0) {
				AnsN++;
				q.add(AnsN);
				Flag = true;
				return;
			}
			if(0 < (Change - i)){
				Change-= i;
				AnsN++;
				BTRK(n + 1);
				if(Flag)	return;
				
				Change+= i;
				AnsN--;
			}
		}
	}
}