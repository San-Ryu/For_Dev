package SWCert_InClass;

import java.io.*;
import java.util.*;

public class Day4_Coin2 {
	static int Coin[] = {10, 5, 4, 1};
	static int Choices[] = new int [100];
	
	static int min = 0xffffff;
	public static void CoinChange(int k, int Money) {
		if(min <= k) return;
		if(Money == 0)	{
			if(min > k) {
				min = k;
				for(int i = 0; i < k; i++) {
					System.out.println(Choices[i] + " ");
					System.out.println();
				}
			}
			
			return;
		}
		
		//	내가 할 수 있는 선택지의 수만큼
		for(int i = 0; i < Coin.length; i++) {
			if(Money < Coin[i])	continue;
			Choices[k] = Coin[i];
			CoinChange(k + 1, Money - Coin[i]);
		}
	}
	
	public static void main(String args[]) throws Exception{
		CoinChange(0, 13);
	}
}	//	End Class