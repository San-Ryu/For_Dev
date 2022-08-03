package SWCert_InClass_Practice;

import java.util.Scanner;

public class P08Magnetic {
	static int[][] map = new int[100][100];
	static int N;
	
	public static void main(String[] args) throws Exception
	{
		//System.setIn(new FileInputStream("02Day/input(3).txt"));
		Scanner sc = new Scanner(System.in);
	
		for (int tc = 1; tc <= 10; tc++){
			
			N = sc.nextInt();
			
			for (int i = 0; i < N; i++){
				for (int j = 0; j < N; j++)
					map[i][j] = sc.nextInt();
			}
			int cnt = 0, state; 	// cnt: 교착상태 카운트, state: 1 만났는지 체크

			for (int x = 0; x < N; x++){	// 열 우선 순회
				state = 0;
				for (int y = 0; y < N; y++) {

					if (state == 0 && map[y][x] == 1){
						state = 1;
					}
					else if (state == 1 && map[y][x] == 2){
						cnt++;
						state = 0;
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
		sc.close();
	}
}
