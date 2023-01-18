/*	물자지원
 
[문제]
 사람의 손길이 닿지 않는 오지를 탐험하는 탐험대의 베이스캠프에서 물자 지원을 요청해였다.
지원은 물자를 헬리콥터에 매달아 수송하며, 목적 지점에 떨어뜨려주는 방법으로 진행된다.
탐험대의 베이스캠프는 원형이며 헬리콥터가 이 베이스캠프 내부에 물자를 투하해주어야만 지원에 성공한다.
베이스캠프 주변은 오지라서 만일 물자를 캠프 밖에 투하하는 경우, 위험성 때문에 물자를 가지고 올 수 없어 지원은 실패한다. (밖으로 나갈 수 없다.)
물자가 베이스 캠프의 경계(원 위)에 정확히 투하된 경우, 지원 성공으로 판정된다.

베이스캠프의 위치는 XY 좌표계의 좌표로 주어진다. 원형으로 이루어진 베이스캠프의 중심 좌표는 (Cx, Cy)이며, 반지름은 R로 주어진다.

물자 투하지점 (Sx, Sy)이 주어졌을 때, 지원 성공 여부를 판단하는 프로그램을 작성하시오.

[제약조건]
Cx, Cy, Sx, Sy는 모두 -10,000 이상 10,000 이하의 정수이다.
R은 1000 이하의 자연수이다.
<그림 참조>

[입력]
10개의 Test Case가 주어진다.
각 Test Case는 두 줄로 구성된다
첫 줄에는 Cx, Cy, R 값이 차례로 주어지며,
두번째 줄에는 Sx, Sy 값이 주어진다

[출력]
각 줄은 #T로 시작하고, 공백을 하나 둔 다음,
해당 Test Case에서 물자 투하 성공 여부를 1 (성공) / 0 (실패)로 출력한다.

[입력 예시]
3
5 6 3
7 8 
-3 5 8 
100 100
10 1 13
15 13

[출력 예시]
#1 1
#2 0
#3 1
*/
package SWCert_INT;

import java.util.Scanner;
import java.io.FileInputStream;

public class SWCert_INT_Airdrop {
//사이트 제출 시에는 반드시 Class명을 Main으로 지정해야함
//public class Main{
	static int T;
	static int Cx, Cy, R, Sx, Sy;
	static int AnsN;
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("D:\\WS_Eclipse\\SwCert_Java\\src\\main\\java\\SWCert_INT\\Input (IM_Airdrop).txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			Cx = sc.nextInt();
			Cy = sc.nextInt();
			R = sc.nextInt();
			Sx = sc.nextInt();
			Sy = sc.nextInt();
			AnsN = 0;
			
			if((Sx - Cx) * (Sx - Cx) + (Sy - Cy) * (Sy - Cy) <= R * R) {
				AnsN = 1;
			}
			else {
				AnsN = 0;
			}
			
			System.out.println("#" + test_case + " " + AnsN);
		}
	}
}