// flatten - Ä«¿îÆÃ
package SWCert_InClass_Practice;

import java.util.Scanner;

public class P02Flatten2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] cnt = new int[101];
				
		for (int tc = 1; tc <= 10; tc++)
		{
			int dumpCnt = sc.nextInt();

			for (int i = 0; i <= 100; i++)
				cnt[i] = 0;

			for (int i = 0; i < 100; i++)
			{
				int t = sc.nextInt();
				cnt[t]++;
			}
			int min = 0, max = 100;
			
			for (int i = 0; i <= dumpCnt; i++)
			{
				while (cnt[min] == 0) min++;
				while (cnt[max] == 0) max--;

				if (i == dumpCnt || (max - min) <= 1)
					break;
				cnt[min]--; cnt[min + 1]++;
				cnt[max]--; cnt[max - 1]++;
			}
			System.out.println("#" + tc + " " + (max - min));
		}
		sc.close();
	}
}
