package SWCert_ETC;

import java.io.*;
import java.util.*;

public class Etc_JavaBasis_TimeCheck {
	static long TimeStartPoint = 0;
	static long TimeEndPoint = 0;
	static long TimeResult = 0;
	
	public static void main(String args[]) throws Exception{
		TimeStartPoint = System.currentTimeMillis();
		
		/*
		 * 
		 * 	痢≪젙 ���긽 (肄붾뱶)
		 * 
		 */
		
		TimeEndPoint = System.currentTimeMillis();
		TimeResult = TimeEndPoint - TimeStartPoint;
		System.out.println(TimeResult + " [ms]");
		System.out.println(TimeResult/1000 + " [sec]");
		//	System.currentTimeMillis()�쓽 Return Type�� Long�씠怨�,
		//	�떆媛꾩� MilliSecond �떒�쐞�엫�뿉 二쇱쓽
	}	//	End Main Method
}	//	End Class