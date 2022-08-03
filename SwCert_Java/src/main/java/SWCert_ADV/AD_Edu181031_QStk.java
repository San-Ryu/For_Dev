/*	����, ť
[����]
�� ���������� ���ð� ť�� ���� ������ ����. 
���ÿ� ���ð� ť�� �����ؾ� �ϸ� ������ �� ���� ����� �ִ�.

1. � ���� a�� �Է¹޾� ������ top�� �ְ� ���� ť�� rear���� �ִ´�.
2. ������ top���� ������ ������ ���� �� ������ ����ϰ� 
     ť�� front������ ������ ������ ���� �� ������ ����Ѵ�.

[���� ����]
1) �ð� ���� 7.0 Sec
2) �޸� ���� 256 MB

[�Է�]
ù��° �ٿ��� ����� ���� N(1 <= N <= 100,000)�� �־�����.

���� N���� �ٿ��� ����� �ϴ� ������� ����� �־�����. 
�� �ٿ� �ϳ��� ����� �־����� "1 a"�� �������� �־����� ���,
1�� ����� ���� a(-10^9 �� a �� 10^9)�� �ϴ� ���̰�, 

"2"�� �������� �־����� ���� 2�� ����� �����ϴ� ���̴�.

[���]
2�� ����� �� ������ �� �ٿ� ������� ���ÿ��� ���� ���� ť���� ���� ���� ���� �ϳ��� �����Ͽ� ����Ѵ�. 
���� ���ð� ť�� ������� ��� ���ڿ� "empty"(����ǥ ����)�� ����Ѵ�.

[�Է� ����]
6
2
1 10
1 20
2
2
2

[��� ����]
empty
20 10
10 20
empty
*/
package SWCert_ADV;

import java.io.*;
import java.util.*;

//	koitp ����� Class��
//	public class source{
public class AD_Edu181031_QStk {
	static int N, Odr, Num;
	
	static Queue<Integer> q;
	static Stack<Integer> stk;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		q = new LinkedList<>();
		stk = new Stack<>();
		
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			Odr = Integer.parseInt(st.nextToken());
			
			if(Odr == 1){
				Num = Integer.parseInt(st.nextToken());
				q.add(Num);
				stk.add(Num);
			}
			
			else if(Odr == 2){
				if(q.isEmpty() && stk.isEmpty())	System.out.println("empty");
				else	System.out.println(stk.pop() + " " + q.poll());
			}
		}
	}
}