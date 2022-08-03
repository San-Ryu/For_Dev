/* 제품의 일련번호
[문제]
 한 제조회사에서는 제품 일련번호의 일정 부분에 알파벳 소문자로 구성된 문자열을 이용하고 있다.
이 문자열은 생산된 순서를 의미하기 때문에 제품이 생산된 순서대로 일정 개수의 알파벳을 열거하여 붙이고 있다.

가령 a, b, c, d 4개의 알파벳 소문자를 이용하는 경우,
첫번째 생산된 제품부터 순서대로 abcd, abdc, acbd, acdb, adcb, --- , dabc, dacb, dbac, dbca, dcab, dcba의 문자열이 제품에 붙여지게 된다.
이 중 adbc는 5번째 생산된 제품에, bdca는 12번째 생산된 제품에 붙여지는 문자열이 된다.
그리고, 두 제품의 일련번호 사이에는 6개의 제품이 생산되었음을 알 수 있다.

일련번호의 문자열에 사용되는 알파벳 개수 N이 주어지고, 두개의 문자열이 주어질 때,
두 일련번호 문자열 사이에 몇개의 제품이 생산되었는지 출력하는 프로그램을 작성하시오.
(단, 같은 문자열은 입력값으로 주이짖 않으며, N개의 알파벳을 이용하는 경우, a부터 알파벳 순서대로 N개까지 알파벳 소문자를 이용하여 일련번호 문자열을 만들게 된다.
즉, 6개의 알파벳 이용시 a, b, c, d, e, f 이용)

[입력]
최초 Test Case의 개수 T가 주어지며,
다음 줄부터 T개의 Test Case가 주어진다.
Test Case는 한 줄로 구성되며, 처음 일련번호에 사용되는 알파벳의 개수가 주어진다.
(단, 4 <= N <= 18)
이후 공백을 사이에 두고 두 개의 일련번호 문자열이 공백으로 구분되어 주어진다.

[출력]
각 Test Case에 대하여, #T를 출력하고, 공백을 하나 둔 다음,
두 일련번호 사이에 생산된 제품의 개수를 출력한다.
출력값은 32 Bit 정수값을 넘을 수도 있으므로, 64 Bit 정수형 변수를 사용한다.

[입력 예시]
4
4 adbc bdca
5 ebdac eadcb
6 ecfabd dfcaeb
9 dgceabhf fhagbcde

[출력 예시]
#1 6
#2 4
#3 76
#4 10606
*/
package SWCert_ADV;

import java.util.Scanner;
import java.io.FileInputStream;

public class AD_SerialN {
	static int T, N;
	static String A, B;
	static int[] visited = new int[100];
	static long AnsN;
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (SerialN).txt"));
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			A = sc.next();
			B = sc.next();
			
			AnsN = Math.abs((getIndex(A) - getIndex(B)) - 1);
			
			System.out.println("#" + test_case + " " + AnsN);
			
		}
	}

	public static long getIndex(String Perm) {
		long result = 1;
		
		for(int i = 0; i < N; i++) {
			visited[i] = 0;
		}
		
		int tmp, cnt;
		for(int i = 0; i < N; i++) {
			tmp = (int)(Perm.charAt(i) - 'a');
			cnt = countLessThan(tmp);
			
			result += cnt * fact(N - i - 1);
			
			visited[tmp] = 1;
		}
		return result;
	}
	
	public static int countLessThan(int value) {
		int result = 0;
		
		for(int i = 0; i < value; i++) {
			if(visited[i] == 0) {
				result++;
			}
		}
		return result;
	}
	
	public static long fact(long value) {
		if(value == 0) {
			return 1;
		}
		return value * fact(value - 1);
	}
}
