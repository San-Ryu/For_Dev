package SWCert_InClass;

import java.io.*;
import java.util.*;

public class Day4_Coin {
	static int Coin[] = {10, 5, 4, 1};
	static int Choices[] = new int [100];
	static int Memo[] = new int [100];
	
	static int min = 0xffffff;
	public static int CoinChange(int Money) {
		if(Money == 0)	return 0;
		if(Memo[Money] != 0) return Memo[Money];
		
		int min = 0xffffff;
		for(int i = 0; i < Coin.length; i++) {
			if(Coin[i] > Money)	continue;
			int ret = CoinChange(Money - Coin[i]);
			min = Math.min(min, ret);
		}
		
		return Memo[Money] = min + 1;
	}
	
	public static void main(String args[]) throws Exception{
		System.out.println(CoinChange(13));
	}
}	//	End Class