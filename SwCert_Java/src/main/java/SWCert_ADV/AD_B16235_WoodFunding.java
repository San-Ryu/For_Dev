/*	���� ����ũ
[����]
�ε��� ���ڷ� ����� ���� �� �󵵴� �ֱ� NxN ũ���� ���� �����ߴ�.
�󵵴� �ս��� �� ������ ���� ���� 1x1 ũ���� ĭ���� ������ �ξ���.
������ ĭ�� (r, c)�� ��Ÿ����, r�� ���� ���������� ������ ĭ�� ����, c�� ���� �������κ��� ������ ĭ�� �����̴�.
r�� c�� 1���� �����Ѵ�.

�󵵴� ������Ű��а� ��Ŵ�� ���� ����� ���ϻ�� �κ� S2D2�� �������.
S2D2�� 1x1 ũ���� ĭ�� ����ִ� ����� ������ �󵵿��� �����ϰ�, ��� ĭ�� ���ؼ� ���縦 �Ѵ�.
����Ե� ����� ��� ĭ�� 5��ŭ ����ִ�.

���ϸ��� ���� ���� ���鼭 �ѵ��� �Ϸ縦 ������ �ִ� ����� �̷� ������ �����.

"���� ����ũ�� ����!"

���� ����ũ�� ���� ������ ������ ������� Ű�� �� �ȾƼ� ������ ��� ����ũ�̴�.
�󵵴� ���� ����ũ�� �� ū ���� ���� ���� M���� ������ ������ ���� �ɾ���.
���� 1x1 ũ���� ĭ�� ���� ���� ������ �ɾ��� ���� ���� �ִ�.

�� ������ ������� ������, �Ʒ��� ���� ������ �ݺ��Ѵ�.

������ ������ �ڽ��� ���̸�ŭ ����� �԰�, ���̰� 1 �����Ѵ�.
������ ������ ������ �ִ� 1x1 ũ���� ĭ�� �ִ� ��и� ���� �� �ִ�.
�ϳ��� ĭ�� ���� ���� ������ �ִٸ�, ���̰� � �������� ����� �Դ´�.
����, ������ ����� ������ �ڽ��� ���̸�ŭ ����� ���� �� ���� ������ ����� ���� ���ϰ� ��� �״´�.

�������� ���� ���� ������ ������� ���ϰ� �ȴ�.
������ ���� �������� ���̸� 2�� ���� ���� ������ �ִ� ĭ�� ������� �߰��ȴ�.
�Ҽ��� ���ϴ� ������.

�ܿ￡�� ������ �����Ѵ�.
�����ϴ� ������ ���̰� 5�� ����̾�� �ϸ�, ������ 8���� ĭ�� ���̰� 1�� ������ �����.
� ĭ(r, c)�� ������ ĭ�� 
(r - 1, c - 1), (r - 1, c), (r - 1, c + 1), (r, c - 1),
(r, c + 1), (r + 1, c - 1), (r + 1, c), (r + 1, c + 1)
�̴�.
���� ���� ����� ĭ���� ������ ������ �ʴ´�.

�ܿ￡�� S2D2�� ���� ���ƴٴϸ鼭 ���� ����� �߰��Ѵ�.

�� ĭ�� �߰��Ǵ� ����� ���� A[r][c]�̰�, �Է����� �־�����.

K���� ���� �� ���� ���� ����ִ� ������ ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

[�Է�]
ù° �ٿ� N, M, K�� �־�����.
��° �ٺ��� N���� �ٿ� A �迭�� ���� �־�����.
r��° ���� c��° ���� A[r][c]�̴�.
���� M���� �ٿ��� �󵵰� ���� ������ ������ ��Ÿ��ģ �� ���� x, y, z�� �־�����.
ó�� �� ���� ������ ������ ��ġ (x, y)�� �ǹ��ϰ�, ������ ������ �� ������ ���̸� �ǹ��Ѵ�.

[���]
ù° �ٿ� K���� ���� �� ��Ƴ��� ������ ���� ����Ѵ�.

[���� ����]
1 <= N <= 10
1 <= M <= N2
1 <= K <= 1,000
1 <= A[r][c] <= 100
1 <= �Է����� �־����� ������ ���� <= 10
�Է����� �־����� ������ ��ġ�� ��� ���� �ٸ�

[�Է� ����]
8
1 1 1 
1 
1 1 1 
1 1 4
1 
1 1 1 
5 2 1
2 3 2 3 2
2 3 2 3 2
2 3 2 3 2 
2 3 2 3 2 
2 3 2 3 2 
2 1 3
3 2 3 
5 2 2 
2 3 2 3 2 
2 3 2 3 2 
2 3 2 3 2 
2 3 2 3 2 
2 3 2 3 2 
2 1 3 
3 2 3 
5 2 5 
2 3 2 3 2 
2 3 2 3 2 
2 3 2 3 2 
2 3 2 3 2 
2 3 2 3 2 
2 1 3
3 2 3 
5 2 5 
2 3 2 3 2 
2 3 2 3 2 
2 3 2 3 2 
2 3 2 3 2 
2 3 2 3 2 
2 1 3
3 2 3 
5 2 6 
2 3 2 3 2 
2 3 2 3 2 
2 3 2 3 2 
2 3 2 3 2 
2 3 2 3 2 
2 1 3 
3 2 3 

[��� ����]
#1 1
#2 0
#3 2
#4 15
#5 13
#6 13
#7 13
#8 85
 */
package SWCert_ADV;

import java.io.*;
import java.util.*;

public class AD_B16235_WoodFunding {
	static int N, M, K;	//	NxN �迭 N, ������ �� M, ��� K
	static int Feed[][];	// ��� ���� ��
	static int AnsN;	//	�����
	
	static int Map[][];	//	NxN ��
	static int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};	//	���� ��ǥ X
	static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};	//	���� ��ǥ y
	
	static boolean Flag;	//	���� ���� �� �κп���, ���� ���̰� ���� ��쿡 �ߺ� ������
	static Queue<Integer> Wasted;	//	���� ���� ����
	static ArrayList<Integer> Arr[];	//	���� ��ǥ X
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("Input���ϸ�"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
		//	Ipt.
			AnsN = 0;
			Flag = false;
			
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			
			Map = new int[N][N];
			Feed = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					Map[i][j] = 5;
					Feed[i][j] = sc.nextInt();
				}
			}
			
			Arr = new ArrayList[3];
			for(int i = 0; i < 3; i++) {
				Arr[i] = new ArrayList<>();
			}
			for(int i = 0; i < M; i++) {
				Arr[0].add(sc.nextInt() - 1);	//	X
				Arr[1].add(sc.nextInt() - 1);	//	Y
				Arr[2].add(sc.nextInt());	//	z
			}
			
			System.out.println(Arr[0].toString());
			System.out.println(Arr[1].toString());
			System.out.println(Arr[2].toString());
			
			Wasted = new LinkedList<>();
			
		//	Ipt.
			/*
			   3D Array�� �� �� �������� Sort�ϴ� ����� �־��µ�, �װ� �����غ��� �ɵ�
			     ���� Queue�� �ȵ����� ��.
			 */
			
			// ��� ������ K�⵿�� �ݺ��ؾ���.
			for(int Year = 0; Year < K; Year++) {
				
				// �ϴ� ������ ���̿� ���� ����
				for(int i = 0; i < M; i++) {
					for(int j = 0; j < (M - 1); j++) {
						if(Arr[2].get(j + 1) < Arr[2].get(j)){
							int tmp0 = Arr[0].get(j);
							int tmp1 = Arr[1].get(j);
							int tmp2 = Arr[2].get(j);
							
							Arr[0].set(j, Arr[0].get(j + 1));
							Arr[1].set(j, Arr[1].get(j + 1));
							Arr[2].set(j, Arr[2].get(j + 1));
							
							Arr[0].set(j + 1, tmp0);
							Arr[1].set(j + 1, tmp1);
							Arr[2].set(j + 1, tmp2);
						}
					}
				}
				
				System.out.println(Arr[0].toString());
				System.out.println(Arr[1].toString());
				System.out.println(Arr[2].toString());
				
				
				//	��
				int tmp = Arr[0].size();
				for(int i = 0; i < tmp; i++) {
					if(Arr[2].get(i) < Map[Arr[0].get(i)][Arr[1].get(i)]) {
						Map[Arr[0].get(i)][Arr[1].get(i)] -= Arr[2].get(i);
						Arr[2].set(i,  Arr[2].get(i) + 1);
					}
					
					else {
						Wasted.add(Arr[0].get(i));
						Arr[0].remove(i);
						Wasted.add(Arr[1].get(i));
						Arr[1].remove(i);
						Wasted.add(Arr[2].get(i));
						Arr[2].remove(i);
						
						//	����� �Դ� ���߿� ��� ���� �þ�� �ȵǹǷ� ���� ������ Queue�� ���� ����
						
						i--;
						tmp--;
					}
				}
				
				//	����
				tmp = Wasted.size();
				for(int i = 0; i < tmp/3; i++)
					Map[Wasted.poll()][Wasted.poll()] += Wasted.poll()/2;
				
				//	����
				tmp = Arr[0].size();
				for(int i = 0; i < tmp; i++) {
					if(Arr[2].get(i) % 5 == 0){
						int cx = Arr[0].get(i);
						int cy = Arr[1].get(i);
						
						for(int j = 0; j < dx.length; j++) {
							int nx = cx + dx[j];
							int ny = cy + dy[j];
							
							if(nx < 0 || (N - 1) < nx || ny < 0 || (N - 1) < ny)	continue;
							
							Arr[0].add(nx);	//	���� ���� ��ǥ X
							Arr[1].add(ny);	//	���� ���� ��ǥ Y
							Arr[2].add(1);	//	���� ���� ���� A(1)
						}
					}
				}
				
				//	�ܿ�
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++)
						Map[i][j] += Feed[i][j];
				}

				AnsN = Arr[0].size();
				
			// Opt.
				System.out.println("#" + tc + " " + AnsN);
			// Opt.				
			}	//	End Process
		}	//	End Test Case
	}	//	End Main
}	//	End Class