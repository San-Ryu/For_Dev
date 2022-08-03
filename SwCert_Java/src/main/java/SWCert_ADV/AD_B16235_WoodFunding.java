/*	나무 재테크
[문제]
부동산 투자로 억대의 돈을 번 상도는 최근 NxN 크기의 땅을 구매했다.
상도는 손쉬운 땅 관리를 위해 땅을 1x1 크기의 칸으로 나누어 두었다.
각가의 칸은 (r, c)로 나타내며, r은 가장 위에서부터 떨어진 칸의 개수, c는 가장 왼쪽으로부터 떨어진 칸의 개수이다.
r과 c는 1부터 시작한다.

상도는 전자통신공학과 출신답게 땅의 양분을 조하사는 로봇 S2D2를 만들었다.
S2D2는 1x1 크기의 칸에 들어있는 양분을 조사해 상도에게 전송하고, 모든 칸에 대해서 조사를 한다.
놀랍게도 양분은 모든 칸이 5만큼 들어있다.

매일매일 넓은 땅을 보면서 뿌듯한 하루를 보내고 있던 어느날 이런 생각이 들었다.

"나무 재테크를 하자!"

나무 재테크란 작은 묘목을 구매해 어느정도 키운 후 팔아서 수익을 얻는 재테크이다.
상도는 나무 재테크로 더 큰 돈을 벌기 위해 M개의 나무를 구매해 땅에 심었다.
같은 1x1 크기의 칸에 여러 개의 나무가 심어져 있을 수도 있다.

이 나무는 사계절을 보내며, 아래와 같은 과정을 반복한다.

봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다.
각각의 나무는 나무가 있는 1x1 크기의 칸에 있는 양분만 먹을 수 있다.
하나의 칸에 여러 개의 나무가 있다면, 나이가 어린 나무부터 양분을 먹는다.
만약, 딱에서 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.

여름에는 봄에 죽은 나무가 양분으로 변하게 된다.
각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다.
소수점 이하는 버린다.

겨울에는 나무가 번식한다.
번식하는 나무는 나이가 5의 배수이어야 하며, 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
어떤 칸(r, c)와 인접한 칸은 
(r - 1, c - 1), (r - 1, c), (r - 1, c + 1), (r, c - 1),
(r, c + 1), (r + 1, c - 1), (r + 1, c), (r + 1, c + 1)
이다.
상도의 땅을 벗어나는 칸에는 나무가 생기지 않는다.

겨울에는 S2D2가 땅을 돌아다니면서 땅에 양분을 추가한다.

각 칸에 추가되는 양분의 양은 A[r][c]이고, 입력으로 주어진다.

K년이 지난 후 상도의 땅에 살아있는 나무의 개수를 구하는 프로그램을 작성하시오.

[입력]
첫째 줄에 N, M, K가 주어진다.
둘째 줄부터 N개의 줄에 A 배열의 값이 주어진다.
r번째 줄의 c번째 값은 A[r][c]이다.
다음 M개의 줄에는 상도가 싶은 나무의 정보를 나타내친 세 정수 x, y, z가 주어진다.
처음 두 개의 정수는 나무의 위치 (x, y)를 의미하고, 마지막 정수는 그 나무의 나이를 의미한다.

[출력]
첫째 줄에 K년이 지난 후 살아남은 나무의 수를 출력한다.

[제한 조건]
1 <= N <= 10
1 <= M <= N2
1 <= K <= 1,000
1 <= A[r][c] <= 100
1 <= 입력으로 주어지는 나무의 나이 <= 10
입력으로 주어지는 나무의 위치는 모두 서로 다름

[입력 예시]
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

[출력 예시]
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
	static int N, M, K;	//	NxN 배열 N, 나무의 수 M, 년수 K
	static int Feed[][];	// 양분 공급 앱
	static int AnsN;	//	결과값
	
	static int Map[][];	//	NxN 맵
	static int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};	//	번식 좌표 X
	static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};	//	번식 좌표 y
	
	static boolean Flag;	//	나무 나이 비교 부분에서, 나무 나이가 같은 경우에 중복 방지용
	static Queue<Integer> Wasted;	//	죽은 나무 저장
	static ArrayList<Integer> Arr[];	//	나무 좌표 X
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("Input파일명"));
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
			   3D Array을 한 행 기준으로 Sort하는 방법이 있었는데, 그거 참고해보면 될듯
			     굳이 Queue로 안돌려도 됨.
			 */
			
			// 모든 과정을 K년동안 반복해야함.
			for(int Year = 0; Year < K; Year++) {
				
				// 일단 나무를 나이에 따라 정렬
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
				
				
				//	봄
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
						
						//	양분을 먹는 도중에 양분 값이 늘어나면 안되므로 죽은 나무를 Queue로 별도 저장
						
						i--;
						tmp--;
					}
				}
				
				//	여름
				tmp = Wasted.size();
				for(int i = 0; i < tmp/3; i++)
					Map[Wasted.poll()][Wasted.poll()] += Wasted.poll()/2;
				
				//	가을
				tmp = Arr[0].size();
				for(int i = 0; i < tmp; i++) {
					if(Arr[2].get(i) % 5 == 0){
						int cx = Arr[0].get(i);
						int cy = Arr[1].get(i);
						
						for(int j = 0; j < dx.length; j++) {
							int nx = cx + dx[j];
							int ny = cy + dy[j];
							
							if(nx < 0 || (N - 1) < nx || ny < 0 || (N - 1) < ny)	continue;
							
							Arr[0].add(nx);	//	나무 번식 좌표 X
							Arr[1].add(ny);	//	나무 번식 좌표 Y
							Arr[2].add(1);	//	나무 번식 나이 A(1)
						}
					}
				}
				
				//	겨울
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