package SWCert_ETC;

import java.io.*;
import java.util.*;

public class Etc_JavaBasis_Rand {
	static int T;

	public static void main(String[] args) throws Exception{
		Random rand = new Random();
		
		T = 10;
		for(int tc = 0; tc < T; tc++) {
				System.out.println("#" + tc + " " + rand.nextInt()%100 + " ");
				// �젅�뙎媛� 100 �씠�븯 �젙�닔瑜� �옖�뜡�븯寃� �샇異�
		}	//	End Test Case A
		
		for(int tc = 0; tc < T; tc++) {
			System.out.println("#" + tc + " " + Math.abs(rand.nextInt())%100 + " ");	
			// �젅�뙎媛� 100 �씠�븯 �옄�뿰�닔瑜� �옖�뜡�븯寃� �샇異�
	}	//	End Test Case B
	}	//	End Main
}	//	End Class