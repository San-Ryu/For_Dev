package SWCert_InClass;

import java.io.*;
import java.util.*;

public class Day4_NQueen {
	
	static int cnt =- 0;
	static int cols[] = new int[8];
	
	static boolean isPossible(int k, int col) {
		for(int i = 0; i < k; i++) {
			if((k - i) == Math.abs(cols[i] - col))	return false;
		}
		return true;	//	��� �˻��ص� �ɸ��°� ���ٸ�
	}
	
	static void nQueen(int k, int n, int Stat) {
		if(k == n)	{
			cnt++;
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if((Stat & (1 << i)) != 0)	continue;
			if(!isPossible(k, i))	continue;	//	���࿡ �밢���� �ϳ��� �ɸ��ٸ�, ���� �ƴϹǷ� ����ġ��
			cols[k] = 1;
			nQueen(k + 1, n, Stat | (1 << i));
		}
	}
	
	public static void main(String args[]) throws Exception{
		nQueen(0, 8, 0);
		System.out.println(cnt);
	}	//	End Main
}	//	End Class