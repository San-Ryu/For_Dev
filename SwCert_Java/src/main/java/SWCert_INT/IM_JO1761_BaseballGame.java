/*	숫자 야구게임
[문제]
정보문화진흥원 정보 영재 동아리에서 동아리 호라동을 하던 영수와 민혁이는 쉬는 시간을 틈타 숫자 야구 게임을 하기로 했다.

1) 영수는 1에서 9까지의 서로 다른 숫자 세 개로 구성된 세자리 수를 마음속으로 생각한다.
2) 민혁이는 1에서 9까지의 서로 다를 숫자 세 개로 구성된 세자리 수를 영수에게 묻는다.
3) 민혁이가 말한 세자리 수에 있는 숫자들 중 하나가 영수의 세자리 수의 동일한 자리에 위치하면 스트라이크 한 번으로 센다.
숫자가 영수의 세자리 수에 있긴 하나 다른 자리에 위치하면 볼 한번으로 센다

예를 들어, 영수가 324를 갖고 있으면
429는 1 스트라이크 1볼이다.
241은 0 스트라이크 2볼이다.
924는 2 스트라이크 0볼이다.

영수는 민혁이가 말한 수가 몇 스트라이크 몇 볼인지를 답해준다.

민혁이가 영수의 세자리 수를 정확하게 맞추어 3 스트라이크가 되면 게임이 끝나다.
아니라면 민혁이는 새로운 수를 생각해 다시 영수에게 묻는다

현재 민혁이와 영수는 게임을 하고 있다.
민혁이가 영수에게 어떤 수들을 물어보았는지, 그리고 각각의 물음에 영수가 어떤 대답을 하였는지가 입력으로 주어진다.
이 입력을 바탕으로 여러분은 영수가 생각하고 있을 가능성이 있는 수가 총 몇개인지 알아맞혀야 한다.

아래와 같은 경우를 생각해보자

민혁 : 123
영수 : 1 스트라이크 1볼
민혁 : 356
영수 : 1 스트라이크 0볼
민혁 : 327
영수 : 2 스트라이크 0볼
민혁 : 489
영수 : 0 스트라이크 1볼

이 때 가능한 답은 324와 328, 이렇게 두가지이다.

영수는 동아리의 규율을 잘 따르는 착한 아이라 민혁이의 물음에 곧이곧대로 정직하게 답한다.
그러므로 영수의 답들에는 모순이 없다.

민혁이의 물음들과 각각의 물음에 대한 영수의 답이 입력으로 주어질 때,
영수가 생각하고 있을 가능성이 있는 답의 총 개수를 출력하는 프로그램을 작성하시오.

[입력]
첫쨰 줄에는 민혁이가 영수에게 몇 번이나 질문을 했는지 나타내는, 1 이상 100 이하의 자연수 N이 주어진다.
이어지는 N개의 줄에는 각 줄마다 민혁이가 질문한 세자리 수와 영수가 답한 스트라이크 개수를 나타내는 정수와 볼의 개수를 나타내는 정수,
이렇게 총 세개의 정수가 빈 칸을 사이에 두고 주어진다.

[출력]
첫 줄에 영수가 생각하고 있을 가능성이 있는 답의 총 개수를 출력한다.

[입력 예시]
4
123 1 1
356 1 0
327 2 0
489 0 1

[출력 예시]
2
 */
package SWCert_INT;

import java.util.*;
import java.io.*;

public class IM_JO1761_BaseballGame {
	   static int N;
	   static int[][] input;
	   static int number, strike, ball;

	   public static void main(String[] args) throws Exception{
	      Scanner sc = new Scanner(System.in);

	      N = sc.nextInt();

	      input = new int[N][5];
	      for (int i = 0; i < N; i++) {
	         number = sc.nextInt();
	         strike = sc.nextInt();
	         ball = sc.nextInt();

	         input[i][0] = number / 100;
	         input[i][1] = (number - (input[i][0] * 100)) / 10;
	         input[i][2] = (number - (input[i][0] * 100)) - (input[i][1] * 10);
	         input[i][3] = strike;
	         input[i][4] = ball;
	      }
	      
	      int result = 0;

	      for (int i = 1; i <= 9; i++) {
	         for (int j = 1; j <= 9; j++) {
	            if (i == j)
	               continue;
	            for (int k = 1; k <= 9; k++) {
	               if (i == k)
	                  continue;
	               if (j == k)
	                  continue;

	               boolean possibleYn = true;
	               for (int l = 0; l < N; l++) {

	                  strike = 0;
	                  ball = 0;

	                  // 첫번째 자리 체크
	                  if (i == input[l][0]) {
	                     strike++;
	                  } else if (i == input[l][1] || i == input[l][2]) {
	                     ball++;
	                  }

	                  // 두번째 자리 체크
	                  if (j == input[l][1]) {
	                     strike++;
	                  } else if (j == input[l][0] || j == input[l][2]) {
	                     ball++;
	                  }

	                  // 세번째 자리 체크
	                  if (k == input[l][2]) {
	                     strike++;
	                  } else if (k == input[l][0] || k == input[l][1]) {
	                     ball++;
	                  }
	                  //스트라이크, 볼 둘다 아닐때
	                  if (strike != input[l][3] || ball != input[l][4]) {
	                     possibleYn = false;
	                     break;
	                  }
	               }

	               if (possibleYn) {
	                  result++;
	               }
	            }
	         }
	      }
	      System.out.print(result);
	   }
}