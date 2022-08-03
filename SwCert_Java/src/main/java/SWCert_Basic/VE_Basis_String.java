package SWCert_Basic;

import java.util.*;

public class VE_Basis_String {
	public static void main(String args[]) throws Exception{
		//	Integer To String
		int n = 100;
		String str1 = String.valueOf(n);
		String str2 = Integer.toString(n);
		System.out.println(str1 + " / " + str2);
		
		//	String To Integer
		String str = "100";
		int int1 = Integer.parseInt(str);
		//	방법 1. 양수와 음수 모두 인식 가능
		int int2 = Integer.valueOf(str);
		//	방법 2. 양수만 변환 가능 (parseInt를 포함)
		System.out.println(int1 + " / " + int2);
		
		int arr1[] = {1, 2, 3, 5, 7, 10, 47, 80, 443};
		System.out.println(Arrays.toString(arr1));
		
		String arr2[] = {"동", "서", "남", "북"};
		System.out.println(Arrays.toString(arr2));
		
		String str3 = Arrays.toString(arr1);
		String str4 = Arrays.toString(arr2);
		System.out.println(str3 + " / " + str4);
	}	//	End Main
}	//	End Class