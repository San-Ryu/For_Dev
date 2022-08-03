/* S/WCert Advanced 190914 Exam
[문제]
주어진 배열에서 주어진 문자열을 찾으시오.
좌상, 좌, 좌하, 상, 하, 우상, 우, 우하 총 8가지 방향으로 탐색하여 
해당하는 문자열의 개수를 모두 구하는 프로그램을 작성하시오.

 [입력 예시]
 2
 5 2 CA
 ABCDE
 CABFQ
 GCSGC
 DAVGA
 TQXFG
 7 3 DAB
 DABGEQF
 AQGLGBN
 HBDPTWK
 EAGGQQQ
 YEREOCG
 BLGKQLD
 PKQLALG

[출력 예시]
#1 6
#2 1
 */
package SWCert_ADV;

import java.util.Scanner;
import java.io.FileInputStream;

public class AD_EX190914 {
	//	Definition
	static int T, N, Len, AnsN;
	static char []Ipt;
	static char [][]Brd;
	static int [][]stat;
	static int Flag = 0;
	//	Definition
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (ADEX190914).txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();	//	Test Case Number
		for(int test_case = 1; test_case <= T; test_case++) {	//	Start Test Case
		// Input
			N = sc.nextInt();
			Len = sc.nextInt();
			String []tmp = new String[1];
			tmp[0] = sc.next();
			
			char []ipt = new char[Len];
			for(int i = 0; i < Len; i ++) {
				Ipt[i] = tmp[0].charAt(i);
				System.out.print(Ipt[i]);
			}
			System.out.println();
			
			char [][]Brd = new char[N][N];	//	Board
			int [][]Stat = new int[N][N];	//	Status
			
			// Board 2D Array
			// Improve : 배열을 전역변수로 설정한 후, N이 입력된 후에 크기를 지정해주면,
			//			  다른 메서드에서도 사용할 수 있도록 정의 가능.
			for(int i = 0; i < N; i++) {
				tmp[0] = sc.next();
				for(int j = 0; j < N; j++) {
					Brd[i][j] = tmp[0].charAt(j);
					System.out.print(Brd[i][j] + " ");
				}
				System.out.println();
			}
			
			// 가지치기 1. Stat (2D Array)
			// Improve : 처음에 Status Array 값을 지정해주어, 
			//			 Initial + Unused의 2가지 조건을 모두 필터링 가능
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(Brd[i][j] == Ipt[0]) {
						Stat[i][j] = 1;	//	Except Initial Character (Unuse or Used Marking)
					}
					System.out.print(Stat[i][j] + " ");
				}
				System.out.println();
			}
		// Input
			
		// Output
			System.out.print("#" + test_case + " ");
			
			// Check Method
			for(int x = 0; x < N; x++) {
				for(int y = 0; y < N; y++){
					if( x < Len || (N - x) + 1 < Len) {
						break;
					}
					
					else {
						if(stat[x][y] == 0) {	//	" is Initial Character" or "Used Character"
												//	Caution : Switch()에는 어떤 변수든 넣을 수 있지만,
												//			  Case 뒤에는 상수만 넣어야 한다. (변수가 올 수 없음)
							if(Brd[x - 1][y - 1] == Ipt[1]) {
								Flag = 1;	//	Upper Left
								check(x - 2, y -2, 3);
							}
							else if(Brd[x][y - 1] == Ipt[1]) {
								Flag = 2;	//	Upper
								check(x, y -2, 3);
							}
							else if(Brd[x + 1][y - 1] == Ipt[1]) {
								Flag = 3;	//	Upper Right
								check(x + 2, y -2, 3);
							}
							else if(Brd[x - 1][y] == Ipt[1]) {
								Flag = 4;	//	Left
								check(x - 2, y, 3);
							}
							else if(Brd[x + 1][y] == Ipt[1]) {
								Flag = 6;	//	Right
								check(x + 2, y, 3);
							}
							else if(Brd[x - 1][y + 1] == Ipt[1]) {
								Flag = 7;	//	Upper
								check(x - 2, y + 2, 3);
							}
							else if(Brd[x][y + 1] == Ipt[1]) {
								Flag = 8;	//	Upper
								check(x, y + 2, 3);
							}
							else if(Brd[x + 1][y + 1] == Ipt[1]) {
								Flag = 9;	//	Upper
								check(x + 2, y + 2, 3);
							}
						}
					}
				}
			}
		// Output
			
			Flag = 0;
		}	//	End Case
	}	//	End Main
	
	public static void check(int x, int y, int z) {	// X, Y, Order
		for(int i = 0; i < Len; i++) {
			for(int j = 0; j < ((Len - z) + 1); j++) {
				if(Brd[x][y] == Ipt[z]) {
					switch(Flag) {
						case '1' : check(x - 1, y - 1, z + 1); break;	//	Upper Left
						case '2' : check(x, y - 1, z + 1); break;	//	Upper Right
						case '3' : check(x + 1, y - 1, z + 1); break;	//	Upper
						case '4' : check(x - 1, y, z + 1); break;	//	Left
						case '6' : check(x + 1, y, z + 1); break;	//	Right
						case '7' : check(x - 1, y + 1, z + 1); break;	//	Down Left
						case '8' : check(x, y + 1, z + 1); break;	//	Down
						case '9' : check(x + 1, y + 1, z + 1); break;	//	Down Right
						
					}
				}
			}
		}
	}
	
	public static void Turn_Status(int x, int y) {
		
	}
}	//	End Class
