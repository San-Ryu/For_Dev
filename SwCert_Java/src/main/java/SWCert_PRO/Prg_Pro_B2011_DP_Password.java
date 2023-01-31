/*	[백준] 2011 암호코드
[문제]
상근이와 선영이가 다른 사람들이 남매간의 대화를 듣는 것을 방지하기 위해서 대화를 서로 암호화하기로 했다.
그래서 다음과 같은 대화를 했다.

- 상근 : 그냥 간단히 암호화 하자. A를 1이라고 하고, B는 2로, 그리고 Z는 26으로 하는거야.
- 선영 : 그럼 안돼. 만약, "BEAN"을 암호화하면 25114가 나오는데, 이걸 다시 글자로 바꾸는 방법은 여러가지가 있어.
- 상근 : 그렇네. 25114를 다시 영어로 바꾸면, "BEAAD", "YAAD", "YAN", "YKD", "BEKD", "BEAN"으로 총 6가지가 나오는데,
		BEAN이 맞는 단어라는건 쉽게 알 수 있잖아?
- 선영 : 예가 적절하지 않았네 ㅠㅠ 만약 내가 500자리 글자를 암호화 했다고 해봐. 그 때는 나올 수 있는 해석이 많은데, 그걸 언제 다 해봐?
- 상근 : 얼마나 많은데?
- 선영 : 구해보자!

어떤 암호가 주어졌을 때, 그 암호의 해석이 몇가지나 나올 수 있는지 구하는 프로그램을 작성하시오.

[입력]
첫째 줄에 5000자리 이하의 암호가 주어진다. 암호는 숫자로 이루어져 있다.

[출력]
나올 수 있는 해석의 가짓수를 구하시오.
정답이 매우 클 수 있으므로, 1000000으로 나눈 나머지를 출력한다.
암호가 잘못되어 암호를 해석할 수 없는 경우에는 0을 출력한다.

[입력 예시]
25114

[출력 예시]
6
 */

/*
백준 2011번 암호코드 문제는 DP(Dynamic Programming) 알고리즘을 사용하여 풀 수 있는 문제입니다.

문제 설명:

문자열 s는 "0"~"9"의 숫자로 구성된 암호입니다.
s[0]~s[i-1]까지의 부분 문자열에서 마지막 두 자리만을 사용하여 만들 수 있는 부분 문자열의 개수를 구하는 문제입니다.
각 부분 문자열의 값은 10이상이고, 99이하여야 합니다.
예시:

s = "1234"일 경우, 12, 23, 34의 부분 문자열을 만들 수 있으므로 결과는 3입니다.
솔루션:

1. 
dp 배열 선언 및 초기화
dp[0] = 1

2. 
s[i-1]까지의 부분 문자열에서 마지막 두 자리만을 사용하여 만들 수 있는 부분 문자열의 개수 구하기
for (int i = 1; i <= n; i++) {
int x = s[i-1]-'0';
if (x >= 1 && x <= 9) dp[i] += dp[i-1];
if (i == 1) continue;
int y = (s[i-2]-'0')*10 + x;
if (y >= 10 && y <= 26) dp[i] += dp[i-2];
}

3. 
dp[n]을 출력하면 결과가 나옵니다.

<C++>
#include<bits/stdc++.h>
using namespace std;
string s;
int dp[5001];
int main() {
    cin >> s;
    int n = s.size();
    dp[0] = 1;
    for (int i = 1; i <= n; i++) {
        int x = s[i-1]-'0';
        if (x >= 1 && x <= 9) dp[i] += dp[i-1];
        if (i == 1) continue;
        int y = (s[i-2]-'0')*10 + x;
        if (y >= 10 && y <= 26) dp[i] += dp[i-2];
    }
    cout << dp[n] << endl;
    return 0;
}

먼저 dp[0] = 1이 초기화되어 있습니다. 이는 s[0]~s[0]까지의 부분 문자열에서 마지막 두 자리만을 사용하여 만들 수 있는 부분 문자열의 개수를 의미합니다.
for문에서 i = 1부터 n까지 순회하면서 s[i-1]까지의 부분 문자열에서 마지막 두 자리만을 사용하여 만들 수 있는 부분 문자열의 개수를 구합니다.
int x = s[i-1]-'0'는 s[i-1]의 숫자 형식으로 변환하는 과정입니다. 예를 들어 s[i-1] = '2'일 경우, x = 2로 변환됩니다.
if (x >= 1 && x <= 9) dp[i] += dp[i-1]은 s[i-1]이 1~9사이일 경우에만 가능한 경우입니다. 그래서 dp[i-1]을 더해줘야 합니다.
만약 s[i-1]이 0이라면 dp[i-1]은 더하지 않아야 합니다.
그 다음, int y = (s[i-2]-'0')*10 + x는 s[i-2]과 s[i-1]을 합쳐 한 자리 수로 만드는 과정입니다. 예를 들어 s[i-2] = '2', s[i-1] = '3'일 경우, y = 23로 변환됩니다.
if (y >= 10 && y <= 26) dp[i] += dp[i-2]는 y가 10~26사이일 경우에만 가능한 경우입니다. 그래서 dp[i-2]를 더해줘야 합니다.
마지막으로, cout << dp[n] << endl은 s[0]~s[n-1]까지의 부분 문자열에서 마지막 두 자리만을 사용하여 만들 수 있는 부분 문자열의 개수를 출력합니다.

<C#>
using System;

namespace Main {
	class Program {
		static void Main(string[] args) {
			string s = Console.ReadLine();
			int n = s.Length;
			int[] dp = new int[n+1];
			dp[0] = 1;
			
			for (int i = 1; i <= n; i++) {
				int x = s[i-1] - '0';
				if (x >= 1 && x <= 9) dp[i] += dp[i-1];
				
				if (i >= 2) {
					int y = (s[i-2] - '0') * 10 + x;
					if (y >= 10 && y <= 26) dp[i] += dp[i-2];
				}
			}
			
			Console.WriteLine(dp[n]);
		}
	}
}
 */
package SWCert_PRO;

import java.util.Scanner;

public class Prg_Pro_B2011_DP_Password {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int n = s.length();
		int[] dp = new int[n + 1];
		dp[0] = 1;
		
		for (int i = 1; i <= n; i++) {
			int x = s.charAt(i - 1) - '0';
			if (x >= 1 && x <= 9) dp[i] += dp[i - 1];
			
			if (i >= 2) {
				int y = (s.charAt(i - 2) - '0') * 10 + x;
				if (y >= 10 && y <= 26) dp[i] += dp[i - 2];
			}
		}
		
		System.out.println(dp[n]);
	}
}
