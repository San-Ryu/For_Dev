package SwCert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
[]더하기
 
[문제]
덧셈을 못하는 철수를 공부시키기 위해 자연수들을 주고, 그 중에 몇 개의 수를 골라서 그 합이 K가 될 수 있는지 알아보라고 시켰다.
철수 어머니가 자연수들을 무작위로 선택해서 본인도 가능한지 아닌지 모르고 있다. 어머니가 채점을 할 수 있게 주어진 문제의 답을 찾아주자.

[입력]
첫 번째 줄에 테스트 케이스 개수 T(1≤T≤10)가 주어진다.
두 번째 줄부터 아래 내용이 T개 만큼 주어진다.
첫 줄에 자연수 개수 N(5 <= N <= 20)과 K(1 <= K <= 2,000,000)가 공백으로 구분되어 입력된다.
다음 줄에 N개의 자연수 di(1 <= di <= 100,000)가 공백으로 구분되어 입력된다.

[출력]
T줄에 걸쳐 각 테스트 케이스 별로 주어진 자연수 중 몇 개의 합이 K가 되면 “YES”를 아니면 “NO”를 출력한다.
*/
/* DFS 함수 설계 비법
 
0) Main 생성
  for(int testcase = 0; testcase <T; testcase++){
  
  if(DFS(1,0) == 1){
  	System.out.println("Yes");
  }else{
  	System.out.println("No");  
  }
 
1) 파라미터
   pos -> 사용할 숫자의 위치(index)
   sum -> pos 이전까지의 누적 합

2) 리턴 값
       무조건 int 아니면 void
     (1) int -> 성공하면 1, 실패하면 0
     (2) void -> 다 돌아봐야 아는것(ex:Count구하기)
   
3) 종료 조건   
    먼저체크 (1) sum == k 값을 찾았으면 -> return 1; 성공
       (2) pos = N + 1 -> return 0; 실패

4) 가지치기
  sum + a[pos] > k

     
   // [1] 함수 형태 및 파라미터 생성
   int DFS(int pos, int sum){
   
   // [2] 종료조건 생성
   if(sum==k) return 1; // 성공
   if(pos==N+1) return 0; // 실패
   

   // [4] 가지치기
   if(sum+a[pos] <= k){
   // [3-1] 사용하는 경우(o) 재귀호출 ( 만약 여기에서 발견되면 1(성공)값 리턴 ) 
    if(DFS(pos+1, sum+a[pos]) == 1) return 1; // 성공
   }
   
   // [3-2] 사용하지 않는 경우(x) 재귀호출 ( 만약 여기에서 발견되면 1(성공)값 리턴 )
    if(DFS(pos+1,sum) == 1) return 1; // 성공
    
   
   return 0; // 실패
   }
*/
public class SWCert_AD_DFS_Addition01 {
//사이트 제출 시에는 반드시 Class명을 Main으로 지정해야함
//public class Main{
	// 테스트 케이스 개수
	static int T;
	// 자연수 개수
	static int N;
	// 만들어야하는 숫자 값
	static int K;
	// 자연수 배열
	static int[] a;

	// [1] 함수 형태 및 파라미터 생성
	static int DFS(int pos, int sum) { // 넘어온 파라미터는 변경되어 사용하면 안됨. ex: pos + 1 (ok), pos++ (x)

		// 여기에다가 가지치기를 할수도 있음. ex) if(sum > k) return 0;

		// [2] 종료조건
		if (sum == K)
			return 1; // 합계(sum)가 찾아야 하는값(K)와 같으면 성공
		if (pos == N)
			return 0; // 위치값(pos)이 자연수의 개수(N)+1이랑 같으면 실패

		// [4] 가지치기
		// 만약 합계(sum)와 현재 위치값(pos)의 배열을 더한값이 찾아야하는 값(K) 보다 작을때만 수행함. 크면 찾을필요 없음.
		if (sum + a[pos] <= K) {
			// [3]재귀호출 1: 해당 숫자값을 사용하는 경우(o), pos++ 은 안됨. 아래 pos +1에서 사용되기 때문에
			if (DFS(pos + 1, sum + a[pos]) == 1)
				return 1; // 하위 return 에서 올라온 값이 1(성공)이면 다시 1(성공)을 리턴
		}
		// [3]재귀호출 2: 해당 숫자값을 사용하지 않는 경우(x)
		if (DFS(pos + 1, sum) == 1)
			return 1;

		return 0; // 실패
	}

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("test18.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int testcase = 0; testcase < T; testcase++) {

			N = sc.nextInt();
			K = sc.nextInt();
			a = new int[N];
			// 만약 1번 부터 호출하면 배열의 크기도 N으로 잡아야하고, DFS의 pos도 0으로 넘겨야하고, 종료조건도 N+1이 아닌 N으로 해야함.
			// 이 부분 수정 필요 : a = new int[N];
			// 이 부분 수정 필요 : if(DFS(0,0) == 1){
			// 이 부분 수정 필요 : if(pos == N) return 0
			for (int i = 0; i < N; i++) {
				a[i] = sc.nextInt();
			}

			if (DFS(0, 0) == 1) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
