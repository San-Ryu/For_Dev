package SwCert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
[]���ϱ�
 
[����]
������ ���ϴ� ö���� ���ν�Ű�� ���� �ڿ������� �ְ�, �� �߿� �� ���� ���� ��� �� ���� K�� �� �� �ִ��� �˾ƺ���� ���״�.
ö�� ��Ӵϰ� �ڿ������� �������� �����ؼ� ���ε� �������� �ƴ��� �𸣰� �ִ�. ��Ӵϰ� ä���� �� �� �ְ� �־��� ������ ���� ã������.

[�Է�]
ù ��° �ٿ� �׽�Ʈ ���̽� ���� T(1��T��10)�� �־�����.
�� ��° �ٺ��� �Ʒ� ������ T�� ��ŭ �־�����.
ù �ٿ� �ڿ��� ���� N(5 <= N <= 20)�� K(1 <= K <= 2,000,000)�� �������� ���еǾ� �Էµȴ�.
���� �ٿ� N���� �ڿ��� di(1 <= di <= 100,000)�� �������� ���еǾ� �Էµȴ�.

[���]
T�ٿ� ���� �� �׽�Ʈ ���̽� ���� �־��� �ڿ��� �� �� ���� ���� K�� �Ǹ� ��YES���� �ƴϸ� ��NO���� ����Ѵ�.
*/
/* DFS �Լ� ���� ���
 
0) Main ����
  for(int testcase = 0; testcase <T; testcase++){
  
  if(DFS(1,0) == 1){
  	System.out.println("Yes");
  }else{
  	System.out.println("No");  
  }
 
1) �Ķ����
   pos -> ����� ������ ��ġ(index)
   sum -> pos ���������� ���� ��

2) ���� ��
       ������ int �ƴϸ� void
     (1) int -> �����ϸ� 1, �����ϸ� 0
     (2) void -> �� ���ƺ��� �ƴ°�(ex:Count���ϱ�)
   
3) ���� ����   
    ����üũ (1) sum == k ���� ã������ -> return 1; ����
       (2) pos = N + 1 -> return 0; ����

4) ����ġ��
  sum + a[pos] > k

     
   // [1] �Լ� ���� �� �Ķ���� ����
   int DFS(int pos, int sum){
   
   // [2] �������� ����
   if(sum==k) return 1; // ����
   if(pos==N+1) return 0; // ����
   

   // [4] ����ġ��
   if(sum+a[pos] <= k){
   // [3-1] ����ϴ� ���(o) ���ȣ�� ( ���� ���⿡�� �߰ߵǸ� 1(����)�� ���� ) 
    if(DFS(pos+1, sum+a[pos]) == 1) return 1; // ����
   }
   
   // [3-2] ������� �ʴ� ���(x) ���ȣ�� ( ���� ���⿡�� �߰ߵǸ� 1(����)�� ���� )
    if(DFS(pos+1,sum) == 1) return 1; // ����
    
   
   return 0; // ����
   }
*/
public class SWCert_AD_DFS_Addition01 {
//����Ʈ ���� �ÿ��� �ݵ�� Class���� Main���� �����ؾ���
//public class Main{
	// �׽�Ʈ ���̽� ����
	static int T;
	// �ڿ��� ����
	static int N;
	// �������ϴ� ���� ��
	static int K;
	// �ڿ��� �迭
	static int[] a;

	// [1] �Լ� ���� �� �Ķ���� ����
	static int DFS(int pos, int sum) { // �Ѿ�� �Ķ���ʹ� ����Ǿ� ����ϸ� �ȵ�. ex: pos + 1 (ok), pos++ (x)

		// ���⿡�ٰ� ����ġ�⸦ �Ҽ��� ����. ex) if(sum > k) return 0;

		// [2] ��������
		if (sum == K)
			return 1; // �հ�(sum)�� ã�ƾ� �ϴ°�(K)�� ������ ����
		if (pos == N)
			return 0; // ��ġ��(pos)�� �ڿ����� ����(N)+1�̶� ������ ����

		// [4] ����ġ��
		// ���� �հ�(sum)�� ���� ��ġ��(pos)�� �迭�� ���Ѱ��� ã�ƾ��ϴ� ��(K) ���� �������� ������. ũ�� ã���ʿ� ����.
		if (sum + a[pos] <= K) {
			// [3]���ȣ�� 1: �ش� ���ڰ��� ����ϴ� ���(o), pos++ �� �ȵ�. �Ʒ� pos +1���� ���Ǳ� ������
			if (DFS(pos + 1, sum + a[pos]) == 1)
				return 1; // ���� return ���� �ö�� ���� 1(����)�̸� �ٽ� 1(����)�� ����
		}
		// [3]���ȣ�� 2: �ش� ���ڰ��� ������� �ʴ� ���(x)
		if (DFS(pos + 1, sum) == 1)
			return 1;

		return 0; // ����
	}

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("test18.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int testcase = 0; testcase < T; testcase++) {

			N = sc.nextInt();
			K = sc.nextInt();
			a = new int[N];
			// ���� 1�� ���� ȣ���ϸ� �迭�� ũ�⵵ N���� ��ƾ��ϰ�, DFS�� pos�� 0���� �Ѱܾ��ϰ�, �������ǵ� N+1�� �ƴ� N���� �ؾ���.
			// �� �κ� ���� �ʿ� : a = new int[N];
			// �� �κ� ���� �ʿ� : if(DFS(0,0) == 1){
			// �� �κ� ���� �ʿ� : if(pos == N) return 0
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
