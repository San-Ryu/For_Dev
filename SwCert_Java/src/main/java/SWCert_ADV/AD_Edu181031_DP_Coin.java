/*	���� ��ȯ
[����]
�츮���� ���� ������ 1��, 5��, 10��, 50��, 100��, 500���� 6�ܰ�� �̷������. 
�ܵ� 256���� ���ַ���, 100�� 2��, 50�� 1��, 5�� 1��, 1�� 1���� ��� 5���� ������ �ʿ��ϴ�.

���� ���� ������ 1��, 4��, 6���� 3�ܰ�� �̷���� ���󿡼� �ܵ� 8���� ���ַ��� 
6�� 1��, 1�� 2���� �����ϰ�, 4�� 2���ε� �����ϴ�. 
���� ��쿡�� ������ 3��, ���� ��쿡�� ������ 2�� �ʿ��ϴ�.

������ ������ �ּҷ� �ϸ鼭 ������ ���ִ� ���� �����̶�� ���� ����� ���ؾ��Ѵ�. 
�������� ������ �־�����, ���ϴ� �ܵ��� �־��� ��, �� �ܵ��� ���߱� ���� �ʿ��� �ּ��� ���� ���� ���Ͻÿ�. 
���� �ִ� ������ ���� �����ϴ�.

[���� ����]
1) �ð� ���� 1.0 Sec
2) �޸� ���� 512 MB

[�з�]
ù ��° �ٿ� ������ �ܰ� �� N�� �־�����. (1 <= N <= 10)
�� ��° �ٿ� �� �������� ������ �������� �и��Ǿ� �־�����. 
�� �������� ������ 1 �̻� 64,000 �����̴�.
�� ��° �ٿ� �ܵ� W�� �־�����. (1 �� W �� 64,000)

[���]
ù ��° �ٿ� �ܵ��� ���ֱ� ���� �ʿ��� �ּ� ������ ���� ����Ѵ�. 
�ܵ��� ���ִ� ���� �Ұ����� ���� ����.

[�Է� ����]
3
1 4 6
8

[��� ����]
2
 */
//	70�ۼ�Ʈ�� ������ ����?
package SWCert_ADV;

import java.io.*;
import java.util.*;

//	koitp ����� Class��
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