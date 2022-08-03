// �ֺ��
package SWCert_InClass_Practice;

import java.util.Scanner;
	
public class P01MaxCount {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		
		for (int tc = 1; tc <= 10; tc++)
		{
			int N = sc.nextInt();			
			int[] cnt = new int[101];	// ���� 0 ~ 100
			// �Է� �ڷ��� �ִ밪 �Ǵ� �ִ� ũ�⸦ Ȯ���Ѵ�.
			
			for (int i = 0; i < 1000; i++)
			{
				int t = sc.nextInt();
				cnt[t]++;
			}

			int maxIdx = 0;
			for (int i = 1; i <= 100; i++)
				if (cnt[maxIdx] <= cnt[i])
					maxIdx = i;
			
			System.out.println("#" + tc + " " + maxIdx);		
		}
		sc.close();
	}
}
