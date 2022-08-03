/* 덧셈 계산기
[문제]
전자 계산기 중, 두 수의 합을 구하는 덧셈 기능을 구현하려 한다.
두 수 A와 B가 주어졌을 때, 두 수의 합 Answer를 구하는 프로그램을 작성하시오.

[제약사항]
A와 B는 30자리의 정수 또는 0이다.
두 수의 합 Answer는 0으로 시작할 수 없다.

[입력]
입력은 다음과 같이 구성되어있다.
첫번째 줄에는 Test Case의 개수 T가 주어진다.
그 다음 T개의 Test Case가 차례로 주어진다.

각 Test Case는 한 줄로 이루어져 있으며,
두 수 A와 B가 공백을 사이에 두어 차례대로 입력된다.

[출력]
각 줄은 #T로 시작되고 공백을 하나 둔 다음,
A와 B의 합인 Answer를 출력한다.
(T는 Test Case 번호) 

[입력 예시]
5
99999999999999999999 2
23185003 251387
100 300
0 200
300 0

[출력 예시]
#1 100000000000000000001
#2 23436390
#3 400
#4 200
#5 300
 
 */
package SWCert_INT;

import java.io.FileInputStream;

public class IM_IMEX180928_Carculator_APlusB {
	public static void main(String Args[]) throws Exception {
		System.setIn(new FileInputStream("D:\\Redan_Workspace\\SWCert_Src\\Input (IM_IMEX180928_Carculator_APlusB).txt"));
	}
}

