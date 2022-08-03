package SWCert_InClass_Practice;

import java.util.Scanner;

public class  P02Flatten1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[100];
				
		for (int tc = 1; tc <= 10; tc++)
		{
			int dumpCnt = sc.nextInt();

			for (int i = 0; i < 100; i++)
				arr[i] = sc.nextInt();
			
			int minIdx = 0, maxIdx = 0;
			for (int cnt = 0; cnt <= dumpCnt; cnt++)
			{
				minIdx = maxIdx = 0;
				for(int i = 1; i < 100; i++)
				{
					if(arr[minIdx] > arr[i]) minIdx = i;
					if(arr[maxIdx] < arr[i]) maxIdx = i;
				}

				if (cnt == dumpCnt || (arr[maxIdx] - arr[minIdx]) <= 1)
					break;
				arr[minIdx]++; arr[maxIdx]--;
			}
			System.out.println("#" + tc + " " + (arr[maxIdx] - arr[minIdx]));
		}
		sc.close();
	}
}
