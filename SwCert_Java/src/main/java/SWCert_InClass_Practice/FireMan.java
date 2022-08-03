/*
소방관은 자신의 위치에서 동/서/남/북 4 방향으로 물을 분사 할 수 있다.
분사되는 물은 2가지 타입이 있다. 
1) A 타입(3X5)
2) B 타입(5X3)
조건>
- 소방관 1명당 1번의 분사만 가능하다.
- A, B 타입의 분사는 사방이다.
- 장애물이 있으면 해당 라인만 분사되지 않는다.
- 끌 수 있는 불의 최대 값을 구하시오.
입력> 소방관의 수 2 ~ 5명
# : 벽, 1 : 소방관, 0 : 빈공간
 */
package SWCert_InClass_Practice;

public class FireMan {
	static int N = 2;	// 소방관수
	static int[][] map;
	
	static char[] type = new char[5];
	static int[] dir = new int[5];
	static int cnt = 0;
	static void solve(int k, int n)
	{
		if(k == n) {
			System.out.printf("%2d>", ++cnt);
			for(int i = 0; i < k; i++)
			{
				System.out.print("(" + type[i] +"," + dir[i] + ") ");				
			}
			System.out.println();
			return;
		}
		for(int i = 0; i < 4; i++)
		{
			dir[k] = i;
			type[k] = 'A';
			solve(k + 1, n);
			
			type[k] = 'B';
			solve(k + 1, n);
		}
	}
	public static void main(String[] args) {
		solve(0, N);
	}

}
