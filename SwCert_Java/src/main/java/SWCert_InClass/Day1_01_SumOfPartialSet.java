/*	�κ� ������ �� _ S/W Academy 2817 (�κ� ������ ��)
[����]
A1, A2, ... , AN�� N���� �ڿ����� �־����� ��, �ּ� 1�� �̻��� ���� �����Ͽ� �� ���� K�� �Ǵ� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

[�Է�]
ù ��° �ٿ� �׽�Ʈ ���̽��� �� T�� �־�����.

�� �׽�Ʈ ���̽��� ù ��° �ٿ��� 2���� �ڿ��� N(1 �� N �� 20)�� K(1 �� K �� 1000)�� �־�����.

�� ��° �ٿ��� N���� �ڿ��� ���� A�� �־�����. ������ ������ N���� �ڿ����� ������ ���̿� �ΰ� �־�����, 1 �̻� 100 �������� ����ȴ�.

[���]

�� �׽�Ʈ ���̽����� ��#x ��(x�� �׽�Ʈ���̽� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�)�� ����ϰ�, �κ� ������ ���� K�� �Ǵ� ����� ���� ����Ѵ�. 
  
[�Է� ����]
1
4 3
1 2 1 2 

[��� ����]
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
			
			for(int set = 0; set < (1 << N); set++) {	//	i�� 2^N����
				System.out.print("{ ");
				
				int tmp = 0;
				for(int i = 0; i < N; i++) {	//	N = i���� ��� (i�� 0���� 2����)
					if((set & (1 << i)) != 0) {	//	i��°�� ���Ҹ� �����ϰ� �ִ°�?
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
for(int set = 0; set < (1 << N); set++) {	//	i�� 2^N����
	System.out.print("{ ");
	for(int i = 0; i < N; i++) {	//	N = i���� ��� (i�� 0���� 2����)
		if((set & (1 << i)) != 0) {	//	i��°�� ���Ҹ� �����ϰ� �ִ°�?
			System.out.print(arr[i] + " ");
		}
	}
	System.out.println("}");
}
*/