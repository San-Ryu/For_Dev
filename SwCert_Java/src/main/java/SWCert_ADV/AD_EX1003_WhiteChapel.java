/* 화이트 채플
[문제]
화이트채플은 영국의 소도시이다.
이 도시는 잭 더 리퍼(이하 살인자)의 연쇄 살인 사건의 배경이 되는 곳이다.
이 사건을 바탕으로 게임을 만들어보고자 한다.

1. 살인자는 경찰에게 잡히지 않고, 은신처에 도착해야만 한다.
2. 경찰은 포위망을 구축하여 수색을 실시한다.
3. 살인자는 상하좌우로만 움직일 수 있다.
4. 경찰의 수색 범위는 상하좌우이다.
5. 살인자는 마차를 탈 수 있다.
       마차 또한 상하좌우로만 이동이 가능하나, 마차를 타면 한 턴에 2번 이동이 가능하다.  
       또한, 경찰의 포위망을 통과할 수 있다.
       단, 2번째 이동에서도 경찰의 포위망에 있으면 잡힌다.
6. 마차의 사용 횟수에는 제한이 있다.
7. 살인자와 경찰이 N + M회 이동을 했음에도 (N + M회의 턴이 지났음에도)
      살인자를 발견하지 못한다면, 병력을 총동원하여 모든 지역을 수색한다.
      즉, 살인자는 N + M회로 이동 횟수가 제한되어 있으며,
      해당 횟수 내에 은신처에 도달하지 못하면 잡히는 것으로 판정된다.
      
살인자가 은신처에 도달하는 경우, 최소 이동 횟수를 구하시오.

[제약 사항]

[입력]
처음에는 테스트 케이스의 수가 주어지고,
다음 줄에는 화이트채플의 크기 N x M, 경찰의 수 K, 마차의 사용 횟수 C가 주어진다.
그 다음 줄에는 살인자의 초기 좌표,
그 다음 줄에는 경찰의 초기 좌표가 주어진다.
그 다음 줄부터는 경찰의 다음 좌표들이 주어진다.
(단, 3 <= N, M <= 80 / K <= 800 / C <= 5)

[출력]
출력의 첫 줄은 #T로 시작하며,
공백을 하나 둔 후 살인자가 은신처에 도달하는 최소 이동 횟수를 출력한다.
단, 살인자가 은신처에 도달할 수 없는 경우, -1을 출력한다.

[입력 예시]
1
5 4 2 2	//	N, M, K, C
2 1 5 4	//	살인자의 최초 좌표 및 도착지점 
4 1 5 2	//	경찰의 위치, K = 2이므로 두 개의 좌표
3 1 4 2	//	경찰의 이동 시작. 살인자가 한 번 움직일 때마다 함께 이동.
2 1 4 3
2 2 5 3
3 2 5 2
3 3 4 2 
4 3 3 2
4 2 3 1 
3 2 2 1
5 2 2 2	

[출력 예시]

 */
package SWCert_ADV;

import java.io.*;
import java.util.*;

public class AD_EX1003_WhiteChapel {
	static int N, M, K, C;
	static int sx, sy, ex, ey;
	static int Pol[][];
	static int AnsN;
	
	static int Stat[][];
	static int dx[] = {-1, 0, 0, 1};
	static int dy[] = {0, -1, 1, 0};
	static int dx2[] = {-2, -1, 0, 1, 2, 1, 0, -1};
	static int dy2[] = {0, 1, 2, 1, 0, -1, -2, -1};
	
	public static class Point{
		int x, y, c, w;
		Point(int x, int y, int c, int w) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.w = w;
		}
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
	}
}
