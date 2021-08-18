package SWCert_ETC;

import java.io.*;
import java.util.*;

public class Etc_JavaBasis_TimeCheck2 {
	static long TimeStartPoint = 0;
	static long TimeEndPoint = 0;
	static long TimeResult = 0;
	
	public static void main(String args[]) throws Exception{
		TimeStartPoint = System.currentTimeMillis();
		
		int AnsN = 0;
		int AnsN2 = 0;
		for(int i = 0; i < 100000; i++) {
			for(int j = 0; j < 100000; j++) {
				AnsN++;
				AnsN2++;
				AnsN += AnsN2;
			}
		}
		System.out.println(AnsN);
		System.out.println(AnsN2);
		
		TimeEndPoint = System.currentTimeMillis();
		TimeResult = TimeEndPoint - TimeStartPoint;
		System.out.println(TimeResult + " [ms]");
		System.out.println(TimeResult/1000 + " [sec]");
		//	System.currentTimeMillis()�쓽 Return Type�� Long�씠怨�,
		//	�떆媛꾩� MilliSecond �떒�쐞�엫�뿉 二쇱쓽
	}	//	End Main Method
}	//	End Class
