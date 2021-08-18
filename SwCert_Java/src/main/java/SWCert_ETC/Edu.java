package SWCert_ETC;

import java.io.*;
import java.util.*;

public class Edu {
	public static void main(String[] args[]) {
		String aaa = "abc";
		String bbb = aaa;
		String ccc = new String("abc");
		
		System.out.println("aaa bbb ccc �씪移섏꽦");
		if(aaa == bbb)
			System.out.println("aaa == bbb");
		if(bbb == ccc)
			System.out.println("bbb == ccc");
		if(ccc == aaa)
			System.out.println("aaa == ccc");
		System.out.println("=====================End=====================");
		
		System.out.println(aaa.intern());
		System.out.println(bbb.intern());
		System.out.println(ccc.intern());
		
		// String�� �긽�닔�쓽 ���쓣 �궗�슜�븳�떎.
		// 媛숈� 媛믪쓣 �븷�떦�븯硫�, �긽�닔 ���뿉�꽌�쓽 媛믪쓽 李몄“媛�(硫붾え由� 二쇱냼)瑜� 媛��졇�삩�떎.
		// String�쓽 Hashcode�뒗 �떎瑜� Reference���뒗 �떎瑜닿쾶 �떎�젣 媛믪쓣 媛��졇�삩�떎.
		// 洹몃옒�꽌 Identify Hash Code �븿�닔濡� 二쇱냼媛� �솗�씤
		
		String strA = "A";
		String strB = "B";
		String strC = "C";
	}	//	End Main
}	//	End Class